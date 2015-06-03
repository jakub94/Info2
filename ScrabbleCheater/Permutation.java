package ScrabbleCheater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Permutation 
{

	private String word;	
	
	public Permutation(String word) 
	{
		this.word = word; 
		
	}

	@Override
	public int hashCode() 
	{
		return getNormalized().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		 
		try
		{
			Permutation per = (Permutation)(obj);
			return getNormalized().equals(per.getNormalized()); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false; 
		}
		
		
		

	}

	@Override
	public String toString() 
	{
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() 
	{

		
		ArrayList<Character> charList = new ArrayList<Character>();
		char[] chars = word.toCharArray();
		for(char c: chars)
		{
			charList.add(c); 
		}
		
		Collections.sort(charList);
		
		
		String normalized = ""; 
		for(Character c: charList)
		{
			normalized += c; 
		}

		return normalized; 
		
		
	} 

	public String getWord() 
	{
		return word;
	}

	public int length() 
	{
		return 0;
	}

}
