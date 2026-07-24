package adapter;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

final class Adapters 
{
    private Adapters() { throw new AssertionError("Adapters is a util class"); }

    public static <E> Iterable<E> iterableOf(Stream<E> stream)
    {
        return stream::iterator;
    }

    public static <E> Stream<E> streamOf(Iterable<E> iterable)
    {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}