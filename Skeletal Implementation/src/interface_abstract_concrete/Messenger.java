package interface_abstract_concrete;

public interface Messenger 
{
    void sendMessage(String recipient, String message);

    boolean isConnected();

    void connect();
}