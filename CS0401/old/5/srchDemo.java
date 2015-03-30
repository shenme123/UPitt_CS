/*
	srchDemo.java


*/


import java.io.*;
import java.util.*;

public class srchDemo
{
	public static void main( String args[] )
	{
		Scanner kbd = new Scanner( System.in);

		// declare an array to be whatever length the user passes on the cmd line
		// check args.length FIRST

		// fil the array with random numbers between 1 and 100 inclusive

		// print the array

		// write a loop that repeatedly prompts user for another number to search for

		// if its found say at what index, if not repiort as NOT found

		// until user enters a NEGATIVE number indicating quit
	}

	public static void printArray( int array[] )
	{
		System.out.printf("The arrays has %d values:\n", array.length );

		// your code here loop thru array printing each value on saem line separated by a space

		System.out.println();

	}


	public static int linearSearch( int array[], target)
	{
		// loop thru the array from front to back comparing target to each elem
		// as soon as you match return the index where matched


		return -1; // if you make it here it was not found
	}


} // END class


