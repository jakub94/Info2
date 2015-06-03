package ScrabbleCheater;

public class ScrabbleCheaterDemo
{

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Insufficient number of arguments...");
			return;
		}
		
		SimpleWordList words = new SimpleWordList();	
		WordList w = words.initFromFile(System.getProperty("user.dir") + "\\src\\ScrabbleCheater\\sowpods.txt");
		
		System.out.println("\nSize after initialisation:\n" + w.size());
		System.out.println("\nPermutaions of \"" + args[0] + "\":\n" + w.permutations(args[0]));
		System.out.println("\nSubsets of \"" + args[0] + "\":\n" + PermutationUtilities.getSubSets(args[0]));
		
		System.out.println("\nSubsets of \"java\":\n" + PermutationUtilities.getSubSets("java"));
	}
	
}
