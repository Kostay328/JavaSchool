package ru.progwards.java1.lessons.classes1;

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
    //умножение комплексных чисел по формуле:
    //(a + bi) * (c + di) = (ac - bd) + (bc + ad)i
    public ComplexNum mul(ComplexNum num){
        return new ComplexNum(a * num.a - b * num.b, a * num.b + b * num.a);
    }
    //деление комплексных чисел по формуле:
    //(a + bi) / (c + di) = (ac + bd)/(cc+dd) + ((bc - ad)/(cc+dd))i
    public ComplexNum div(ComplexNum num){
        int t = num.a * num.a + num.b * num.b;
        if (t == 0)
            return new ComplexNum(0, 0);

        int x = a * num.a + b * num.b;
        int y = b * num.a - a * num.b;

        return new ComplexNum(x / t, y / t);
    }
    //Пытался сам разобраться в пердставленной формуле но так и не смог, спасибо за разьяснения
}
