package good;

import java.util.Collection;
import java.util.List;

final class SmartLogger
{
    public static void log(Object o)
    {
        if (o instanceof List) 
            System.out.println("[INFO]: list with size " + ((List<?>)o).size());

        else if (o instanceof Collection) 
            System.out.println("[INFO]: collection with size " + ((Collection<?>)o).size());

        else
            System.out.println("[INFO]: object " + o);
    }
}