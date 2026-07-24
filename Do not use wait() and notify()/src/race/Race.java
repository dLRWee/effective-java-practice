package race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public final class Race 
{
    public static long time(Executor executor, int concurrency, Runnable task) throws InterruptedException
    {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done  = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++)
        {
            executor.execute(() -> 
            {
                ready.countDown();

                try
                {
                    start.await();
                    task.run();
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
                finally
                {
                    done.countDown();
                }
            });
        }

        ready.await();
        long startTime = System.nanoTime();
        start.countDown();
        done.await();
        long endTime = System.nanoTime();

        return endTime - startTime;
    }    
}