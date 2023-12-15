package org.FirstSecondThird;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Functions();
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        Thread third = new Thread(runnable);
        first.start();
        second.start();
        third.start();
    }
}