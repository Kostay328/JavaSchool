package ru.progwards.java1.lessons.classes1;

public class Count {
    static int count;
    public Count(int count){
        this.count = count;
    }

    public static void inc(){
        count++;
    }

    public static int getCount(){
        return count;
    }

    public static boolean dec(){
        count = count - 1;
        return count <= 0;
    }

    public static void main(String[] args){
        Count cnt = new Count(10);

        while(!cnt.dec()){
        }
        System.out.println("count равен " + cnt.count);
    }
}
