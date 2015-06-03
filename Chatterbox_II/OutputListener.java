package Chatterbox_II;
import java.io.DataInputStream;

public class OutputListener extends Thread
{
    private DataInputStream input;
    private String message;
    private boolean newMessage;
    
    public OutputListener(DataInputStream inputStream)
    {
        this.message = "";
        this.input = inputStream;
        this.setDaemon(true);
    }
    
    public void run()
    {
        while(Thread.currentThread().isAlive())
        {
            try 
            {
                message = DataInputStream.readUTF(input);
                newMessage = true;
            } 
            catch(Exception ex)
            {
               return;
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
