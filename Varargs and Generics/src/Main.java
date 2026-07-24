import java.util.List;

public class Main
{
    public static void main(String[] args) 
    {
        List<String> strings = flatten("first", "second", "third");
        List<Integer> integers = flatten(1, 2, 3);

        System.out.println(strings);
        System.out.println(integers);
    }

    @SafeVarargs
    private static <T> List<T> flatten(T... elemetns)
    {
        return List.of(elemetns);
    }
}