/*
  Program4.java
*/

import java.io.*;
import java.util.*;

public class Program4
{
	static final int NOT_FOUND = -1;
    public static void main( String[] args )
    {
try
	{
		Scanner kbd = new Scanner( System.in );
        Random rand = new Random( 17 ); // note the seed
		int[] arr = new int[20];

		randomizeArray( arr, rand ); // fill with random ints between ,1 .. 100 inclusive, no dupes
		printArray( "\nRANDOM:", arr );
		bubbleSort( arr );
		printArray( "BUBBLESORTED:", arr );

		randomizeArray( arr, rand );  // fill with more random ints between 1 .. 100 inclusive, no dupes
		printArray( "RANDOM:", arr );
		selectionSort( arr );
		printArray( "SELECTIONSORTED:", arr );

		do
		{
			int target = 0;
			System.out.print("\nNumber to search for: ");
			target = kbd.nextInt();
			if (target==0) break;
			int index = bSrch( arr, target ); // assume array is full
			if (index != -1)
				System.out.print(target + " FOUND at index " + index );
			else
				System.out.print(target + " NOT found." );

		} while (true); // infinite loop only exits via break

	} // LEAVE THIS HERE - DO NOT MODIFY
	catch (Exception e ) // catch-all  Exception is the most general Exception type
	{
		System.out.println("EXCEPTION DETECTED\n" + e );  // THIS WILL SHOW UP IN YOUR OUTPUT AND I CAN DETECT IT
		System.exit(0);
	}

	} // END MAIN

	// ########################################################################################
	// - - - - - - -  G I V E N    M E T H O D S.  D O  N O T   M O D I F Y   - - - - - - - - -

    // USE THIS METHOD AS GIVEN: DO NOT CHANGE

    private static void printArray( String label, int[] array )
    {
        System.out.println(label);
        for( int i=0 ; i<array.length ;++i )
            System.out.printf("%-3d ",array[i] );
        System.out.println();
    }




	// ########################################################################################
	//  - - - - - -  Y O U   W R I T E   T H E S E   M E T H O D S   B E L O W - - - - - - - -


	// YOu need this to search your array BEFORE you put another random into it
	// because you must make sure you dont put the same number in twice
	// No Dupes allowed in any of the arryas

	private static int linearSearch( int[] arr, int target )
	{
		/* YOUR CODe HERE */
		return NOT_FOUND; // i.e. return -1 which is never a valid index - means NOT_FOUND
	}


	// YOU  WRITE THIS METHOD
	// BUBBLESORT:
	private static void bubbleSort( int[] arr )
	{
		// YOUR CODE HERE

		//	for i= index of the next_to_last element  DOWNTO 0
		//			for j = 0 upto i
		//					if arr[j] and arr[j+1] are out of order then swap 'em
	}

	// YOU  WRITE THIS METHOD
	// SELECTIONSORT
	private static void  selectionSort( int[]  arr )
	{
		// YOUR CODE HERE -
		// YOU MUST USE THE indOfMin() (or max if you prefer) METHOD IN THIS METHOD

		// for stopInd = index of last element  DOWNTO   0
		//			swap the i'th element with element at indOfMax(arr,stopInd)   (puts  largest remaining element in its proper place)
	}


	// YOU  WRITE THIS METHOD
	// INDOFMIN

	private static int indOfMin( int[] arr,  int stopInd )
	{
		// YOUR CODE HERE
		// for i = 0 upto stopInd
		//		keep track of the smallest number you have seen so far and save the index postion of each new winner
		//
		// return the index position of the smallest number seen in this range
		return 0;  // JUST TO MAKE IT COMPILE - YOU CHANGE AS NEEDED
	}

 	// YOU WRITE THIS METHOD

	private static int bSrch( int[] arr, int target )
	{
		return NOT_FOUND; // i.e. return -1 which is never a valid index - means NOT_FOUND
	}

    // fill the array ONLY with random numbers between 1..100 inclusive
    // no duplicates allowed!

	private static void randomizeArray( int[] arr, Random r )
	{

	}
} // END Of CLASS PROGRAM2
