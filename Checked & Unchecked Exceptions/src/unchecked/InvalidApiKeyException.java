package unchecked;

import java.util.Objects;
import java.util.Optional;

/** An unchecked exception thrown when an invalid API key was passed. */
public class InvalidApiKeyException extends RuntimeException
{
    private final String invalidKey;

    /** Empty constructor. */
    public InvalidApiKeyException()
    {
        super();
        invalidKey = null;
    }

    /** Message constructor. */
    public InvalidApiKeyException(String invalidKey)
    {
        Objects.requireNonNull(invalidKey);
        
        if (invalidKey.isBlank())
            throw new IllegalArgumentException("invalidKey must not be balnk");

        super("The API key " + invalidKey + " is invalid");
        this.invalidKey = invalidKey;
    }

    /** Cause constructor. */
    public InvalidApiKeyException(Throwable cause)
    {
        super(cause);
        invalidKey = null;
    }

    /** Message and cause constructor */
    public InvalidApiKeyException(String invalidKey, Throwable cause)
    {
        this(invalidKey);
        initCause(cause);
    }

    /**
     * Returns the invalid key. 
     * @return {@link Optional#of(Object)} if the {@code invalidKey} was set in the constructor, {@link Optional#empty()} otherwise
     */
    public Optional<String> getInvalidKey() { return Optional.ofNullable(invalidKey); }
}