package bad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

class Main 
{
    public static void main(String[] args) 
    {
        Collection<?>[] collections = {new ArrayList<String>(), new HashSet<String>()};    

        for (Collection<?> c : collections)
        {
            SmartLogger.log(c);
        }
    }    
}