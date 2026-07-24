package recursivetypebound;

import java.util.Collection;
import java.util.Set;

class Main 
{
    static void main(String[] args)
    {
        Set<Integer> nums = Set.of(1, 2, 3, 4, 5);

        System.out.println(findMax(nums));
    }   
    
    private static <E extends Comparable<E>> E findMax(Collection<E> c)
    {
        if (c.isEmpty())
            throw new IllegalArgumentException("collection is empty");

        E max = null;

        for (E e : c)
        {
            if (max == null || e.compareTo(max) > 0)
                max = e;
        }

        return max;
    }
}