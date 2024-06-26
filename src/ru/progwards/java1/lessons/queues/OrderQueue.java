package ru.progwards.java1.lessons.queues;

import java.util.PriorityQueue;
import java.util.Queue;

public class OrderQueue {

    Queue<Order> queue = new PriorityQueue<>((o1, o2) -> {
        int res = Integer.compare(o1.getOrderClass(), o2.getOrderClass());
        if (res == 0)
            return Integer.compare(o1.getNum(), o2.getNum());
        return res;
    });

    public void add(Order order) {
        queue.offer(order);
    }

    public Order get() {
        return queue.poll();
    }
}

class Order {
    private double sum;
    private int num;
    private static int orderNum;
    private int orderClass;

    public Order(double sum) {
        this.sum = sum;
        this.num = ++orderNum;

        if (sum <= 10000) {
            this.orderClass = 3;
        } else if (sum > 20000) {
            this.orderClass = 1;
        } else {
            this.orderClass = 2;
        }
    }

    public double getSum() {
        return sum;
    }

    public int getOrderClass() {
        return orderClass;
    }

    public int getNum() {
        return num;
    }
}