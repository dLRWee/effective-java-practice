package singleton;

import java.util.function.UnaryOperator;

public final class IdentityFunction 
{
    private IdentityFunction() { throw new AssertionError(); }

    private static final UnaryOperator<Object> IDENtITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction()
    {
        return (UnaryOperator<T>) IDENtITY_FN;
    }
}