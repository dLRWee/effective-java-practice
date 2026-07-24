package list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

class Main 
{
    static void main(String[] args)
    {
        // Wont even compile!
        // List<Object> list = new ArrayList<String>();

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        int result = reduce(nums, Integer::sum, 0);

        System.out.println(result);
    }    

    public static <E> E reduce(List<E> list, BinaryOperator<E> op, E initValue)
    {
        E result = initValue;

        for (E e : list)
        {
            result = op.apply(result, e);
        }

        return result;
    }
}