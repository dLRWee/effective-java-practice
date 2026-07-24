package method;

import java.util.HashSet;
import java.util.Set;

class Main
{
    static void main(String[] args)
    {
        Set<String> first = Set.of("first", "second");
        Set<String> second = Set.of("third", "fourth");

        Set<String> unionSet = union(first, second);

        System.out.println(unionSet);
    }

    private static <E> Set<E> union(Set<E> s1, Set<E> s2)
    {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);

        return result;
    }
}