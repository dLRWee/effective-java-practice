package first;

import java.util.concurrent.TimeUnit;

public class Main
{
    private static boolean stopRequested;

    // Обеспечивает как атомарность, так и видимость
    private static synchronized boolean stopRequested()
    {
        return stopRequested;
    }

    // Обеспечивает как атомарность, так и видимость
    public static synchronized void requestStop()
    {
        stopRequested = true;
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> 
        {
            int i = 0;
            
            while (!stopRequested())
                i++;

            System.out.println(i);
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        requestStop();
    }
}