package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FiboMapCache {

    private final boolean cacheEnabled;
    private final Map<Integer, BigDecimal> fiboCache;

    public FiboMapCache(boolean cacheOn) {
        this.cacheEnabled = cacheOn;
        this.fiboCache = cacheOn ? new ConcurrentHashMap<>() : null;
    }

    public BigDecimal fiboNumber(int n) {
        if (cacheEnabled && fiboCache != null) {
            BigDecimal result = fiboCache.get(n);
            if (result == null) {
                result = calculateFibonacci(n);
                fiboCache.put(n, result);
            }
            return result;
        } else {
            return calculateFibonacci(n);
        }
    }

    private BigDecimal calculateFibonacci(int n) {
        BigDecimal a = BigDecimal.ONE, b = BigDecimal.ONE;
        for (int i = 3; i <= n; i++) {
            BigDecimal temp = a.add(b);
            a = b;
            b = temp;
        }

        return b;
    }

    public void clearCahe() {
        fiboCache.clear();
    }

    public static void test() {
        long startTime, endTime;
        FiboMapCache cacheOnTrue = new FiboMapCache(true);
        FiboMapCache cacheOnFalse = new FiboMapCache(false);

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            cacheOnTrue.fiboNumber(i);
        }
        endTime = System.currentTimeMillis();
        long timeWithCache = endTime - startTime;

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            cacheOnFalse.fiboNumber(i);
        }
        endTime = System.currentTimeMillis();
        long timeWithoutCache = endTime - startTime;

        System.out.printf("fiboNumber cacheOn=true время выполнения: %d %n", timeWithCache);
        System.out.printf("fiboNumber cacheOn=false время выполнения: %d", timeWithoutCache);
    }

    public static void main(String[] args) {
        test();
    }
}
