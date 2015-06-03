package TextAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.io.PrintWriter;

public class TextAnalyzer {

	private BufferedReader br = null;  
	private PrintWriter pw = null; 
	private TreeMap<Character, Integer> characterFrequencies = new TreeMap<Character, Integer>();
	
	
	public TextAnalyzer(String inputFile, String outputFile) throws FileNotFoundException, IOException
	{
		br = new BufferedReader(new FileReader(inputFile));
	}
	
	public char transformToUpperCase(char c)
	{
		return Character.toUpperCase(c); 
	}	
	
		
	public TreeMap<Character, Integer> getCharacterFrequencies() {
		return characterFrequencies;
	}

	public void readAndAdd() 
	{
		String currentLine;
		try
		 { 

			 while ((currentLine = br.readLine()) != null) 
			 { 
				 for(int i = 0; i < currentLine.length(); i++)
				 {
				 char c = currentLine.charAt(i);
				 c = transformToUpperCase(c);
				 addCharacterToMap(c);
				 }
			 }
		 }
		 catch(IOException ioException)
		 {
			 ioException.printStackTrace();
		 }	
		 finally 
		 {
				try 
				{
					if (br != null)br.close();
				} 
				
				catch (IOException ex) 
				{
					ex.printStackTrace();
		        }
	     }	
	
    }
	
	
	//Adds a character to the Map characaterFrequencies as a Key and stores how many times it has occured (in the value)
	private void addCharacterToMap(char c)
	{

		Character currenctCharacter = new Character(c);



		// check if already contained in Map. If not, add and change frequency to 1
		if(!(characterFrequencies.containsKey(currenctCharacter)))
		{
			characterFrequencies.put(currenctCharacter, 1);
		}
		// if already contained in map increment frequency 
		else
		{
			int frequency = characterFrequencies.get(currenctCharacter); 
			frequency++; 
			characterFrequencies.put(currenctCharacter, frequency);
		}

	}
	
	// Take the Frequencies from the TreeMap and write them to a new file 
	public void writeFrequenciesToFile(String outputFile)
	{
			deleteFile(outputFile); // delete File so new File with new Output can be created 
		   Set<Character> characters = characterFrequencies.keySet();
		   for (Iterator<Character> i = characters.iterator(); i.hasNext();) 
		   {
		     char character = (char) i.next();
		     int frequency = (int) characterFrequencies.get(character);
		     String characterFrequency = ""; 
		     
		     for(int n = 0; n < frequency; n++)
		     {
		    	 characterFrequency = characterFrequency + "*";
		     }
		     writeToFile(outputFile, character + " " + characterFrequency);
		     
		   }
	}
	
	public void writeToFile(String outputFilePath, String text)
	{
		try 
	    {
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, true))); //True tells the writer to "append" lines instead of replacing the old text
	    pw.println(text);
	    pw.close();
	    } 
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
	    }
	}
	
	public void deleteFile(String fileName)
	{
		File file = new File(fileName);
		file.delete(); 
	}
}
