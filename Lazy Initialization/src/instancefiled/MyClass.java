package instancefiled;

public class MyClass
{
    // Volatile is important!
    private volatile Object field;

    // Double-check
    public Object getField()
    {
        Object result = field;
        
        if (result == null) 
        {
            synchronized (this)
            {
                if (result == null)
                    field = result = new Object();
            }
        }

        return result;
    }
}