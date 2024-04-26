package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private final String startPath;
    private final Map<String, Order> orders = new HashMap<>();

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        AtomicInteger errorCount = new AtomicInteger();
        try {
            Files.walk(Paths.get(startPath))
                    .filter(path -> path.toString().endsWith(".csv"))
                    .forEach(path -> {
                        if (path.toString().contains(shopId) &&
                                (start == null || path.toFile().lastModified() >= start.atStartOfDay(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli()) &&
                                (finish == null || path.toFile().lastModified() <= finish.atStartOfDay(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli())) {
                            try {
                                String shopIdFromFile = path.getFileName().toString().split("-")[0];
                                if (!shopIdFromFile.equals(shopId)) {
                                    errorCount.set(errorCount.getAndIncrement());
                                    return;
                                }
                                String orderId = path.getFileName().toString().split("-")[1];
                                String customerId = path.getFileName().toString().split("-")[3].split(".")[0];
                                LocalDateTime datetime = LocalDateTime.ofInstant(
                                        java.time.Instant.ofEpochMilli(path.toFile().lastModified()), ZoneId.of("Europe/Moscow")
                                );
                                Order order = new Order(shopId, orderId, customerId, datetime);
                                try {
                                    Files.lines(path)
                                            .skip(1) // Skip header
                                            .map(line -> line.split(","))
                                            .forEach(line -> {
                                                try {
                                                    order.addItem(new OrderItem(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2])));
                                                } catch (Exception e) {
                                                    errorCount.set(errorCount.getAndIncrement());
                                                }
                                            });
                                    orders.put(orderId, order);
                                } catch (Exception e) {

                                }
                            } catch (Exception e) {
                                errorCount.set(errorCount.getAndIncrement());
                            }
                        }
                    });
            } catch (IOException e) {
                e.printStackTrace();
            }
        return errorCount.get();
    }

    public List<Order> process(String shopId) {
        if (shopId == null) {
            return orders.values().stream().sorted(Comparator.comparing(o -> o.datetime)).collect(Collectors.toList());
        } else {
            return orders.values().stream()
            .filter(o -> o.shopId.equals(shopId))
            .sorted(Comparator.comparing(o -> o.datetime))
            .collect(Collectors.toList());
        }
    }

    public Map<String, Double> statisticsByShop() {
        return orders.values().stream()
        .collect(Collectors.groupingBy(o -> o.shopId, Collectors.summingDouble(o -> o.sum)));
    }

    public Map<String, Double> statisticsByGoods() {
        return orders.values().stream()
        .flatMap(o -> o.items.stream().map(item -> new AbstractMap.SimpleEntry<>(item.googsName, item.price * item.count)))
        .collect(Collectors.groupingBy(entry -> entry.getKey(), Collectors.summingDouble(entry -> entry.getValue())));
    }

    public Map<LocalDate, Double> statisticsByDay() {
        return orders.values().stream()
        .collect(Collectors.groupingBy(o -> o.datetime.toLocalDate(), Collectors.summingDouble(o -> o.sum)));
    }
}
class Order {
    public String shopId;
    public String orderId;
    public String customerId;
    public LocalDateTime datetime;
    public List<OrderItem> items;
    public double sum;

    public Order() {
    }

    public Order(String shopId, String orderId, String customerId, LocalDateTime datetime) {
        this.shopId = shopId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.datetime = datetime;
        this.items = new ArrayList<>();
        this.sum = 0;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        sum += item.price * item.count;
    }
}

class OrderItem {
    public String googsName;
    public int count;
    public double price;

    public OrderItem() {
    }

    public OrderItem(java.lang.String googsName, int count, double price) {
        this.googsName = googsName;
        this.count = count;
        this.price = price;
    }
}





