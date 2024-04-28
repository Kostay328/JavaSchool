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
        List<Order> result = new ArrayList<>();
        if (shopId != null) {
            for (Order order : ordersList) if (order.shopId.equals(shopId)) result.add(order);
        } else {
            result.addAll(ordersList);
        }
        result.sort(new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                if (o1.datetime.isBefore(o2.datetime)) return -1;
                if (o1.datetime.isAfter(o2.datetime)) return 1;
                return 0;
            }
        });
        return result;
    }

    public Map<String, Double> statisticsByShop() {
        Map<String, Double> statisticsByShop = new TreeMap<>();
        for (Order order : ordersList) {
            if (statisticsByShop.putIfAbsent(order.shopId, order.sum) != null) {
                Double newSum = statisticsByShop.get(order.shopId) + order.sum;
                statisticsByShop.replace(order.shopId, newSum);
            }
        }
        return statisticsByShop;
    }

    public Map<String, Double> statisticsByGoods() {
        Map<String, Double> statisticsByGoods = new TreeMap<>();
        for (Order order : ordersList) {
            for (OrderItem orderItem : order.items) {
                if (statisticsByGoods.putIfAbsent(orderItem.googsName, orderItem.price * orderItem.count) != null) {
                    Double newSum = statisticsByGoods.get(orderItem.googsName) + orderItem.price * orderItem.count;
                    statisticsByGoods.replace(orderItem.googsName, newSum);
                }
            }
        }
        return statisticsByGoods;
    }

    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> statisticsByDay = new TreeMap<>();
        for (Order order : ordersList) {
            if (statisticsByDay.putIfAbsent(order.datetime.toLocalDate(), order.sum) != null) {
                Double newSum = statisticsByDay.get(order.datetime.toLocalDate()) + order.sum;
                statisticsByDay.replace(order.datetime.toLocalDate(), newSum);
            }
        }
        return statisticsByDay;
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





