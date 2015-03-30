/*
	methDemo3.java

	- writing a method in same file as main method
	- calling method from main
	- passing multiple values into a method via parameter list
*/

import java.io.*;
public class methDemo3
{
	public static void main( String args[] )
	{

		printSum( 4, 5 ); // pass in two literal values

		int a=12, b=3;
		printSum( a, b ); // pass in two variables


	} // END main

	// ---------------------------------------------
	// METHODS GO HERE - OUTSIDE OF THE MAIN METHOD
	// ---------------------------------------------

	// method is a void method. It takes 2 int parameters

	private static void printSum( int first, int second )
	{
		System.out.println( first + "+" + second + "= " + (first+second) );
	} // END printSum

} // EOF
