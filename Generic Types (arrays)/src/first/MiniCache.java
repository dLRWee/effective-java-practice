package first;

class MiniCache<E> 
{
    private E[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    MiniCache(int capacity) 
    {
        elements = (E[]) new Object[capacity];
    }

    void add(E element) 
    {
        if (size < elements.length) 
            elements[size++] = element;
    }

    E get(int index) 
    {
        return elements[index];
    }
}