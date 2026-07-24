package set;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PowerSet 
{
    public static <E> List<Set<E>> of(Set<E> set)
    {
        if (set.size() > 30)
            throw new IllegalArgumentException("Set is too big");
        
        List<E> src = new ArrayList<>(set);

        return new AbstractList<Set<E>>() 
        {
            @Override
            public int size() { return 1 << src.size(); }

            @Override
            public Set<E> get(int index)
            {
                Set<E> result = new HashSet<>();

                for (int i = 0; index != 0; i++, index >>= 1)
                {
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                }

                return result;
            }
        };
    }    
}