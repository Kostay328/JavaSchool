package ru.progwards.java1.lessons.inheritance;

public class TestAnimal {
    public static void printAnimal(Animal animal){
//        System.out.println("Это " + animal.kind() + " " + animal.name + " - " + animal.say() + "!");
        System.out.println(animal + " - " + animal.say() + "!");
    }

    public static void main(String[] args) {
        printAnimal(new Cow("Пеструшка"));
        printAnimal(new Cow("Рыжая"));
        printAnimal(new Duck("Даша"));
        printAnimal(new Duck("Маша"));
        printAnimal(new Hamster("Акакий"));
        printAnimal(new Hamster("Поликарп"));
    }
}
