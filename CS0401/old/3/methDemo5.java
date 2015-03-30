/*
	methDemo5.java

	- writing a method in same file as main method
	- calling method from main
	- passing multiple values into a method via parameter list
	- returning a value from a method
	- declaring local variables inside a method
*/

import java.io.*;
public class methDemo5
{
	public static void main( String args[] )
	{
		int lo=1, hi=100;

		int rangeSum = calcRangeSum( lo, hi );  // sums all numbers in specified range

		System.out.println("sum of 1 thru 100= " + rangeSum );

	} // END main

	// ---------------------------------------------
	// METHODS GO HERE - OUTSIDE OF THE MAIN METHOD
	// ---------------------------------------------

	// method is an int method. It takes 2 int parameters
	// and returns an int
	// We can declare variables in this method - just like we did in main
	// main cannot see the vars in here, and this method cannot see the vars in main
	// the lo and hi declared in my parameter list are NOT the same lo and hi in main.

	private static int calcRangeSum( int lo, int hi)
	{
		int sum=0; // local variable - lives & dies in this method - invisible outside

		for (int i=lo ; i<=hi ; ++i)
			sum+=i;

		return sum; // sum of all the numbers from lo to hi inclusive
	} // END calcRangeSum

} // EOF
