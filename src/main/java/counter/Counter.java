package counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Counter {
    public static void main(String[] args) throws InterruptedException {
        Values values = new Values();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        IntStream.range(0, 3000).forEach(i -> executor.submit(values.atomicInteger::incrementAndGet));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        System.out.println(values.atomicInteger.get());

        ExecutorService executor1 = Executors.newFixedThreadPool(3);

        LongStream.range(0, 3000).forEach(i -> executor1.submit(values.atomicLong::incrementAndGet));
        executor1.shutdown();
        executor1.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        System.out.println(values.atomicLong.get());
    }
}
