package staticfiled;

public class MyClass 
{
    private static class FieldHolder
    {
        // Will initialize only in case of the first call
        static final Object filed = new Object();
    }    

    public Object getFiled()
    {
        return FieldHolder.filed;
    }
}