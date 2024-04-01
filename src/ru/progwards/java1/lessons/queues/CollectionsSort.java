package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        List<Integer> srt = new ArrayList<>(data);

        for (int i = 0; i < data.size(); i++) {
            ListIterator<Integer> iter = srt.listIterator(i);
            Integer min = iter.next();
            while (iter.hasNext()) {
                Integer curr = iter.next();
                if (min > curr) {
                    Collections.swap(srt, srt.indexOf(min), srt.lastIndexOf(curr));
                    min = curr;
                }
            }
        }
        Collections.copy((List<Integer>) data, srt);
    }

    public static void minSort(Collection<Integer> data) {
        List<Integer> dataList = new ArrayList<>(data);
        List<Integer> minSort = new ArrayList<>();
        while (!dataList.isEmpty()) {
            minSort.add(Collections.min(dataList));
            dataList.remove(Collections.min(dataList));
        }
        Collections.copy((List<Integer>) data, minSort);
    }

    public static void collSort(Collection<Integer> data) {
        Collections.sort((List<Integer>) data);
    }

    public static Collection<String> compareSort() {
        return new TreeSet<>();
    }
}