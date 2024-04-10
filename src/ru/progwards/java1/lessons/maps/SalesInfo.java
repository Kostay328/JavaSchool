package ru.progwards.java1.lessons.maps;

import java.io.*;
import java.util.*;

public class SalesInfo {

    public int loadOrders(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        int quantity = Integer.parseInt(parts[2]);
                        double amount = Double.parseDouble(parts[3]);
                        count++;
                    } catch (NumberFormatException e) { }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> goods = new TreeMap<>();
        return goods;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> customers = new TreeMap<>();
        return customers;
    }

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        // Здесь должен быть код для загрузки данных из файла и тестирования методов
    }
}
