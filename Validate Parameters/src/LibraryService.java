import java.util.Objects;

/**
 * All methods and constructors of this class throw a {@code NullPointerException} if any parapenter is null.
 */
public final class LibraryService 
{
    /**
     * Lend a book to a user.
     * 
     * @param book the Book to be lended
     * @param userId id of the user which take the book
     * @param durationDays how long the user will have it
     * 
     * @throws IllegalArgumentException if the {@code durationDays} is less than or equal to 0
     */
    public void lendBook(Book book, String userId, int durationDays)
    {
        Objects.requireNonNull(book);
        Objects.requireNonNull(userId);

        if (durationDays <= 0)
            throw new IllegalArgumentException("durationDays <= 0: " + durationDays);

        updateDatabase(userId);
    }

    private void updateDatabase(String isbn)
    {
        assert isbn != null;
    }
}