import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groups = Stream.of(words)
            .collect(Collectors.groupingBy(Main::alphabetize))
            .values()
            .stream()
            .toList();

        System.out.println(groups);
    }

    private static String alphabetize(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}