package first;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main 
{
    public static void main(String[] args) 
    {
        int tests = 0;
        int passed = 0;
        
        Class<Sample> testClass = Sample.class;

        for (Method m : testClass.getDeclaredMethods())
        {
            TestException[] testExcs = m.getAnnotationsByType(TestException.class);

            if (testExcs.length > 0)
            {
                tests++;

                try
                {
                    m.invoke(null);
                    System.out.printf("FAILED %s: no exception%n", m.getName());
                }
                catch (InvocationTargetException wrappedExc)
                {
                    Throwable exc = wrappedExc.getCause();
                    boolean found = false;

                    for (TestException testExc : testExcs)
                    {
                        if (testExc.value().isInstance(exc))
                        {
                            found = true;
                            break;
                        }
                    }

                    if (found)
                    {
                        passed++;
                        System.out.printf("PASSED %s%n", m.getName());
                    }
                    else
                        System.out.printf("FAILED %s: expected one of %s, but got %s%n", 
                            m.getName(), Arrays.toString(testExcs), exc);
                }
                catch (Exception e)
                {
                    System.out.printf("INVALID USE of @TestException on %s: %s%n", m.getName(), e);
                }
            }
        }

        System.out.printf("Tests: %d, Passed: %d, Failed: %d%n", tests, passed, tests - passed);
    }    
}