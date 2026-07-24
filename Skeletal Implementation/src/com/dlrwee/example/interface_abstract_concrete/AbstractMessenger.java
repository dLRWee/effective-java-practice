package com.dlrwee.example.interface_abstract_concrete;

public abstract class AbstractMessenger implements Messenger
{
    private boolean isConnected;
    
    @Override
    public final void sendMessage(String recipient, String message)
    {
        if (!isConnected())
            connect();

        doSend(recipient, message);
    }

    @Override
    public final boolean isConnected()
    {
        return this.isConnected;
    }

    protected abstract void doSend(String recipient, String message);

    protected void setConnected(boolean state)
    {
        this.isConnected = state;
    }
}