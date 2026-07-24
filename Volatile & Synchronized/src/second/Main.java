package second;

import java.util.concurrent.TimeUnit;

public class Main
{
    // Обеспечивает только видимость (атомарность не нужна, так как только один поток меняет значение переменной)
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() -> 
        {
            int i = 0;
            
            while (!stopRequested)
                i++;

            System.out.println(i);
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        stopRequested = true;
    }
}