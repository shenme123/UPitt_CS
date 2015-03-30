/*
	Lab5.java

	WORKING WITH ARRAYS

	Requires you fill in the following methods:

	resize()
	bubbleSort()
	trim()
*/



import java.io.*;
import java.util.*;

public class Lab5
{
	public static void main( String args[] )
	{
try
{
	Scanner infile = new Scanner(new File(args[0]));
	String[] wordArr = new String[5]; // this AINT big enuf!
	int wordCnt=0; // # or words stored in the array
	while (infile.hasNext())
	{
		if ( wordCnt == wordArr.length ) // array is FULL!! need to double its capacity
			wordArr = resize( wordArr ); // returs a ref to the bigger array
		wordArr[wordCnt++] = infile.next();
	}

	printArray( wordArr, wordCnt );
	System.out.println("ARRAY CAPACITY IS: " + wordArr.length );
	System.out.println("ARRAY COUNT IS:    " + wordCnt );

	System.out.println("\nAFTER BUBBLESORT AND TRIM:" );
	bubbleSort( wordArr, wordCnt );
	wordArr = trim( wordArr, wordCnt );
	printArray( wordArr, wordCnt );
	System.out.println("ARRAY CAPACITY IS: " +  wordArr.length);
	System.out.println("ARRAY COUNT IS:    " + wordCnt );

}
catch ( Exception e ) // DO NOT MODIFY THIS CATCH CLAUSE IN ANY WAY
{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
	System.exit( 0 );
}
	} // END MAIN


	private static void  bubbleSort( String arr[], int count )
	{
		// your code here - use .compareTo to compare strings
		// you cannot use <, ==, or > etc.
	}

	private static String[] resize( String arr[] )
	{
		/*
			Declare a new array newArr to be twice as big as the incoming arr.
			Using a for loop, copy all the ref values from arr[i] into the newArr[i]
			Return the address ref var) of the newArr
		*/

		// this is not the right thing to return. It's here just to make it compile
		// You change as needed to retunre the ref ot the new/bigger array

		return arr;
	}

	private static String[] trim( String arr[], int count )
	{
			// hint: code is IDENTICAL to resize except
			// the new array's length is count instead of length*2
			return arr;
	}



	private static void printArray(String arr[], int cnt  )
	{
		/* print only the first cnt Strings each on its own line */
		for (int i=0 ; i<cnt ; ++i)
			System.out.println( "["+i+"]=" + arr[i] );
	}

} // END class


