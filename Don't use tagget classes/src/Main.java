import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main 
{
    public static void main(String[] args)
    {
        Box box = Box.newInstance(24.917, 12.2, 34.3, 5.0);
        Letter letter = Letter.newInstance(5.5, 6);

        System.out.println("\tBox\n" + box + "\n");
        System.out.println("\tLetter\n" + letter);

        List<Integer> list = Stream.of(1, 23, -2, 0, 56, 4)
            .collect(Collectors.toCollection(ArrayList::new));

        Collections.sort(list);

        System.out.println(list);
    }    
}