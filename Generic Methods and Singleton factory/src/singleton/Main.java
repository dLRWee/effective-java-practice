package singleton;

import java.util.List;
import java.util.function.UnaryOperator;

class Main 
{
    static void main(String[] agrs)
    {
        List<String> strs = List.of("first", "second");
        UnaryOperator<String> sameString = IdentityFunction.identityFunction();

        for (String s : strs)
        {
            System.out.println(sameString.apply(s));
        }

        List<Integer> ints = List.of(1, 2);
        UnaryOperator<Integer> sameInteger = IdentityFunction.identityFunction();

        for (Integer i : ints)
        {
            System.out.println(sameInteger.apply(i));
        }
    }    
}