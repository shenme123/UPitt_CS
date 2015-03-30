// cs 007 Summer 12  (Hoffman) Final Exam Problem 1
// my Pitt ID:
// my name:

import java.util.*;
import java.io.*;

public class Problem1a
{
	public static void main( String args[] ) throws Exception
	{
			// close/reuse this file handle on the next file
			BufferedReader infile = new BufferedReader( new FileReader( "student2courseNums.txt" ) );

			// you declare all needed ArrayLists and other variables from here on.

			System.out.println("\nSTEP #1: 50%");  // 50%

			ArrayList<String> s2cList= new ArrayList<String>();
			while (infile.ready())
			{
				s2cList.add(infile.readLine());
			}
			infile.close();

			for (String s:s2cList)
			{
				System.out.println(s);
			}
			

			System.out.println("\nSTEP #2: 25%");  // 75 %

			Collections.sort(s2cList);
			for (String s: s2cList)
			{
				System.out.println(s);
			}

			System.out.println("\nSTEP #3: 10%");  // 85%

			infile = new BufferedReader( new FileReader( "courseNum2CourseName.txt") );
			TreeMap<String,String> courseMap = new TreeMap<String, String>();
			while (infile.ready())
			{
				String[] course = infile.readLine().split(" ");
				courseMap.put(course[1], course[0]);
			}
			infile.close();

			for (Map.Entry<String,String> entry: courseMap.entrySet())
			{
				System.out.println(entry.getKey() + " " + entry.getValue());
			}

			System.out.println("\nSTEP #4: 15%"); // 100%

			for (String s: s2cList)
			{
				String[] words = s.split(" ");
				System.out.print(words[0]+" ");
				for (int i=1; i<words.length; i++)
				{
					System.out.print(courseMap.getKey(words[i])+" ");
				}
				System.out.println();
			}

	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END PROBLEM1 CLASS