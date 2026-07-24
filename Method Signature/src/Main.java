public class Main 
{
    public static void main(String[] args) 
    {
        Sender sender = new Sender();
        SendOptions options = SendOptions.builder("67", "", "hello dexter morgan")
            .mode(SendOptions.Mode.SILENT)
            .retryCount(100)
            .build();
        
        sender.sendMessage(options);
    }    
}