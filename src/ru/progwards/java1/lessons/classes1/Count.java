package ru.progwards.java1.lessons.classes1;

public class Count {
    int count;
    public Count(int count){
        this.count = count;
    }

    public void inc(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public boolean dec(){
        count++;
        return count <= 0;
    }
}
