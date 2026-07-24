import java.util.Optional;

/** 
 * Manages the collection of books. 
 * @param <T> the book's type (must implements the {@link Identifiable})
 */
public interface BookRepository<T extends Identifiable>
{
    /**
     * Adds the specified book to the repository.
     * @param book the book to be added
     * @throws NullPointerException if the {@code book} is {@code null}
     */
    void add(T book);

    /**
     * Finds a book by its {@code id}.
     * @param id the id of the book to be find
     * @return an {@code Optional} containing the book if found, otherwise {@code Optional.empty()}
     * @throws NullPointerException if the {@code id} is {@code null}
     */
    Optional<T> findById(String id);
}