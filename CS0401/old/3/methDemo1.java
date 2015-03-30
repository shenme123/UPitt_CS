/*
	methDemo1.java

	- writing a methods in same file as main method
*/

import java.io.*;
public class methDemo1
{
	public static void main( String args[] )
	{	
		sayHello(); // CALL the method then come back to main	
		
	} // END main
	
	// ---------------------------------------------
	// METHODS GO HERE - OUTSIDE OF THE MAIN METHOD
	// ---------------------------------------------
	
	// method is a void method. Does not return a value
	private static void sayHello()
	{
		System.out.println("Hello World");
	} // END sayHello	
	
} // EOF
