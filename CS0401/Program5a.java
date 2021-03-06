/*
	Progam5.java
	uses ">>" and "&" operators to solve knapsack problem

	Requires one args on cmd line:  input filename
	Outputs to stdout (screen)
*/

import java.io.*;
import java.util.*;

public class Program5a
{
	private static final int CARDINALITY = 16;

	public static void main( String[] args ) throws Exception
	{
			long startTime = System.currentTimeMillis();

			Scanner infile = new Scanner (new File (args[0]));
			int intArr[] = new int[CARDINALITY];
			int target = 0;
			for (int i=0; i<CARDINALITY; i++)
			{
				intArr[i]= infile.nextInt();
				System.out.print(intArr[i]+" ");
			}
			target = infile.nextInt();
			System.out.println("\n"+target);

			Arrays.sort(intArr);
			/*
				sum = 0
				FOR bitMap =  1 .. 65565 inclusive
					USE BIT PATTERN AS MAP INTO ARRAY TO SELECT SUBSET
					YOU DON'T NEED TO STORE THAT SUBSET -  JUST SUM THE ELEMENTS
				END FOR

				IF sum == target THEN call printSubset
			*/

			int sum = target;
			int jump = 1;
			int skipped = 0;
			for (int bitMap = 65535; bitMap > 0; bitMap--)
			{
				for (int i=15; i>=0; i--)
				{
					if ((bitMap>>i & 1) == 1)
					{
						sum-=intArr[15-i];
					}
					if (sum < 0)
					{
						for (int j = i; j>0; j--)
						{
							jump*=2;
						}
						bitMap-=jump;
						skipped += jump;

						jump = 1;
						break;
					}
					if (sum == 0)
					{
						for (int j = i; j>0; j--)
						{
							jump*=2;
						}
						break;
					}
				}  
				if (sum == 0)
				{
					bitMap-=(jump-1);
					printSubset ( intArr, bitMap );
					jump = 1;
				}
				sum = target;
			}
			long endTime = System.currentTimeMillis();
			long ms = endTime-startTime;
			System.out.println("time used:"+ms);
			System.out.println(skipped);

			// THAT'S IT - YOU'RE DONE


	} // END main


	private static void printSubset( int[] set, int bitMap )
	{
		/* FOR I= 15 DOWNTO 0

				IF THE I'TH BIT OF BITMAP IS A 1 THEN
					PRINT THE [15-i]th ELEMENT OF THE SET
					REMEMBER BIT INDEX/POSTIONS ARE REVERSE OF ARRAY INDICES
		*/
		for (int i=15; i>=0; i--)
		{
			if ((bitMap>>i & 1)==1)
			{
				System.out.print(set[15-i] + " ");
			}
		}
		System.out.println();
	}

} // END  CLASS PROGRAM5











