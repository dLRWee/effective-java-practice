package third;

public class Main 
{
    // Не обеспечивает атомарности (новое значение зависит от страого значения)
    private static volatile int count = 0;    

    public static void main(String[] args) throws InterruptedException
    {
        Runnable task = () -> 
        {
            for (int i = 0; i < 10_000; i++)
                count++;
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("Count: " + count);
    }
}