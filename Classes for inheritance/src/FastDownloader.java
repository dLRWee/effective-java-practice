public class FastDownloader extends BaseDownloader 
{
    private final String apiKey;

    public FastDownloader(String apiKey)
    {
        this.apiKey = apiKey;
    }

    @Override
    protected void init()
    {
        System.out.println("Using key: " + apiKey);
    }
}