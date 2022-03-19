package ru.progwards.java1.lessons.arrays1;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int n) {
        boolean[] lb = new boolean[n];
        for(int i = 0; i < lb.length; i++)
            lb[i] = true;
        this.sieve = lb;
        sift();
    }

    private void sift(){
        for (int i = 2; i < sieve.length; ++i) {
            if (sieve[i]) {
                for (int j = 2; i * j < sieve.length; ++j) {
                    sieve[i * j] = false;
                }
            }
        }
    }
    public boolean isSimple(int n){
        return sieve[n];
    }
}
