public class Main 
{
    public static void main(String[] args)
    {
        HttpRequest httpRequest = new HttpRequest.Builder("https://something.com", HttpRequest.METHODS.GET)
        .body("body")
        .addHeader("key", "value")
        .addHeader("secondKey", "secondValue")
        .build();

        System.out.println(httpRequest);
    }    
}