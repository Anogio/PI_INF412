import java.util.LinkedList;

public class Naive {
	
	//implements the naive algorithm
	public static LinkedList<Integer> naive(String S, String q)
	{
		int n=S.length();
		int m=q.length();
		LinkedList<Integer> occurences = new LinkedList<Integer>();
		
		for(int k=0 ; k<n-m+1 ; k++)
		{
			if(Tools.compareSub(q, S, k, k+m)) occurences.add(k);
		}
		return occurences;
	}
}
