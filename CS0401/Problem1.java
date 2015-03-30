// cs 007 Summer 12  (Hoffman) Final Exam Problem 1
// my Pitt ID:
// my name:

import java.util.*;
import java.io.*;

public class Problem1
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
			ArrayList<String> cna2cnuList = new ArrayList<String>();
			while (infile.ready())
			{
				String[] course = infile.readLine().split(" ");
				cna2cnuList.add(course[1]+" "+course[0]);
			}
			infile.close();
			Collections.sort(cna2cnuList);
			for (String s: cna2cnuList)
			{
				System.out.println(s);
			}

			System.out.println("\nSTEP #4: 15%"); // 100%

			for (int i=0; i<s2cList.size(); i++)
			{
				for (String s: cna2cnuList)
				{
					String[] course = s.split(" ");
					s2cList.set(i,s2cList.get(i).replaceAll(course[1],course[0]));
				}	
			}
			for (String s: s2cList )
			{
				System.out.println(s);
			}

	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END PROBLEM1 CLASS