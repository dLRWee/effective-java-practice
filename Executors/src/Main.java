import java.util.stream.LongStream;

public class Main 
{
    public static void main(String[] args) 
    {
        NotificationService service = new NotificationService();
        
        long[] clientIds = LongStream.range(1, 51).toArray();

        long start = System.currentTimeMillis();
        
        for (long id : clientIds)
        {
            service.sendSms(id);
        }

        service.stopService();

        long end = System.currentTimeMillis();

        double timeTotal = (end - start) / 1000.0;

        System.out.println("Time: " + timeTotal + " sec.");
    }    
}