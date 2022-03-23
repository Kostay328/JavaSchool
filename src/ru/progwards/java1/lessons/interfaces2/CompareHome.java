package ru.progwards.java1.lessons.interfaces2;

public class CompareHome {
    public static boolean sameHome(Home h1, Home h2){
        return h1.getClass().getSimpleName().equals(h2.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        System.out.println(sameHome(new Cow("123"), new Duck("123")));
        System.out.println(sameHome(new Cow("123"), new Hamster("123")));
        System.out.println(sameHome(new Cow("123"), new Hawk()));
        System.out.println(sameHome(new Duck("123"), new Hamster("123")));
        System.out.println(sameHome(new Duck("123"), new Hawk()));
        System.out.println(sameHome(new Hamster("123"), new Hawk()));
    }
}
