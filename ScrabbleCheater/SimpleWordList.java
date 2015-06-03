package ScrabbleCheater;
import java.util.HashSet;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SimpleWordList implements WordList 
{

	private HashMap<String, HashSet<String>> words; 


	public SimpleWordList()
	{
		words = new HashMap<String, HashSet<String>>(); 
	}

	@Override
	public Set<String> permutations(String tileRackPart) 
	{
		String normalized = new Permutation(tileRackPart).getNormalized(); 
		if(words.containsKey(normalized))
			{
				return words.get(normalized); 
			}
		return null; 
	}
	
	@Override
	public Set<String> words(String tileRack) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String word) 
	{
		try
		{
			String normalized = new Permutation(word).getNormalized(); 

			if(words.containsKey(normalized))
			{			
				HashSet<String> h = words.get(normalized);
				h.add(word); 

			}
			else 
			{
				HashSet<String> h = new HashSet<String>(); 
				h.add(word);
				words.put(normalized, h); 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true; 
	}

	@Override
	public boolean addAll(Collection<String> words) 
	{
		try
		{
			for(String word : words) // local words variable
				add(word); //Add to Map
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return false; 
		}
		return true; 
	}

	@Override
	public int size() 
	{
		Collection<HashSet<String>> values = words.values(); 
		int size = 0; 
		
		for(HashSet<String> value : values)
			size += value.size();
		
		return size; 
	}

	@Override
	public WordList initFromFile(String fileName)
	{
		SimpleWordList simpleWordList = new SimpleWordList();
		BufferedReader br;

		try
		{
			br = new BufferedReader(new FileReader(fileName));
			String word = br.readLine();

			while(word != null)
			{
				simpleWordList.add(word);
				word = br.readLine(); 
			}
			br.close();

		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}



		return simpleWordList; 
	}

}
