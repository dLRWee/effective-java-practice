import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class ObservableSet<E> extends ForwardingSet<E>
{
    private final List<SetObserver<E>> observers;
    
    public ObservableSet(Set<E> set)
    {
        super(set);
        observers = new ArrayList<>();
    }

    public boolean addObserver(SetObserver<E> observer)
    {
        synchronized (observers) { return observers.add(observer); }
    }

    public boolean removeObserver(SetObserver<E> observer)
    {
        synchronized (observers) { return observers.remove(observer); }
    }

    private void notifyElementAdded(E element)
    {
        List<SetObserver<E>> snapshot = null;
        
        synchronized (observers) { snapshot = new ArrayList<>(observers); }

        for (SetObserver<E> observer : snapshot)
            observer.added(this, element);
    }

    public boolean add(E element)
    {
        boolean added = super.add(element);

        if (added)
            notifyElementAdded(element);

        return added;
    }

    public boolean addAll(Collection<? extends E> elements)
    {
        boolean added = false;

        for (E element : elements)
            added |= add(element);

        return added;
    }
}