package Chatterbox;

import java.util.Scanner;


public class ChatOutMsgListener extends Thread
{
    private String input;
    private boolean newInput;
    private boolean quit;
    public ChatOutMsgListener()
    {
        input = "";
        newInput = false;
        quit = false;
    }
    
    public void run()
    {
        Scanner scanner;
        
        while(true)
        {
            scanner = new Scanner(System.in);
            this.input = scanner.nextLine();
            if(input.equals("quit"))
            {
                this.quit = true;
                break;
            }
            
            else
                newInput = true;
            
        }
        scanner.close();
    }
    
    public String getInput() 
    {
        newInput = false; 
        
        String tmp = input;
        input = "";
        
        return tmp;
    }
    
    public boolean hasNewInput()
    {
        return newInput;
    }

     public boolean quit()
     {
        return quit;
     }
    
}


