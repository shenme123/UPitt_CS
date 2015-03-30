import java.io.*;
import java.util.*;

public class Lab9 
{ 
	public static void main(String args[]) throws Exception
	{
		HashMap<String, Integer> histogram = new HashMap <String, Integer>();
		int count = 0;

		BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		String word;
		while ( (word=infile.readLine()) != null )
		{
				 // YOUR CODE HERE
				 count = histogram.containsKey(word)? histogram.get(word):0;
				 histogram.put(word, count+1);
		}		
		infile.close();
		printHistogram( histogram );  
		
	} // END MAIN
		
	// YOU FILL IN THIS METHOD
	// READ PROBLEM SPECIFICATION TO SEE WHAT IS THE 80%, 100% and 125% CREDIT SOLUTION
	
	private static void printHistogram( HashMap<String,Integer> hm )
	{
		// YOUR CODE HERE
		ArrayList<String> wList = new ArrayList <String>();
		for (String word: hm.keySet() )
		{
			wList.add(word);
		}
		Collections.sort(wList);
		for (String word: wList)
		{
			System.out.println(word + "\t" + hm.get(word));
		}
	}
		
}
