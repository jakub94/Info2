package TextAnalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;


public class TextAnalyzerDemo {
	
	private static TextAnalyzer textAnalyzer;

	public static void main(String[] args) {
		
		String inputFilePath = args[0]; 
		String outputFilePath = args[1]; 			
		
		initializeTextAnalyzer(inputFilePath, outputFilePath);
		textAnalyzer.readAndAdd(); 
		textAnalyzer.writeFrequenciesToFile(outputFilePath);
		
	}
	
	private static void initializeTextAnalyzer(String inputFilePath, String outputFilePath)
	{
		try 
		{
			textAnalyzer = new TextAnalyzer(inputFilePath, outputFilePath);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("File could not be found");
		}
		catch(IOException ioexception)
		{
			System.out.println("Location of new file does not exist");
			ioexception.printStackTrace();
		}
	}
}

