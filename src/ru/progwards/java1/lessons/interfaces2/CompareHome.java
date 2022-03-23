package ru.progwards.java1.lessons.interfaces2;

public class CompareHome {
    public static boolean sameHome(Home h1, Home h2){
        return h1.getHome().equals(h2.getHome());
    }

    public static void main(String[] args) {
        System.out.println("Результат сравнения Cow и Duck равен " + sameHome(new Cow("123"), new Duck("123")));
        System.out.println("Результат сравнения Cow и Hamster " + sameHome(new Cow("123"), new Hamster("123")));
        System.out.println("Результат сравнения Cow и Hawk равен " + sameHome(new Cow("123"), new Hawk()));
        System.out.println("Результат сравнения Duck и Hamster равен " + sameHome(new Duck("123"), new Hamster("123")));
        System.out.println("Результат сравнения Duck и Hawk равен " + sameHome(new Duck("123"), new Hawk()));
        System.out.println("Результат сравнения Hamster и Hawk равен " + sameHome(new Hamster("123"), new Hawk()));
    }
}
