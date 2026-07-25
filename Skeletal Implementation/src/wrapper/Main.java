package wrapper;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class Main 
{
    public static void main(String[] args) 
    {
        int[] arr = {1, 2, 3, 4};

        List<Integer> list = asList(arr);

        System.out.println(list.size());
        System.out.println(list);

        list.set(0, 10);
        
        System.out.println(list.size());
        System.out.println(list);
    }
    
    private static List<Integer> asList(int[] a)
    {
        Objects.requireNonNull(a);

        return new AbstractList<>() 
        {
            @Override
            public Integer get(int index)
            {
                return a[index];
            }

            @Override
            public int size()
            {
                return a.length;
            }

            @Override
            public Integer set(int index, Integer value)
            {
                Integer temp = a[index];
                a[index] = value;

                return temp;
            }
        };
    }
}
