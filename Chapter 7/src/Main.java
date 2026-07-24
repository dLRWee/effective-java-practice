import java.util.Arrays;
import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        String[] text = {"Apple banana apple car", "banana car cherry apple", "hello apple morgan"};
        List<String> textAsList = Arrays.asList(text);

        var analizedText = TextAnalizer.howManyTimesWords(textAsList);
        var anagrams = TextAnalizer.anagrams(textAsList);

        System.out.println(analizedText);
        System.out.println(anagrams);
    }    
}