package second;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Role: ");
        Role role = Role.valueOf(scanner.nextLine());

        for (Method m : Service.class.getDeclaredMethods())
        {
            RequireRole[] roles = m.getAnnotationsByType(RequireRole.class);

            if (roles.length > 0)
            {
                boolean found = Arrays.stream(roles).anyMatch(r -> r.value().equals(role));

                if (found)
                    tryInvoke(m);
                else
                    System.out.printf("[INFO]: %s: access denied%n", m.getName());
            }
            else
                tryInvoke(m);
        }
        
        scanner.close();
    }    

    private static void tryInvoke(Method m)
    {
        try
        {
            m.invoke(null);
            System.out.printf("[INFO]: %s: access granted%n", m.getName());
        }
        catch (InvocationTargetException wrappedExc)
        {
            System.out.printf("[ERROR]: %s threw %s%n", m.getName(), wrappedExc.getCause());
        }
        catch (Exception e)
        {
            System.out.printf("[ERROR]: %s: %s%n", m.getName(), e);
        }
    }
}