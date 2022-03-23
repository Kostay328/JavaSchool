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

    public static void main(String[] args) {
        Hamster h1 = new Hamster("Поликарп");
        h1.setWeight(5);
        Hamster h2 = new Hamster("Поликарп");
        h2.setWeight(6);
        Duck d1 = new Duck("Поликарп");
        d1.setWeight(15);
        Animal[] al = new Animal[3];
        al[0] = d1;
        al[1] = h2;
        al[2] = h1;
        System.out.println(al[0]);
        System.out.println(al[1]);
        System.out.println(al[2]);
        sort(al);
        System.out.println(al[0]);
        System.out.println(al[1]);
        System.out.println(al[2]);
    }
}
