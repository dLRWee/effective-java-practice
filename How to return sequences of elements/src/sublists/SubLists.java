package sublists;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SubLists 
{
    public static Stream<List<String>> of(List<String> list)
    {
        return Stream.concat(Stream.of(Collections.emptyList()), 
            prefixes(list).flatMap(SubLists::suffixes));
    }   
    
    private static Stream<List<String>> prefixes(List<String> list)
    {
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(end -> list.subList(0, end));
    }

    private static Stream<List<String>> suffixes(List<String> list)
    {
        return IntStream.range(0, list.size())
            .mapToObj(start -> list.subList(start, list.size()));
    }
}