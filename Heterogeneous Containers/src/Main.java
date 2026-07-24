public class Main 
{
    public static void main(String[] args) 
    {
        ApplicationContext context = new ApplicationContext();    

        context.putData(Integer.class, 67);
        context.putSerializable(String.class, "Hello, Sexter Morgan");

        Integer contextInteger = context.getData(Integer.class);
        String contextString = context.getData(String.class);

        System.out.println(contextInteger);
        System.out.println(contextString);
    }
}