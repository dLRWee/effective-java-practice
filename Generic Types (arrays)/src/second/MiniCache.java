package second;

class MiniCache<E> 
{
    private Object[] elements;
    private int size = 0;

    MiniCache(int capacity) 
    {
        elements = new Object[capacity];
    }

    void add(E element) 
    {
        if (size < elements.length) 
            elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) 
    {
        return (E) elements[index];
    }
}