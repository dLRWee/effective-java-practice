import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class NotificationService
{
    private final ThreadPoolExecutor poolExecutor;

    public NotificationService()
    {
        poolExecutor = new ThreadPoolExecutor
        (
            4, 
            10, 
            2, 
            TimeUnit.SECONDS, 
            new LinkedBlockingDeque<>(20),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public void sendSms(long clientId)
    {
        Runnable task = () ->
        {
            String currThreadName = Thread.currentThread().getName();
            
            System.out.println(String.format("[%s] Sending SMS for the client %d...", currThreadName, clientId));

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                
                String message = String.format
                (
                    "[%s] The SMS to the client %d was not sent due to a thread interruption.", 
                    currThreadName, 
                    clientId
                );

                System.out.println(message);

                return;
            }

            System.out.println(String.format("[%s] The SMS message to the client %d was sent successfully.", currThreadName, clientId));
        };

        poolExecutor.execute(task);
    }

    public void stopService()
    {
        poolExecutor.shutdown();

        try 
        {
            if (!poolExecutor.awaitTermination(3, TimeUnit.SECONDS))
            {
                List<Runnable> droppedTasks = poolExecutor.shutdownNow();

                System.out.println("Tasks were dropped: " + droppedTasks.size());

                if (!poolExecutor.awaitTermination(5, TimeUnit.SECONDS))
                {
                    System.out.println("The service was not able to stop.");
                }
            }
            else
            {
                System.out.println("The service was successfully stopped.");
            }
        }
        catch (InterruptedException e)
        {
            poolExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}