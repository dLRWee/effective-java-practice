import java.util.List;
import java.util.Objects;

public class Book
{
    private final String title;
    private final List<Author> authors;
    
    public Book(String title, List<Author> authors)
    {
        this.title = Objects.requireNonNull(title);

        this.authors = authors.stream()
        .map(Author::new)
        .toList();
    }

    // Статичная фабрика копирования
    public static Book copyOf(Book original)
    {
        if (original == null)
            throw new IllegalArgumentException("\"original\" sould not be null");

        return new Book(original.title, original.authors);
    }
}