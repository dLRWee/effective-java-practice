package com.dlrwee.example.interface_abstract_concrete;

public class EmailMessenger extends AbstractMessenger
{
    @Override
    protected void doSend(String recipient, String message)
    {
        System.out.println("Sending Email to " + recipient);
        System.out.println("Message: " + message);
    }

    @Override
    public void connect()
    {
        System.out.println("Connecting...");
        setConnected(true);
    }
}