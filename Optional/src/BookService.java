import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;

public class BookService 
{
    private List<Book> repository = new ArrayList<>();

    public Optional<Book> findBookByIsbn(String isbn) 
    {
        for (Book book : repository) 
        {
            if (book.getIsbn().equals(isbn)) 
                return Optional.of(book);
        }

        return Optional.empty();
    }

    public void updateTitle(String isbn, String newTitle) 
    {
        Book book = findBookByIsbn(Objects.requireNonNull(isbn)).orElseThrow(IllegalArgumentException::new);

        book.setTitle(Objects.requireNonNull(newTitle));
    }

    public Optional<Book> getMaxBy(Comparator<? super Book> comparator)
    {
        return repository.stream().max(comparator);
    }

    public OptionalDouble getMaxPrice()
    {
        return repository.stream().mapToDouble(Book::getPrice).max();
    }
}
