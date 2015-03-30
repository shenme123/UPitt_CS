// WriteFile.java demonstrates use of the PrintWriter to write text files

import java.io.*;
import java.util.*;

public class WriteFile
{
	public static void main( String[] args ) throws Exception // We will learn Exceptions later
	{
		if (args.length < 1 )
		{
			System.out.println("Must put filename on cmd line\n");
			System.exit(0);
		}

		PrintWriter outfile = new PrintWriter( args[0] );

		outfile.println("Hello World"); // Just like println to the screen
		String junk = "Foobar";
		int num = 12345;
		double pi = 3.14159;
		outfile.println(junk + " "  + num + " " + pi );
		outfile.close();  // VERY IMPORTANT. DATA IS NOT FLUSHED TO DEVICE If NOT CLOSED

	} // END MAIN
}