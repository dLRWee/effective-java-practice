import java.util.LinkedHashMap;
import java.util.Map;

public class NewsCache extends LinkedHashMap<Integer, String>
{
    public NewsCache()
    {
        super(16, 0.75f, true);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> entry)
    {
        return size() > 5;
    }
}