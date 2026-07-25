package interface_abstract_concrete;

public class Main
{
    public static void main(String[] args) 
    {
        EmailMessenger emailMessenger = new EmailMessenger();
        
        emailMessenger.sendMessage("IDK", "Hi!");
    }
}