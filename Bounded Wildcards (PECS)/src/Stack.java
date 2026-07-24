import java.util.Arrays;
import java.util.Collection;

public class Stack<E> 
{
    private static final int INIT_CAPACITY = 10;
    
    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack()
    {
        elements = (E[]) new Object[INIT_CAPACITY];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public E pop()
    {
        E result = elements[--size];
        elements[size] = null;

        return result;
    }

    public void popAll(Collection<? super E> dst)
    {
        while (!isEmpty())
            dst.add(pop());
    }

    public void push(E e)
    {
        if (size == elements.length)
            ensureCapacity();

        elements[size++] = e;
    }

    public void pushAll(Iterable<? extends E> src)
    {
        for (E e : src)
            push(e);
    }

    private void ensureCapacity()
    {
        elements = Arrays.copyOf(elements, size * 2);
    }
}