package scale;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Scale {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(12);
        Semaphore semaphore = new Semaphore(5, true);
        Runnable task = () -> {
            try {
                countDownLatch.countDown();
                System.out.println("Грузовик: " + Thread.currentThread().getName() + " на въезде");
                Thread.sleep(1000);
                semaphore.acquire();
                System.out.println("\tГрузовик: " + Thread.currentThread().getName() + " заехал");
                Thread.sleep(2000);
                System.out.println("\t\tГрузовик: " + Thread.currentThread().getName() + " прошел взвешивание");
                semaphore.release();
                countDownLatch.await();
                System.out.println("Грузовик: " + Thread.currentThread().getName() + " выехал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 12; i++) {
            new Thread(task).start();
        }
    }
}
