import java.util.Map;
import java.util.WeakHashMap;

public class SessionCache 
{
    private final Map<String, Object> sessions;
    
    public SessionCache()
    {
        // even if the user didn't call remove explicitly, the entry will be gced if there is no strong references
        this.sessions = new WeakHashMap<>();
    }

    public void put(String id, Object session)
    {
        this.sessions.put(id, session);
    }

    public void remove(String id)
    {
        this.sessions.remove(id);
    }
}