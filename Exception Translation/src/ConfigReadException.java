public final class ConfigReadException extends RuntimeException
{
    public ConfigReadException() { }

    public ConfigReadException(String message)
    {
        super(message);
    }

    public ConfigReadException(Throwable cause)
    {
        super(cause);
    }

    public ConfigReadException(String message, Throwable cause)
    {
        super(message, cause);
    }
}