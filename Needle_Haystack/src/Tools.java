import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tools {
	
	//Tests the equality of two strings
	public static boolean equal(String a , String b)
	{
		int n =a.length();
		boolean same=true;
		if(n!=b.length()) return false;
		else
		{
			int i=0;
			while(i<n && same)
			{
				if(a.charAt(i)!=b.charAt(i)) same=false;
				i++;
			}
		}
		return same;
	}
	
	//Tests whether q equals the substring of S between k and j-1
	public static boolean compareSub(String q, String S, int k, int j)
	{
		boolean match=true;
		int i=0 , m=j-k;
		while(match && i<m) {
			if(q.charAt(i)!=S.charAt(k+i))
			{
				match=false;
			}
			i++;
		}
		return match;
	}
	
	//Reads from a text file and returns a string
	static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            //sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
}
