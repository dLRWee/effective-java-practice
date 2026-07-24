import java.util.ArrayList;
import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Iceman", 25));    
        authors.add(new Author("Batman", 47));    
        authors.add(new Author("Jocker", 39));
        
        Book book = new Book("The Dark Night", authors);
        Book bookCopy = Book.copyOf(book);
    }    
}