// my Pitt ID:
// my name:

import java.util.*;
import java.io.*;

public class ExamScores
{
	public static void main( String args[] ) throws Exception
	{
			// close/reuse this file handle on the next file
			BufferedReader infile = new BufferedReader( new FileReader( "ExamScores.txt" ) );

			// you declare all needed ArrayLists and other variables from here on.
			ArrayList<String> lines = new ArrayList<String>();

			System.out.println("\nSTEP #1: 50%");  // 50%
			while (infile.ready()) {
				String line = infile.readLine();
				System.out.println(line);
				lines.add(line);
			}
			infile.close();


			System.out.println("\nSTEP #2: 25%");  // 75 %
			Collections.sort(lines);
			for (String s: lines)
				System.out.println(s);

			System.out.println("\nSTEP #3: 10%");  // 85%

			TreeMap<String, ArrayList<Integer>> st2sc = new TreeMap<String, ArrayList<Integer>>();
			TreeMap<Double, String> ave2st = new TreeMap<Double, String>();
			int[] sum = new int[lines.get(0).split("\\s+").length-1];
			
			infile = new BufferedReader ( new FileReader("query.txt") );
			String[] queryS= infile.readLine().split(" ");
			int[] query = new int[queryS.length];
			for (int i=0; i<queryS.length; i++)
				query[i]=Integer.parseInt(queryS[i]);
			for (String s: lines)
			{	
				double sumq = 0;
				double aveq = 0;
				String[] tokens = s.split("\\s+");
				ArrayList<Integer> scores = new ArrayList<Integer>();
				for (int t=1; t<tokens.length; t++){
					scores.add(Integer.parseInt(tokens[t]));
				}
				st2sc.put(tokens[0], scores);
				for (int q: query)
					sumq += Integer.parseInt(tokens[q]);
				for (int nth = 0; nth<sum.length; nth++){
					sum[nth]+= Integer.parseInt(tokens[nth+1]);
				}
				aveq = sumq/3;
				ave2st.put(aveq, tokens[0]);
			}
			for (double f: ave2st.keySet())
				System.out.printf(ave2st.get(f)+" "+"%.2f\n", f);

			System.out.println("\nSTEP #4: 15%"); // 100%
			
			int lowest = sum[0];
			int which = 0;
			for (int i=1; i<sum.length; i++)
			{
				if (sum[i]<lowest)
				{
					lowest = sum[i];
					which = i;
				}
			}
			System.out.println("exam"+(which+1)+" had the lowest average");


	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END EXAMSCORES CLASS