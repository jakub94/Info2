package ScrabbleCheater;


public class Permutation 
{

	public Permutation(String word) 
	{
	}

	@Override
	public int hashCode() 
	{
		return getNormalized().hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		return false;
	}

	@Override
	public String toString() 
	{
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() 
	{
		return null;
	}

	public String getWord() 
	{
		return null;
	}

	public int length() 
	{
		return 0;
	}

}
