package processing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyBoundedQueue queue = new MyBoundedQueue(10);

        ExecutorService producers = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            producers.execute(new OrderProducer(queue));
        }

        ExecutorService consumers = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            consumers.execute(new OrderConsumer(queue));
        }

        producers.shutdown();
        producers.awaitTermination(10, TimeUnit.SECONDS);

        Thread.sleep(500);

        System.out.println("Closing...");
        consumers.shutdownNow(); 
    }
}
