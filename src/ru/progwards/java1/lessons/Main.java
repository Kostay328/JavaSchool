package ru.progwards.java1.lessons;

import java.util.Date;

class Figure {
    String name;

    public Figure(String name) {
        this.name = name;
    }

    public Figure() {
        this("фигура");
    }
    class Segment extends  Figure{
        public Segment(){
            name = "отрезок";
        }
    }

    class Point2D{
        int x;
        int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + "," + y;
        }
    }
    class Point3D extends Point2D{
        private int z;

        public Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }


        public String toString() {
            return x + "," + y + "," + z;
        }
    }
}

public class Main {
    public interface Comparable<T> {
        public int compareTo(T o);
    }
class Num implements Comparable{
    int num;

    public Num(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Object o) {
        Num i = (Num) o;
        return Integer.compare(num,i.num);
    }
}


    public static void main(String[] args) {

    }
}
