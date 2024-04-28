package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {
    private int faultCount = 0;
    private List<Order> ordersList = new ArrayList<>();
    private final String startPath;
    private final Map<String, Order> orders = new HashMap<>();



    public OrderProcessor(String startPath) {
        this.startPath = startPath;
    }


    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*/???-??????-????.csv");
        try {
            Files.walkFileTree(Paths.get(startPath), Collections.emptySet(), 2, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    LocalDateTime fileLastMdf = LocalDateTime.ofInstant(Files.getLastModifiedTime(file).toInstant(), ZoneId.systemDefault());
                    if (Files.isDirectory(file) && !fileMatchesTimePeriod(start, finish, fileLastMdf, false))
                        return FileVisitResult.SKIP_SUBTREE;
                    if (pathMatcher.matches(Paths.get(startPath).relativize(file))) {
                        if (fileMatchesTimePeriod(start, finish, fileLastMdf, true)) {
                            String[] orderFile = file.getFileName().toString().split("[-.]");
                            if (shopId == null || orderFile[0].equals(shopId)) {
                                Order order = new Order(orderFile[0], orderFile[1], orderFile[2], fileLastMdf);
                                ordersList.add(order);
                                List<String> itemsList = Files.readAllLines(file);
                                try {
                                    for (String s : itemsList) {
                                        String[] itemLine = s.split(",");
                                        if (itemLine.length != 3) throw new NumberFormatException();
                                        OrderItem orderItem = new OrderItem();
                                        orderItem.googsName = itemLine[0].trim();
                                        orderItem.count = Integer.parseInt(itemLine[1].trim());
                                        orderItem.price = Double.parseDouble(itemLine[2].trim());

                                        order.items.add(orderItem);
                                        order.items.sort(Comparator.comparing(o -> o.googsName));
                                        order.sum += orderItem.price * orderItem.count;
                                    }
                                } catch (NumberFormatException e) {
                                    ordersList.remove(order);
                                    faultCount++;
                                    return FileVisitResult.CONTINUE;
                                }
                            }
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faultCount;
    }

    private boolean fileMatchesTimePeriod(LocalDate start, LocalDate finish, LocalDateTime folderLastModified, boolean isFile) {
        if (start == null && finish == null) return true;
        if (start == null)
            if (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish))
                return true;
        if (finish == null) {
            if(isFile) {
                if (folderLastModified.toLocalDate().isAfter(start) || folderLastModified.toLocalDate().isEqual(start))
                    return true;
            }else
                if (folderLastModified.toLocalDate().isAfter(start.minusWeeks(1)) || folderLastModified.toLocalDate().isEqual(start.minusWeeks(1)))
                    return true;
        }
        if (start != null && finish != null) {
            if(isFile)
                return (folderLastModified.toLocalDate().isAfter(start) || folderLastModified.toLocalDate().isEqual(start)) &&
                        (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish));
                return (folderLastModified.toLocalDate().isAfter(start.minusWeeks(1)) || folderLastModified.toLocalDate().isEqual(start.minusWeeks(1))) &&
                        (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish));
        }
        return false;
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





