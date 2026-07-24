import java.util.Objects;

public class Book 
{ 
    private String title;
    private String isbn;
    private double price;

    public String getTitle() { return title; }
    public String getIsbn()  { return isbn; }
    public double getPrice() { return price; }

    public void setTitle(String title) { this.title = Objects.requireNonNull(title); }
    public void setIsbn(String isbn)   { this.isbn = Objects.requireNonNull(isbn); }
    public void setPrice(double price) 
    { 
        if (price <= 0.0)
            throw new IllegalArgumentException("price <= 0: " + price);
        
        this.price = price; 
    }
}