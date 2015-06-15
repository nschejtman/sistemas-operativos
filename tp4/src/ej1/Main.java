package com.company.ej1;

public class Main {
    public static void main(String[] args) {
        final Fork f0 = new Fork(0);
        final Fork f1 = new Fork(1);
        final Fork f2 = new Fork(2);
        final Fork f3 = new Fork(3);
        final Fork f4 = new Fork(4);

        new Philosopher(f0, f1, "A");
        new Philosopher(f1, f2, "B");
        new Philosopher(f2, f3, "C");
        new Philosopher(f3, f4, "D");
        new Philosopher(f4, f0, "E");
    }
}
