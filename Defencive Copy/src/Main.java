import java.util.Date;

public class Main 
{
    public static void main(String[] args) 
    {
        Date start = new Date();
        Date end = new Date();

        BookingPeriod period = new BookingPeriod(start, end);

        start.setTime(1000000000000000000L);

        System.out.println(period);
    }    
}
