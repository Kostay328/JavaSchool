package ru.progwards.java1.lessons.interfaces2;

public class ArraySort {
    public static void sort(CompareWeight[] a){
        for (int i = 1; i < a.length; i++) {
            if (a[i].getWeight() < a[i - 1].getWeight()) {
                CompareWeight t0 = a[i];
                a[i] = a[i-1];
                a[i-1] = t0;
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (a[j].getWeight() < a[j - 1].getWeight()) {
                        CompareWeight t1 = a[j];
                        a[j] = a[j-1];
                        a[j-1] = t1;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
