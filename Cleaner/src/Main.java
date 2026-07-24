public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("1. try-with-resources (AutoCloseable)"); 
        try (FileReader fileReader = new FileReader("first_file.txt"))
        {
            fileReader.printFileContent();
        }

        System.out.println("\nGC (Cleaner)");
        foo();

        System.gc();
        try 
        {
            Thread.sleep(200);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }   
    
    private static void foo()
    {
        FileReader fileReader = new FileReader("second_file.txt");

        fileReader.printFileContent();
    }
}