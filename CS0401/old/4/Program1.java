/*
	Program #1 requires you to write 3 methods.

isPrime( int n )
isPerfect( int n )
isPalindrome( String s )
*/

/*
	PROGRAM #1

	This program takes a lower and upper bound from cmd line.

	After the lower and upper are entered write another loop that finds all the prime numbers between
	lower and upper inclusive then finds all the perfect numbers in that same range.

	Lastly the program examines a list of strings to see if they are palindromes or not.
*/

import java.io.*;

public class Program1
{

	public static void main (String[] args) throws IOException
	{
		// DO NOT MODIFY ANYTHING in MAIN
		
		int lo=0,hi=0; // range of #s to look for primes and perfects
		String[] words = { "radar", "stanleyyelnats", "foobar", "madamimadam", "palindrome", "amanaplanacanalpanama" }; // holds the palindrome candidates

		if (args.length < 2)
		{
				System.out.println("Missing args!");
				System.exit(0);
		}

try // WE WILL TALK aBOUT EXCPETIONS SOON - DONT CHANGE ANYTHING IN MAIN 
{
		lo=Integer.parseInt( args[0] );   // if arg not a number then this statement will CRASH (throw Exception)
		hi=Integer.parseInt( args[1] );  // if arg not a number then this statement will CRASH (throw Exception)
		if (lo >=hi  || lo < 3) System.exit(0);

		System.out.println("Printing all/only prime numbers between " + lo + " and " + hi + " inclusive");
		for (int i=lo ; i<=hi ; ++i)
		{
			if ( isPrime(i) )
				System.out.print( i + " ");
		}
		System.out.println();

		System.out.println("\nPrinting all/only perfect numbers between " + lo + " and " + hi + " inclusive");
		for (int i=lo ; i<=hi ; ++i)
		{
			if ( isPerfect(i) )
				System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("\nPrinting each word and identifying which are palindromes");
		for (int i=0 ; i<words.length ; ++i)
		{
			if ( isPalindrome(words[i]) )
				System.out.println( words[i] + "  IS palindrome");
			else
				System.out.println( words[i] + "  NOT palindrome");
		}
}
catch ( Exception e ) // WE WILL DICUSS TRY/CATCH SOON - JUST DON'T MODIFY ANYTHING HERE
{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
	System.exit( 0 );
}

	} // END main

	// ........................... M E T H O D S   Y O U   M U S T  W R I T E .........................


	// This method takes an int and returns TRUE if that int is a prime
	// A prime number is one that is only divisible my itself and 1

	private static boolean isPrime( int n )
	{
			// YOUR CODE HERE. DO NOT WRITE TO STDOUT (the screen)
			return false; // just to make it compile
	}


	// This method takes an int and returns TRUE if that int is a perfect number
	// A perfect number is one that is the sum of its factors
	// 28 is perfect because the factors of 28 are 1 2 4 7 and 14
	private static boolean isPerfect( int n )
	{
			// YOUR CODE HERE. DO NOT WRITE TO STDOUT (the screen)
			return false; // just to make it compile
	}

	// This method takes a string and returns TRUE if that string is a palindrome
	// A palindrome is a string that is symmetric in spelling
	// "radar" is a palindrome while "foobar" is not
	private static boolean isPalindrome( String s )
	{

			// YOUR CODE HERE. DO NOT WRITE TO STDOUT (the screen)
			return false; // just to make it compile
	}


} //END CLASS PROGRAM1