package ru.progwards.java1.lessons.useclasses;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
    }
    public String toString(){
        return a+"+"+b+"i";
    }
    public ComplexNum add(ComplexNum num) {
        int a1 = a + num.a;
        int b1 = b + num.b;
        return new ComplexNum(a1, b1);
    }
    public ComplexNum sub(ComplexNum num) {
        int a1 = a - num.a;
        int b1 = b - num.b;
        return new ComplexNum(a1, b1);
    }
    public ComplexNum mul(ComplexNum num) {
        int a1 = 0;
        int b1 = b * num.b + a * num.a;
        return new ComplexNum(a1, b1);
    }
    public ComplexNum div(ComplexNum num) {
        int a1 = a / num.a;
        int b1 = b / num.b;
        return new ComplexNum(a1, b1);
    }
}
