import java.util.Objects;

public class Book 
{
    private final String title;
    private final String author;
    private final int pages;
    private final double price;
    private final boolean isEbook;

    private Book(String title, String author, int pages, double price, boolean isEbook)
    {
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        this.pages = pages;
        this.price = price;
        this.isEbook = isEbook;
    }

    public static Book createPrintBook(String title, String author, int pages, double price)
    {
        return new Book(title, author, pages, price, false);
    }

    public static Book createEBook(String title, String author, int pages, double price)
    {
        return new Book(title, author, pages, price, true);
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public int getPages()
    {
        return this.pages;
    }

    public double getPrice()
    {
        return this.price;
    }
    
    public boolean isEbook()
    {
        return this.isEbook;
    }

    /**
     * Returns a string representation of the {@code Book}.
     * <p>
     * The data consists of:
     * <ul>
     *   <li>Book's type (EBook or PrintBook)</li>
     *   <li>Title and author</li>
     *   <li>Price (formatted to 2 decimal places)</li>
     * </ul>
     * <p>
     * Return example: {@code EBook "Java" by Bloch costs 50.00$ (400 pages)}
     * <p>
     * @return A formatted string containing book details.
     */
    @Override
    public String toString()
    {
        return String.format("%s \"%s\" by %s costs %.2f$ (%d pages)",
            this.isEbook ? "EBook" : "PrintBook",
            this.title,
            this.author,
            this.price,
            this.pages
        );
    }
}