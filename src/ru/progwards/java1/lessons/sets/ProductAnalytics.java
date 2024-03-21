package ru.progwards.java1.lessons.sets;

import java.util.*;

class Product {
    private String code;

    public Product(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}


public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.products = products;
    }

    public Set<Product> existInAll() {
        Set<Product> res = new HashSet<>();
        for (Shop s:shops) res.addAll(s.getProducts());
        for (Shop s:shops) res.retainAll(s.getProducts());

        return res;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> res = new HashSet<>();
        for (Shop s:shops) {
            Set<Product> oneShopAssortment = new HashSet<>(s.getProducts());
            oneShopAssortment.retainAll(products);
            res.addAll(oneShopAssortment);
        }

        return res;
    }

    public Set<Product> notExistInShops() {
        Set<Product> res = new HashSet<>(products);
        for (Shop s : shops) res.removeAll(s.getProducts());

        return res;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> res = new HashSet<>();
        return res;
    }

    public static Set<Product> symDiffProd(Set<Product> set1, Set<Product> set2) {
        Set<Product> res = new HashSet<>(set1);
        return res;
    }
}