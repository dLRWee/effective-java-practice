package bad;

import java.util.Collection;
import java.util.List;

final class SmartLogger
{
    public static void log(List<?> l)
    {
        System.out.println("[INFO]: list with size " + l.size());
    }

    public static void log(Collection<?> c)
    {
        System.out.println("[INFO]: collection with size " + c.size());
    }

    public static void log(Object o)
    {
        System.out.println("[INFO]: object " + o);
    }
}