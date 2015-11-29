import java.io.IOException;
import java.util.LinkedList;

public class Main {
	
	/* The main method should be called with arguments -algo_1 ... -algo_n filename.txt query
	 * 	 with -algo_i= -n for naive algorithm
	 * 				 -kr for Karp-Rabin algorithm
	 * 				 -kmp for Knuth-Morris-Pratt algorithm
	 * 				 -bm for Boyer-Moore algorithm	
	 *	 with filename.txt the name of the file being searched
	 *	 with query the string being search in the text		
	 */
	public static void main (String[] args) throws IOException
	{
		
		int l=args.length;
		
		//The text being searched in
		String filename=args[l-2];
		String text= Tools.readFile(filename);
		
		//The string being searched for
		String query=args[l-1];
		
		LinkedList<Integer> occurences = new LinkedList<Integer>();
		long startTime,endTime, totalTime;
		
		boolean naive=false , karprabin=false, boyermoore=false, kmp=false;
		
		//Reads the parameters to choose which algorithms to use
		for(int i=0; i<l-2 ; i++)
		{
			if(Tools.equal(args[i], "-n")) naive=true;
			if(Tools.equal(args[i], "-kr")) karprabin=true;
			if(Tools.equal(args[i], "-kmp")) kmp=true;
			if(Tools.equal(args[i], "-bm")) boyermoore=true;
		}
		
		//Use the naive algorithm to search for text
		if(naive)
		{
			startTime=System.nanoTime();
			occurences=Naive.naive(text, query);
			endTime=System.nanoTime();
			totalTime=(endTime-startTime)/1000000 ;
			System.out.println("Naïve results: " + occurences.toString() +"(terminated in "+ totalTime +"ms)"+ "\n");
		}
		
		//Use tha Karp-Rabin algorithm to search for text
		if(karprabin)
		{
			startTime=System.nanoTime();
			occurences=KarpRabin.karprabin(text, query);
			endTime=System.nanoTime();
			totalTime=(endTime-startTime)/1000000 ;
			System.out.println("Karp-Rabin results: " + occurences.toString()+"(terminated in "+ totalTime +"ms)" + "\n");
		}
		
		if(kmp)
		{
			
		}
		
		if(boyermoore)
		{
			
		}

	}
}
