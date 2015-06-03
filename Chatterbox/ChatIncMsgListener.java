package Chatterbox;

import java.io.DataInputStream;

public class ChatIncMsgListener extends Thread
{
    private DataInputStream input;
    private String message;
    private boolean newMessage;
    
    public ChatIncMsgListener(DataInputStream inputStream)
    {
        this.message = "";
        this.input = inputStream;
    }
    
    public void run()
    {
        while(true)
        {
            try 
            {
                message = DataInputStream.readUTF(input);
                newMessage = true;
            } 
            catch(Exception ex)
            {
                break;
            } 
        }
    }
    
    public String getMessage() 
    {
        String tmp = message;
        message = "";
        
        newMessage = false;
        return tmp;
    }
    
    public boolean hasNewMessage()
    {
        return (newMessage);
    }
}
