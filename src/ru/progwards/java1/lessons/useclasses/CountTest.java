package ru.progwards.java1.lessons.useclasses;

public class CountTest {
    public static void testInc(int count){
        Count cnt = new Count();
        for(int i = 0; i < count; i++){
            cnt.inc();
            System.out.print(cnt.getCount() + " ");
        }
        System.out.println(" ");
        System.out.println("тест inc окончен");
    }

    public static void testDec(int count){
        Count cnt = new Count(count);
        while (!cnt.dec()){
        }
        System.out.println("count равен 0");
    }

    public static void main(String[] args) {
        testInc(7);
        testInc(0);
        testInc(-1);
        testDec(9);
        testDec(0);
        testDec(-5);

    }
}
