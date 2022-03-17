package ru.progwards.java1.lessons.classescompare;

public class Test {
    public static void main(String[] args) {
        Cow c1 = new Cow("Буренка");
        c1.setWeight(48);
        Cow c2 = new Cow("Жучка");
        c2.setWeight(77);
        Cow c3 = new Cow("Буренка");
        c3.setWeight(48);
        Hamster h1 = new Hamster("Чухрик");
        h1.setWeight(0.2);
        Duck d1 = new Duck("Улитка");
        d1.setWeight(5);

        System.out.println("Тест для Animal, Cow, Hamster, Duck");
        System.out.println("Сравнение c1 и c2 "+c1.equals(c2));
        System.out.println("Сравнение c1 и c3 "+c1.equals(c3));
        System.out.println("Сравнение h1 и d1 "+h1.equals(d1));
        System.out.println("Цена еды для утки "+d1.calculateFoodPrice());

    }
}
