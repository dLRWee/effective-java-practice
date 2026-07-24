import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext 
{
    private final Map<Class<?>, Object> context;
    
    public ApplicationContext()
    {
        context = new HashMap<>();
    }
    
    public <T> void putData(Class<T> type, T instance)
    {
        Objects.requireNonNull(type);
        Objects.requireNonNull(instance);
        
        context.put(type, type.cast(instance));
    }

    public <T extends Serializable> void putSerializable(Class<T> type, T instance)
    {
        Objects.requireNonNull(type);
        Objects.requireNonNull(instance);
        
        context.put(type, type.cast(instance));
    }
    
    public <T> T getData(Class<T> type)
    {
        Objects.requireNonNull(type);
        
        return type.cast(context.get(type));
    }
}