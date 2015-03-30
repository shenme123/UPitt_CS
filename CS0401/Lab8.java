import java.util.*;
import java.io.*;

public class Lab8
{
	public static void main( String args[] ) throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader infile =  new BufferedReader( new FileReader( args[0] ) );
		
		int dim = Integer.parseInt(args[0].substring(0,1));
		int maxLen= dim*dim+1;  // CHANGE THIS: a 3x3 grid has a max string length of 9,  4x4 grid has a max string length of 16
		int[] histogram = new int[maxLen]; // because out inputfile is a 4 by 4 longest string can only be 16

		long startTime = System.currentTimeMillis();
		while (infile.ready())
		{
			// right now this is an infinite loop
			// read in the strings and generate the freq histogram
			list.add( infile.readLine() );
			for (int i=0; i<maxLen; i++)
			{
				if (list.get(list.size()-1).length()==i)
				{
					histogram[i]++;
					break;
				}
			}
		}
		infile.close();

		System.out.printf( "List contains %d Strings.\n",list.size());
		System.out.println("LEN\tFREQ");
		for ( int i = 0; i < histogram.length ; ++i) //
			System.out.printf( "%2d\t%d\n",i,histogram[i] );

		boolean unique = true;
		int indexOfDupe = 0;

		// Look at the Strings in the list and set unique to false if you find any dupes
		Collections.sort( list );
		for (int i=1; i<list.size(); i++)
		{
			if (list.get(i).equals(list.get(i-1)))
			{
				indexOfDupe = i;
				unique = false;
			}
		}

		if (unique)
			System.out.println("List has NO dupes.");
		else
			System.out.println("List has dupes at index position: " + indexOfDupe );

		long endTime = System.currentTimeMillis();
		long ms = endTime-startTime;
		System.out.printf("Elapsed time: %f seconds\n", ms/1000.0);
	}
}