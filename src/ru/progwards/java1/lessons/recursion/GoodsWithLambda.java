package ru.progwards.java1.lessons.recursion;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Goods {
    String name;
    String number;
    int available;
    double price;
    Instant expired;

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }
}

public class GoodsWithLambda {
    List<Goods> goodsList;

    public void setGoods(List<Goods> list) {
        goodsList = list;
    }

    public List<Goods> sortByName() {
        return goodsList.stream()
                .sorted(Comparator.comparing(goods -> goods.name))
                .collect(Collectors.toList());
    }

    public List<Goods> sortByNumber() {
        return goodsList.stream()
                .sorted(Comparator.comparing(goods -> goods.number.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Goods> sortByPartNumber() {
        return goodsList.stream()
                .sorted(Comparator.comparing(goods -> goods.number.substring(0, 3).toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Goods> sortByAvailabilityAndNumber() {
        return goodsList;
    }

    public List<Goods> expiredAfter(Instant date) {
        return goodsList.stream()
                .filter(goods -> goods.expired.isAfter(date))
                .sorted(Comparator.comparing(goods -> goods.expired))
                .collect(Collectors.toList());
    }

    public List<Goods> countLess(int count) {
        return goodsList.stream()
                .filter(goods -> goods.available < count)
                .sorted(Comparator.comparing(goods -> goods.available))
                .collect(Collectors.toList());
    }

    public List<Goods> сountBetween(int count1, int count2) {
        return goodsList.stream()
                .filter(goods -> goods.available > count1 && goods.available < count2)
                .sorted().collect(Collectors.toList());
    }
}

