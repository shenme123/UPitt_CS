// cs 007 Summer 12  (Hoffman) Final Exam Problem 1
// my Pitt ID:
// my name:

import java.util.*;
import java.io.*;

public class Problem2
{
	public static void main( String args[] ) throws Exception
	{
			// close/reuse this file handle on the next file
			BufferedReader infile = new BufferedReader( new FileReader( "studentScores.txt" ) );
			BufferedReader qFile= new BufferedReader ( new FileReader ( "query.txt") );
			ArrayList <String> studentScores= new ArrayList <String> ();
			ArrayList<Integer> number = new ArrayList<Integer>();
			ArrayList<Float> numberF = new ArrayList<Float>();
			TreeMap <Float, String> scoreToStudent=new TreeMap <Float, String>();
			ArrayList <Float> sNumber=new ArrayList<Float>();
			TreeMap <Integer, String> lowestScore=new TreeMap<Integer, String>();





			// you declare all needed ArrayLists and other variables from here on.

			System.out.println("\nSTEP #1: 50%");  // 50%
			while (infile.ready())
				studentScores.add(infile.readLine());
			infile.close();
			for (int i=0; i< studentScores.size(); i++)
			
				System.out.println(studentScores.get(i));
			

			System.out.println("\nSTEP #2: 25%");  // 75 %
			Collections.sort(studentScores);
			for (int i=0; i< studentScores.size(); i++)
				System.out.println(studentScores.get(i));

			System.out.println("\nSTEP #3: 10%"); 
			
			String [] tokenQuery=qFile.readLine().split(" ");
			for (int i=0;i<tokenQuery.length ;i++ )
			number.add(Integer.parseInt(tokenQuery[i]));
			

			
			for (int i=0; i< studentScores.size(); i++)
		{
				Float sum=0.0f;
				numberF.clear();
				
				studentScores.set(i,studentScores.get(i).replaceAll("  "," "));
				//expr = expr.replaceAll(" ", "");

				String [] tokenScores=studentScores.get(i).split(" ");
				for (int j=1; j< tokenScores.length; j++) 
			{
					numberF.add(Float.parseFloat(tokenScores[j]));
					if (lowestScore.containsKey(j))  lowestScore.put(j, lowestScore.get(j)+" "+tokenScores[j]);
					else lowestScore.put(j, tokenScores[j]);
			}

				for (int j=0;j< 3 ; j++)
				sum=sum+ numberF.get(number.get(j)-1);
				float mean=sum/3;
				scoreToStudent.put(mean, tokenScores[0]);
		}
		for (Float avg:scoreToStudent.keySet())
		
			sNumber.add(avg);
			Collections.sort(sNumber);
		for (Float avg:scoreToStudent.keySet() )
		
		{
			System.out.print(scoreToStudent.get(avg)+" ");
			System.out.printf("%.2f",avg);
			System.out.println();
		}


			System.out.println("\nSTEP #4: 15%"); // 100%
			int min=100;
			int index=0;
			for (int minimum: lowestScore.keySet() )
			{
				String [] score=lowestScore.get(minimum).split(" ");
				int sum=0;
				for (int i=0;i< score.length ;i++ ) sum=sum+Integer.parseInt(score[i]);
				int avg=sum/score.length;
				if (avg<min)
				{
					int temp=min;
					min=avg;
					avg=temp;
					index=minimum;

				}
			}
				System.out.println("exam"+index+" had the lowest average");


	} // END MAIN

	// - - - - - - H E L P E R   M E T H O D S   H E R E - - - - -


} // END PROBLEM1 CLASS