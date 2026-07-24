public class BaseDownloader
{
    public BaseDownloader()
    {
        init();
    }
    
    protected void init()
    {
        System.out.println("Connection initialization...");
    }

    public final void download()
    {
        init();

        System.out.println("The file is downloaded!");
    }
}