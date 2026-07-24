import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public final class TextAnalizer 
{
    private TextAnalizer() { throw new AssertionError("TextAnalizer is a util class"); }

    public static Map<Long, List<String>> howManyTimesWords(List<String> text)
    {
        return text.stream()
            .flatMap(line -> Arrays.stream(line.split(" ")))
            .map(String::toLowerCase)
            .filter(word -> word.length() > 3)
            .collect(groupingBy(w -> w, counting()))
            .entrySet().stream()
            .collect(groupingBy(Map.Entry::getValue,
                mapping
                (
                    Map.Entry::getKey,
                    collectingAndThen(toList(), list -> {
                        list.sort(null); // Сортировка по алфавиту
                        return list;
                    })
                )
            ));
    }

    public static Map<String, List<String>> anagrams(List<String> text)
    {
        return text.stream()
            .flatMap(line -> Arrays.stream(line.split(" ")))
            .map(String::toLowerCase)
            .distinct()
            .collect(groupingBy(TextAnalizer::alphabetize));
    }
    
    private static String alphabetize(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}