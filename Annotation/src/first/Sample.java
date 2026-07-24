package first;
import java.util.ArrayList;
import java.util.List;

public class Sample 
{
    // Should pass
    @TestException(RuntimeException.class)
    public static void f1()
    {
        throw new RuntimeException("Boom!");
    }    

    // Should pass
    @TestException(IndexOutOfBoundsException.class)
    @TestException(NullPointerException.class)
    public static void f2()
    {
        List<Integer> list = new ArrayList<>();

        list.addAll(5, null);
    }

    // Should fail
    @TestException(RuntimeException.class)
    public static void f3() {}

    // Should fail
    @TestException(NullPointerException.class)
    public static void f4()
    {
        throw new ArithmeticException();
    }
    
    // Invalid use of TestExeption
    @TestException(RuntimeException.class)
    public void f5() {}
}