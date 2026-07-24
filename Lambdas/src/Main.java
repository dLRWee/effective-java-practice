import java.util.EnumSet;

public class Main 
{
    public static void main(String[] args)
    {
        testOperations(EnumSet.allOf(BasicOperation.class), 4, 8);        
    }   
    
    private static void testOperations(EnumSet<? extends Operation> opEnum, double x, double y)
    {
        for (Operation op : opEnum)
        {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}