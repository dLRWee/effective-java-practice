import java.util.Objects;

/**
 * All methods and constructors of this class throw a {@code NullPointerException} if any parapenter is null.
 */
public final class Book
{
    private final String title;
    private final String isbn;

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    
    /**
     * Creates a  new {@code Book} object.
     * 
     * @param title title of the book
     * @param isbn unique id
     * 
     * @throws IllegalArgumentException if length of the {@code isbn} is not equals to 13
     */
    public Book(String title, String isbn)
    {
        if (isbn.length() != 13)
            throw new IllegalArgumentException("ISBN.length() != 13: " + isbn);

        this.title = Objects.requireNonNull(title);
        this.isbn = isbn;
    }
}