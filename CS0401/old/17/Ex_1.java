/*
	Ex_1.java

	- requires you to write a try catch to handle a checked exception

		* compile it as is and let the compiler tell you which exception(s) need handled
		* put the exception code in a try block
		* write the handler code in the catch block - your catch should prompt the user for the input file name
		 then re-intitialise the scanner using the new file name.

	    ?? can you rewrite this  without ever declaring a File reference variable
*/

import java.io.*;
import java.util.*;
public class Ex_1
{
	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1)
		{
			System.out.println("\nYou must enter an input filename on cmd line!\n");
			System.exit(0);
		}

		File f = new File( args[0] );
		Scanner infile = new Scanner (f );


		while (infile.hasNext())
		{
			String token = infile.next(); // read a string from infile
			System.out.printf("%3d: %s\n", token);
		}
	}
} //End class