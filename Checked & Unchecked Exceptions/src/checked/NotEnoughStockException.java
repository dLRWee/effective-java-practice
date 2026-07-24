package checked;

import java.util.OptionalInt;

/** A checked exception thrown when a product is out of stock. */
public class NotEnoughStockException extends Exception
{
    private final int requestedQuantity;
    private final int availableQuantity;

    /** Empty constructor. */
    public NotEnoughStockException()
    {
        super();

        requestedQuantity = -1;
        availableQuantity = -1;
    }

    /** Message constructor. */
    public NotEnoughStockException(int requestedQuantity, int availableQuantity)
    {
        if (requestedQuantity < 0)
            throw new IllegalArgumentException("requestedQuantity must be greater than or equal to 0: " + requestedQuantity);
        if (availableQuantity < 0)
            throw new IllegalArgumentException("availableQuantity must be greater than or equal to 0: " + availableQuantity);

        String message = String.format("Requested " + requestedQuantity + ", but available " + availableQuantity);
        super(message);
        
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }
    
    /** Cause constructor. */
    public NotEnoughStockException(Throwable cause)
    {
        super(cause);

        requestedQuantity = -1;
        availableQuantity = -1;
    }

    /** Message and cause constructor */
    public NotEnoughStockException(int requestedQuantity, int availableQuantity, Throwable cause)
    {
        this(requestedQuantity, availableQuantity);
        initCause(cause);
    }

    /**
     * Returns a requested quantity value. 
     * @return {@link OptionalInt#of(int)} if the {@code requestedQuantity} was set in the constructor, {@link OptionalInt#empty()} otherwise
     */
    public OptionalInt getRequestedQuantity() 
    { 
        return requestedQuantity == -1 ? OptionalInt.empty() : OptionalInt.of(requestedQuantity); 
    }
    
    /**
     * Returns a available quantity value. 
     * @return {@link OptionalInt#of(int)} if the {@code availableQuantity} was set in the constructor, {@link OptionalInt#empty()} otherwise
     */
    public OptionalInt getAvailableQuantity() 
    { 
        return availableQuantity == -1 ? OptionalInt.empty() : OptionalInt.of(availableQuantity); 
    }
}