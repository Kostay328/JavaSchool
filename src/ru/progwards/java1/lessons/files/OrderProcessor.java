package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderProcessor {
    private final String startPath;
    private final Map<String, Order> orders = new HashMap<>();
    private List<Order> ordersList = new ArrayList<>();
    private int faultCount = 0;

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
                    if (Files.isDirectory(file) && !folderMatchesTimePeriod(start, finish, fileLastMdf))//отсев папок, не содержащих искомых по дате создания заказов
                        return FileVisitResult.SKIP_SUBTREE;
                    if (pathMatcher.matches(Paths.get(startPath).relativize(file))) {
                        if (fileMatchesTimePeriod(start, finish, fileLastMdf)) {  // отсев заказов с датой создания вне периода start-finish
                            String[] orderFile = file.getFileName().toString().split("[-.]"); // вычленение из названия файла shopId, orderId и customerId
                            if (shopId == null || orderFile[0].equals(shopId)) {
                                Order order = new Order();
                                order.shopId = orderFile[0];
                                order.orderId = orderFile[1];
                                order.customerId = orderFile[2];
                                order.datetime = fileLastMdf;
                                ordersList.add(order);
                                List<String> itemsList = Files.readAllLines(file);
                                try {
                                    for (String s : itemsList) {
                                        String[] itemLine = s.split(",");
                                        // проверка правильности формата строки с товаром. При ошибке извлечения данных - обработка исключения
                                        if (itemLine.length != 3) throw new NumberFormatException();
                                        OrderItem orderItem = new OrderItem();
                                        orderItem.googsName = itemLine[0].trim();
                                        orderItem.count = Integer.parseInt(itemLine[1].trim());
                                        orderItem.price = Double.parseDouble(itemLine[2].trim());

                                        order.items.add(orderItem);
                                        order.items.sort(new Comparator<OrderItem>() {
                                            @Override
                                            public int compare(OrderItem o1, OrderItem o2) {
                                                return o1.googsName.compareTo(o2.googsName);
                                            }
                                        });
                                        order.sum += orderItem.price * orderItem.count;
                                    }
                                } catch (NumberFormatException e) { // удаление order, соответствующего файлу с ошибочным содержимым
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
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faultCount;
    }

    private boolean folderMatchesTimePeriod(LocalDate start, LocalDate finish, LocalDateTime folderLastModified) {

        if (start == null && finish == null) return true; // открытый временной диапазон
        if (start == null)
            if (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish))
                return true; // если дата создания папки не позже, чем finish
        if (finish == null)
            if (folderLastModified.toLocalDate().isAfter(start.minusWeeks(1)) || folderLastModified.toLocalDate().isEqual(start.minusWeeks(1)))
                return true; // если дата создания папки не раньше, чем на неделю от start
        if (start != null && finish != null)
            return (folderLastModified.toLocalDate().isAfter(start.minusWeeks(1)) || folderLastModified.toLocalDate().isEqual(start.minusWeeks(1))) &&
                    (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish));
        return false;
    }

    private boolean fileMatchesTimePeriod(LocalDate start, LocalDate finish, LocalDateTime folderLastModified) {

        if (start == null && finish == null) return true; // открытый временной диапазон
        if (start == null)
            if (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish))
                return true; // если дата создания заказа не позже, чем finish
        if (finish == null)
            if (folderLastModified.toLocalDate().isAfter(start) || folderLastModified.toLocalDate().isEqual(start))
                return true; // если дата создания заказа не раньше, чем start
        if (start != null && finish != null)
            return (folderLastModified.toLocalDate().isAfter(start) || folderLastModified.toLocalDate().isEqual(start)) &&
                    (folderLastModified.toLocalDate().isBefore(finish) || folderLastModified.toLocalDate().isEqual(finish));
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

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor("C:\\rr\\folder 1");
        LocalDate finish = LocalDate.of(2022,8,9);
        System.out.println(orderProcessor.loadOrders(null, null, null));

//        for (Order o : orderProcessor.process(null))
//            System.out.println(o.datetime);
//        Path path = Paths.get("C:\\rr\\folder 1\\S01-P01X02-0002.csv");
//        try {
//            System.out.println(Files.setLastModifiedTime(path, FileTime.from(Instant.ofEpochSecond(LocalDateTime.of(2020,2,2,0,2).toEpochSecond(ZoneOffset.UTC)))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(Paths.get("C:\\Users\\User\\Documents\\Progwards\\test folder").relativize(Paths.get("C:\\Users\\User\\Documents\\Progwards\\test folder\\folder 1\\S01-P01X02-0002.csv")));
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





