/*
	methDemo2.java

	- writing a method in same file as main method
	- calling method from main
	- passing a value into a method via parameter list
*/

import java.io.*;
public class methDemo2
{
	public static void main( String args[] )
	{
		sayMsg( "Hi Java" ); // pass in the message we want printed

		String msg = "Bye Java";
		sayMsg( msg ); // passing in a differnt string prints a different message

	} // END main

	// ---------------------------------------------
	// METHODS GO HERE - OUTSIDE OF THE MAIN METHOD
	// ---------------------------------------------

	// method is a void method. It takes 1 String parameter

	private static void sayMsg( String msg )
	{
		System.out.println( msg );
	} // END sayMsg

} // EOF
