/*
	srchDemo.java
	demonstrates the Random object
	demonstrates global values

*/


import java.io.*;
import java.util.*;

public class srchDemo
{
	// this value is declared "global" to all the code in this class.

	static final int NOT_FOUND = -1; // -1 is not a possible index postion

	public static void main( String args[] )
	{
		Scanner kbd = new Scanner( System.in);
		Random r= new Random(); // random # generator
		final int MAX_VAL = 99;
		final int QUIT = -1; // -1 would not be found in our array  

		
		int arr[] = new int[10]; // arr[-]---> [][][][][][][][][][]

		// fill the array with random numbers between 0 and 99

		for (int i=0 ; i<arr.length; ++i ) 
			arr[i] = r.nextInt( MAX_VAL+1 ); // random # in 0..99

		printArray( arr ); 

		System.out.println("\nLet's search the array now:\n");		
		int target = -1; // for our purposes: -1 means quit searching
		do
		{
			System.out.print("Search for? "); 
			target = kbd.nextInt(); // expecting a positive number here
			if ( target == QUIT) break;
			int index = linearSearch( arr, target );
			if (index == NOT_FOUND)
				System.out.println( target + " NOT found");
			else
				System.out.println( target + " FOUND at index: " + index );		
		} while (true); // infinite loop only terminates via break


	}

	public static void printArray( int array[] )
	{
		for (int i=0 ; i<array.length; ++i )
			System.out.print(array[i] + " ");
		System.out.println("\n");
	}


	public static int linearSearch( int array[], int target)
	{
		for (int i=0 ; i<array.length ; ++i )
			if (array[i] == target) return i;

		return NOT_FOUND; // if you make it here it was not found
	}


} // END class

