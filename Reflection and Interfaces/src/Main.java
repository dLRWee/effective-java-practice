import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Class<? extends Set<String>> cl = null;
        try
        {
            cl = (Class<? extends Set<String>>) Class.forName(args[0]);
        }
        catch (ClassNotFoundException e)
        {
            fatalError("class not found");
        }

        Constructor<? extends Set<String>> constructor = null;
        try
        {
            constructor = cl.getConstructor();
        }
        catch (NoSuchMethodException e)
        {
            fatalError("there is no parameterless constructor");
        }

        Set<String> instance = null;
        try
        {
            instance = constructor.newInstance();
        }
        catch (IllegalAccessException e)
        {
            fatalError("cannot access to the constructor");
        }
        catch (InstantiationException e)
        {
            fatalError("cannot instanciate the class");
        }
        catch (InvocationTargetException e)
        {
            fatalError("the constructor thre exception: " + e.getCause());
        }
        catch (ClassCastException e)
        {
            fatalError("class doesn't implement Set");
        }

        List<String> arguments = Arrays.asList(args).subList(1, args.length);
        instance.addAll(arguments);

        System.out.println(instance);
    }

    private static void fatalError(String msg)
    {
        System.err.println(msg);
        System.exit(1);
    }
}