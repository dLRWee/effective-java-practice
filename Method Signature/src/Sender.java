import java.util.Objects;

public final class Sender 
{
    /**
     * Sending the message with specified options.
     * @param options the sending settings
     * @throws NullPointerException if {@code options} is {@code null}
     * @see SendOptions
     */
    public void sendMessage(SendOptions options) 
    {
        Objects.requireNonNull(options);
        
        System.out.println("Sending message with options:\n" + options);
    }
}