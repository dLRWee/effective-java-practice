
public class Main 
{
    public static void main(String[] args)
    {
        Book printBook = Book.createPrintBook("Dexter", "Some dude", 67, 23.99);
        Book eBook = Book.createEBook("1984", "George O", 68, 12.75);

        System.out.println(printBook);
        System.out.println(eBook);
    }    
}