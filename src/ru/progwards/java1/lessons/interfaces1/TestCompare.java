package ru.progwards.java1.lessons.interfaces1;

import java.util.Arrays;

public class TestCompare {
    public static void main(String[] args) {

        Cow c1 = new Cow("Пеструшка");          c1.setWeight(350);
        Cow c2 = new Cow("Рыжая");              c2.setWeight(250);
        Duck d1 = new Duck("Даша");             d1.setWeight(3);
        Duck d2 = new Duck("Маша");             d2.setWeight(3.5);
        Hamster h1 = new Hamster("Акакий");     h1.setWeight(0.25);
        Hamster h2 = new Hamster("Поликарп");   h2.setWeight(0.32);
        Animal[] animals = new Animal[]{c1, c2, d1, d2, h1, h2};
        Arrays.sort(animals);
        System.out.println(Arrays.toString(animals));
    }
}
