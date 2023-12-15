package org.FirstSecondThird;

public class Functions implements Runnable {
    public void first() {
        System.out.println("First");
    }
    public void second() {
        System.out.println("Second");
    }
    public void third() {
        System.out.println("Third");
    }
    private void sortThreads(String name) {
        try {
            if (name.equals("Thread-0")) {
                Thread.sleep(2000);
                first();
            } else if (name.equals("Thread-1")) {
                Thread.sleep(1000);
                second();
            } else if (name.equals("Thread-2")){
                third();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        //System.out.println(name);
        sortThreads(name);
    }
}
