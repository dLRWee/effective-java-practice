import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Manages the collection ({@code Map<String, T>}) of books. */
public class SimpleBookRepository<T extends Identifiable> implements BookRepository<T>
{
    private final Map<String, T> books;

    /** Constructs a  new repository. */
    public SimpleBookRepository()
    {
        books = new HashMap<>();
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void add(T book)
    {
        books.put(book.getId(), book);
    }

    /**
     * @return {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public Optional<T> findById(String id)
    {
        Objects.requireNonNull(id);
        
        return Optional.ofNullable(books.get(id));
    }
}