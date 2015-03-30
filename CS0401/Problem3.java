// cs 007 Summer 12  (Hoffman) Final Exam Problem 1
// my Pitt ID:
// my name:

import java.util.*;
import java.io.*;

public class Problem3
{
	public static void main( String args[] ) throws Exception
	{
		// close/reuse this file handle on the next file
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );

		TreeMap<String,String> ath2sp = new TreeMap<String,String>();

		while (infile.ready())
		{
			String[] athSp = infile.readLine().split(",");
			ath2sp.put(athSp[0], athSp[1]);
		}
		infile.close();

		infile = new BufferedReader( new FileReader(args[1]) );

		ArrayList<String> whoPlayed;
		ArrayList<String> sports ;
		
		while (infile.ready())
		{
			String line = infile.readLine();
			System.out.print(line+": ");
			whoPlayed = (new ArrayList<String>( Arrays.asList(line.split(",")) ));
			for (String s:ath2sp.keySet() )
			{
				sports = (new ArrayList<String>( Arrays.asList(ath2sp.get(s).split(" ")) ));
				if (sports.containsAll(whoPlayed))
				{
					System.out.print(s+", ");
				}
			}
			System.out.println();
		}
		infile.close();


	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END PROBLEM1 CLASS