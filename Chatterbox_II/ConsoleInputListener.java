package Chatterbox_II;

import java.util.Scanner;


public class ConsoleInputListener extends Thread
{
    private String input;
    private boolean hasNewInput;
    public ConsoleInputListener()
    {
        input = "";
        hasNewInput = false;
        this.setDaemon(true);
    }
    
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        while(Thread.currentThread().isAlive())
        {
            this.input = scanner.nextLine();
            hasNewInput = true;
        }
        scanner.close();
    }
    
    public String getInput() 
    {
        hasNewInput = false; 
        
        String tmp = input;
        input = "";
        
        return tmp;
    }
    
    public boolean hasNewInput()
    {
        return hasNewInput;
    }   
}


