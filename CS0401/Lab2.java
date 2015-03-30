/*
	Lab2.java
	YOUR NAME: Wentao Jiang
	YOUR ID: WEJ10

	Dimensions an array whose size determined by cmd arg[0]
	Fills the  array of with random ints in range arg[1] .. arg[2] inclusive
	Reports the min.max and average values of the array
*/


import java.io.*;
import java.util.Random;

public class Lab2
{

	// D O   N O T   M O D I F Y    M A I N

	public static void main( String args[] )
	{

		// WE GIVE YOU THIS AS AN EXAMPLE OF HOW TO CORRECTLY
		// CHECK FOR THE REQUIRED COMMAND LINE ARGS

		if (args.length < 3)
		{
			System.out.println("\n\n...You must enter 3 ints on cmd line\n" +
			                       "   array dimension (positive int) \n" +
			                       "   lo value (positive it) \n" +
			                       "   hi value (hi > lo)\n");
			System.exit(0);
		}

		// WE GIVE YOU THIS AS AN EXAMPLE OF HOW TO DIMENSION AN ARRAY
		// AND CONVERT CMD ARGS TO INTS

		int dimension = Integer.parseInt( args[0] );
		int lo = Integer.parseInt( args[1] );
		int hi = Integer.parseInt( args[2] );
		int[] array = new int[dimension];


		randomFill( array, lo, hi ); // you write the code for this  method below

		printArray( array );

		System.out.println("Array minimum: " +  minVal( array ));  // you write the code for this method below
		System.out.println("Array maximum: " +  maxVal( array ));  // you write the code for this method below
		System.out.printf ("Array average: %.4f", aveVal( array ));  // you write the code for this method below

	}

	public static void printArray( int array[] )
	{
		System.out.printf("Arrays has %d values:\n", array.length );

		for( int i=0 ; i < array.length ; ++i )
			System.out.print( array[i] + " " );
		System.out.println();
	}


	// -----------------------------------------------------------
	// Y O U R  C O D E   G O E S   B E L O W
	// -----------------------------------------------------------

	// !ALWAYS! compute min or max by setting the result to the first element then testing for new winner thereafter
	// This eliminates need for any assumption about range of values expected in the array


	public static int minVal( int array[] )
	{
		int min = array[0];
		for (int i=1; i<array.length; i++)
		{
			if(min > array[i])
				min = array[i];
		}
		return min; // This is just to make it compile - replace with your code
	}

	public static int maxVal( int array[] )
	{
		int max = array[0];
		for (int i=1; i<array.length; i++)
		{
			if(max < array[i])
				max = array[i];
		}
		return max; // This is just to make it compile - replace with your code
	}

	public static double aveVal( int array[] )
	{
		int sum = 0;
		for (int i=0; i<array.length; i++)
		{
			sum += array[i];
		}
		double ave = (double) sum/array.length;
		return ave; // This is just to make it compile - replace with your code
	}


	// FILL THE ARRAY WITH RANDOK INTS

	public static void randomFill( int array[], int lo, int hi )
	{
		Random rand = new Random( 17 );  // DO NOT REMOVE THIS LINE
		
		for (int i=0; i<array.length; i++)
		{
			array[i] = rand.nextInt(hi-lo+1) + lo;
		}
		// Write a loop that repatedly generates the next random int between lo and hi inclusive
		// Every number you generate must be put into the array. Do not skip any numbers
		// Don't worry about dupes - just append every number you generate.
	}


} // END class
