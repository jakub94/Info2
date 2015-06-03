package ScrabbleCheater;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.naming.NoInitialContextException;

public class PermutationUtilities 
{

	/**
	 * creates a set with all subsets of the input string
	 * 
	 * @param str
	 * @return
	 */
	public static Set<String> getSubSets(String str) 
	{
		HashSet<String> normalizedStrings = new HashSet<String>(); 
		normalizedStrings.add(new Permutation(str).getNormalized()); 
		normalizedStrings = getSubSets(normalizedStrings, str);
		return normalizedStrings; 
	}

	private static HashSet<String> getSubSets(HashSet<String> h, String current)
	{	
		int length = current.length();
		
		if(length > 2)
		{
			for(int i = 0 ; i < length; i++)
			{
				String tmp = new Permutation(dropLetter(current, i)).getNormalized(); 
				h.add(tmp); 
				getSubSets(h, tmp); 
			}
		}
		return h;
	}

	//Returns the given String without the letter on position pos;
	private static String dropLetter(String str, int pos)
	{
		int length = str.length(); 
		if(pos > length)
			return null;
		
		return str.substring(0, pos) + str.substring(pos + 1, length); 
	}

	public static String createPermutation(int length) 
	{
		String per = ""; 
		Random rand = new Random(); 
		for(int i = 0 ; i < length ; i++)
		{
			per += (char) (97 + rand.nextInt(26));

		}
		return per; 
	}

	public static String createPermutation(String p) 
	{
		String per = ""; 
		int length = p.length(); 
		Random rand = new Random(); 
		char[] shuffle = new char[length];

		for(int i = 0; i < length ; i++)
		{
			int s = rand.nextInt(length); 
			if(shuffle[s] == 0)
			{
				shuffle[s] = p.charAt(i); 
			}
			else
				i--; 
		}

		for(int i = 0 ; i < length ; i++)
		{
			per += shuffle[i]; 
		}
		return per; 

	}
}
