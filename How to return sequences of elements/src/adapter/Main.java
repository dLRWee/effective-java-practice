package adapter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main
{
    public static void main(String[] args) 
    {
        Stream<String> stream = Stream.of("first", "second", "third");
        
        System.out.print("Iterable from stream:");
        for (String s : Adapters.iterableOf(stream))
        {
            System.out.print(" " + s);
        }
        System.out.println();

        List<String> list = List.of("first", "second", "third");
        String listString = list.stream().collect(Collectors.joining(" "));

        System.out.println("Stream from iterable: " + listString);
    }
}