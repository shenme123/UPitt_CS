/*
	arrDemo.java

	- different forms of declaring array variables
	- initializing arrays
	- accessing the individual elements an array
	- copying arrays - deep vs. shallow copy
*/

import java.io.*;

public class arrDemo
{
	public static void main( String args[] ) throws IOException
	{


		// declare some arrays

		int arr1[] = { 2,4,6,8 };  // HARDCODE intial values
		int arr2[] = new int[10];  // use keyword "new" and constant dimension
		int arr3[];	               // just a refrence - no array created

		System.out.print("Enter a small positive number: " );
		int dimension = Integer.parseInt( kbd.readLine() );
		int arr4[] = new int[ dimension ]; // size of array can be determined at runtime

		// ECHO arr1
		System.out.print("\narr1: ");
		for (int i=0 ; i<arr1.length; ++i ) // *Note difference between String's length() - NO ()'s
			System.out.print(arr1[i] + " ");
		System.out.println("\n");

		// INITIALIZE arr2 - put some numbers in it

		for (int i=0 ; i<arr2.length; ++i ) // *Note difference between String's length() - NO ()'s
			arr2[i] = i*2;

		// ECHO arr2
		System.out.print("\narr2: ");
		for (int i=0 ; i<arr2.length; ++i ) // *Note difference between String's length() - NO ()'s
			System.out.print(arr2[i] + " ");
		System.out.println("\n");


		// SHALLOW COPY

		arr3 = arr2; // they BOTH POINT TO THE SAME ARRAY!
		for (int i=0 ; i<arr3.length; ++i ) // *Note difference between String's length() - NO ()'s
			arr3[i] = 77;

		// NOW ECHO arr2 again- what happened ? Why ?
		System.out.print("\narr2: ");
		for (int i=0 ; i<arr2.length; ++i ) // *Note difference between String's length() - NO ()'s
			System.out.print(arr2[i] + " ");
		System.out.println("\n");

		// ECHO arr4 - ALL ZEROS - Java initializes to zero until you put something else in.
		System.out.print("\narr4: ");
		for (int i=0 ; i<arr4.length; ++i ) // *Note difference between String's length() - NO ()'s
			System.out.print(arr4[i] + " ");
		System.out.println("\n");


	} //END main
} // EOF