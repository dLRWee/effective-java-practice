import checked.NotEnoughStockException;
import unchecked.InvalidApiKeyException;

public class Main 
{
    public static void main(String[] args) 
    {
        try 
        {
            checkedException();
        }
        catch (NotEnoughStockException e)
        {
            String messgae = e.getMessage() == null ? "there is no message" : e.getMessage();
            
            System.out.println(messgae);
        }

        uncheckedException("67");
    }   
    
    private static void checkedException() throws NotEnoughStockException
    {
        throw new NotEnoughStockException();
    }

    private static void uncheckedException(String apiKey)
    {
        throw new InvalidApiKeyException(apiKey);
    }
}