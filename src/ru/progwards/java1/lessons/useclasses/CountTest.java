package ru.progwards.java1.lessons.useclasses;

public class CountTest {
    public static void testInc(int count){
        Count cnt = new Count();
        int i_ = -1;
        for(int i = 0; i < count - 1; i++){
            cnt.inc();
            System.out.print(cnt.getCount() + " ");
            i_ = i;
        }
        if(i_ != -1)
            System.out.println(i_ + 2 + " ");
        System.out.println("тест inc окончен");
        System.out.println();
    }

    public static boolean compare3str(String str1, String str2, String str3){
        return str1.equals(str2) && str2.equals(str3);
    }

    public static void testDec(int count){
        Count cnt = new Count(count);
        int i_ = -1;
        for(int i = 0; i < count; i++){
            if(cnt.dec()){
                if(i_ != -1)
                    System.out.println(cnt.getCount() + " ");
                System.out.println("count равен 0");
                break;
            }else{
                i_ = i;
                System.out.print(cnt.getCount() + " ");
            }
        }
        if(count <= 0)
            System.out.println(count-1 + " ");
        System.out.println("тест dec окончен");
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
