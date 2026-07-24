package race;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        Runnable task = () -> 
        { 
            try
            {
                Thread.sleep(Duration.ofSeconds(1));
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName());
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        
        long timeInNano = 0;
        
        try
        {
            timeInNano = Race.time(executor, 100, task);
        }
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
        finally { executor.shutdown(); }

        long timeInMillis = TimeUnit.NANOSECONDS.toMillis(timeInNano);
        System.out.println(timeInMillis);
    }
}