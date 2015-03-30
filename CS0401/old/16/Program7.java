import java.io.*;
import java.util.*;

public class Program7
{
	private static BufferedReader pacs=null;
	private static BufferedReader members=null;

	public static void main(String args[])
	{
		try
		{
			pacs = new BufferedReader( new FileReader( args[0] ) ); // pacs.txt
			members = new BufferedReader( new FileReader( args[1] ) ); // members.txt

			// write your code below


		}
		catch (Exception e)
		{
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
			System.exit( 0 );
		}
	} // END MAIN

	// --------------------------------- your methods here ------------------------------------

} // CLASS
