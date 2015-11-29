import java.util.LinkedList;

public class KarpRabin {
	
	static double w =350377;
	//the function that calculates the hash of a string
	public static double hash(String s,double[] powerTable)
	{
		double h = 0;
		int m=s.length();
		for(int i=0; i<m ; i++)
		{
			double current = s.charAt(i);
			h+=(current*powerTable[m-i-1] )%w;
		}
		return h;
	}
	
	//Implements the Karp-Rabin algorithm
	public static  LinkedList<Integer> karprabin(String S, String q)
	{
		int m=q.length();
		int n=S.length();
		
		//This table is used to compute the hashes and contains all powers of 2 from 0 to m-1
		double[] powerTable=new double[m];
		powerTable[0]=1;
		for(int i=1; i<m ; i++) powerTable[i]=(2*powerTable[i-1]) %w;
		
		//The hash of the query string
		double compareHash = hash(q,powerTable);
		
		//The hash of the prefix of S of length m
		String sub=S.substring(0,m);
		double stringHash=hash(sub,powerTable);
		
		//The list containing the result
		LinkedList<Integer> occurences= new LinkedList<Integer>();
		
		if(compareHash==stringHash)
		{
			if(Tools.equal(q,sub)) occurences.add(0);
		}
		for(int k=1 ; k<n-m+1 ; k++)
		{
			//Update the hash
			stringHash=((stringHash - (S.charAt(k-1)*powerTable[m-1]) %w )*2 +S.charAt(m+k-1) )%w;
			//If hashes match, compare the strings
			if(stringHash==compareHash)
			{
				if(Tools.compareSub(q, S, k, k+m))
				{
					occurences.add(k);
				}
			}
		}
		return occurences;
		
	}
}
