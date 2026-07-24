import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Wrapper
public class CountingSet<E> extends ForwardingSet<E> 
{
    private AtomicInteger counter;

    public CountingSet(Set<E> s)
    {
        this.counter = new AtomicInteger();
        super(s);
    }

    @Override
    public boolean add(E e)
    {
        this.counter.incrementAndGet();
        return super.add(e);
    } 

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        this.counter.addAndGet(c.size());
        return super.addAll(c);
    }

    public int getCounterValue()
    {
        return this.counter.get();
    }
}