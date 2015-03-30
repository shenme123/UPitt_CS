/*
	methDemo4.java

	- writing a method in same file as main method
	- calling method from main
	- passing multiple values into a method via parameter list
	- returning a value from a method
*/

import java.io.*;
public class methDemo4
{
	public static void main( String args[] )
	{
		int sum = calcSum( 14, 10);  // method call produces a value - assign it into sum
		System.out.println("14+10= " + sum );

		// we can put our int producing method call in any place where an int value would normally work

		System.out.println("5+7= " + calcSum( 5, 7) ); // place the method call INSIDE a print

		int a=12, b=3;
		System.out.println(a + "+" + b + "= " + calcSum( a, b) ); // place method call INSIDE a print

	} // END main

	// ---------------------------------------------
	// METHODS GO HERE - OUTSIDE OF THE MAIN METHOD
	// ---------------------------------------------

	// method is an int method. It takes 2 int parameters
	// and returns an int

	private static int calcSum( int first, int second )
	{
		return first+second;
	} // END calcSum

} // EOF
