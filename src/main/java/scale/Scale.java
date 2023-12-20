package scale;

import java.util.concurrent.Semaphore;

public class Scale {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5, true);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("\tГрузовик: " + Thread.currentThread().getName() + " заехал.");
                Thread.sleep(2000);
                System.out.println("\t\tГрузовик: " + Thread.currentThread().getName() + " прошел взвешивание.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("Грузовик: " + Thread.currentThread().getName() + " выехал.");
            }
        };
        for (int i = 0; i < 12; i++) {
            new Thread(task).start();
        }
    }
}
