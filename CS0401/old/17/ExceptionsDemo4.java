/*
	ExceptionsDemo4.java

	- illustrates Stacking catch blocks
	- Stream objects
*/
import java.io.*;
import java.util.*;

public class ExceptionsDemo4
{
	public static void main( String args[] )
	{

		// we declare our stream outside the try block
		// other wise they become local vars
		// we also have to initialize since possible exception
		// will abort assignment statement and compiler will know the
		// vars might not get initialized, and refuse to compile code

		Scanner infile = null;
		File f = null;

		try
		{
			infile =  new Scanner( new File( "input.txt" ) );
		}
		catch (FileNotFoundException ioe)
		{
			System.out.println("Caught Exception: " + ioe );
		}

		// NOTE THE MULTIPLE CATCH BLOCKS : ONLY 1 CAN EXECUTE
		// THE FIRST EXCPTION DETECTED WILL JUMP TO ITS MATCHING BLOCK.
		// THE EXCEPTION CLASS IS THE GENERAL CASE AND WILL CATCH ANY EXCEPTION
		// THAT DOES NOT HAVE  A SPECIFIC MATCHING BLOCK.
		// ALWAYS PUT THE PLAIN EXCEPTION CASE LAST AS A CATCH ALL.
		// IF YOU PUT IT ANYWHERE ELSE THEN SPECIFIC EXCEPTIONS WILL GO INTO THE
		// GENERAL EXCEPTION BLOCK BEFORE GETTING TO MATCH ON THEIR SPECIFIC CASES.

		System.out.println( "calling foo1()" );
		try
		{
			String token = infile.next();
			System.out.println("1st word of infile was: " + token );
			int num = Integer.parseInt( token );
			System.out.println("the int conversion: " + num );
		}
		catch ( NumberFormatException nfe ) // a specific Exception
		{
			System.out.println("Caught: " + nfe );
		}
		catch (Exception e ) // catch-all  Exception is the most general Exception type
		{
			System.out.println("Caught General Exception:" + e );
		}

		System.out.println("returning from main()");
	} //END main
} //EOF