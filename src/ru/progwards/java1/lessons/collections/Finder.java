package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        List<Integer> nums = new ArrayList<>(numbers);
        List<Integer> lokalMaxRecord = new ArrayList<>();
        ListIterator<Integer> iterator = nums.listIterator();
        int last = iterator.next();
        int current = iterator.next();

        while (iterator.hasNext()) {

            int next = iterator.next();
            if (current > next && current > last) {
                lokalMaxRecord.add(current);
            }
            last = current;
            current = next;

        }
        return lokalMaxRecord;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        Collection<Integer> res = new ArrayList<>();
        for (int i = 1; i <= numbers.size(); i++)
            res.add(i);
        return numbers.containsAll(res);
    }

    public static String findSimilar(Collection<String> names) {
        Iterator<String> nl = names.iterator();
        String name = nl.next();
        int max = 1;
        int current = 1;
        String cName = nl.next();
        String pName;
        while (nl.hasNext()) {
            pName = cName;
            cName = nl.next();
            if (cName.equals(pName)) {
                current++;
                if (current > max) {
                    name = cName;
                    max = current;
                }
            } else {
                current = 1;
            }
        }
        return name + ":" + max;
    }
}