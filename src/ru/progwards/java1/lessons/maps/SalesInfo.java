package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {
    class Buy {
        String name;
        String good;
        int qty;
        double sum;

        Buy(String byr) throws Exception {
            String[] buyer = byr.split(",");
            if (buyer.length != 4) throw new Exception();
            this.name = buyer[0].trim();
            this.good = buyer[1].trim();
            this.qty = Integer.parseInt(buyer[2].trim());
            this.sum = Double.parseDouble(buyer[3].trim());
        }
    }
    private List<Buy> buys = new ArrayList<>();


    public int loadOrders(String fileName) {
        int count = 0;
        try (FileReader reader = new FileReader(fileName); Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();
                try {
                    buys.add(new Buy(currLine));
                    count++;
                } catch (Exception e) { }
            }
        } catch (Exception e) { }
        return count;
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> res = new TreeMap<>();
        for (Buy currBuy : buys) {
            if (res.putIfAbsent(currBuy.good, currBuy.sum) != null)
                res.replace(currBuy.good, res.get(currBuy.good) + currBuy.sum);
        }
        return res;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> res = new TreeMap<>();
        for (Buy currBuy : buys) {
            if (res.putIfAbsent(currBuy.name, new AbstractMap.SimpleEntry<>(currBuy.sum, currBuy.qty)) != null) {
                AbstractMap.SimpleEntry<Double, Integer> currEntry = res.get(currBuy.name);
                AbstractMap.SimpleEntry<Double, Integer> newEntry = new AbstractMap.SimpleEntry<>(currEntry.getKey() + currBuy.sum, currEntry.getValue() + currBuy.qty);
                res.replace(currBuy.name, newEntry);
            }
        }
        return res;
    }
}