import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("x: ");
        double x = Double.parseDouble(scanner.nextLine());
        System.out.print("y: ");
        double y = Double.parseDouble(scanner.nextLine());
        
        test(BasicOperation.class, x, y);
        test(Arrays.asList(ExendedOperation.class.getEnumConstants()), x, y);

        scanner.close();
    }   

    // Bounded type token
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnum, double x, double y)
    {
        for (Operation op : opEnum.getEnumConstants())
        {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    // Bounded wildcard type
    private static void test(List<? extends Operation> operations, double x, double y)
    {
        for (Operation op : operations)
        {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}