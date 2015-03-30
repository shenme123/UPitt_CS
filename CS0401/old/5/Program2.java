import java.io.*;
import java.util.*;

public class Program2
{

	public static void main(String args[])
	{
try
{
		// ALL YOUR MAIN CODE GOES HERE
		Scanner infile = new scanner (new File(args[0])); // READIN DIC WORDS
		int tokenNum = 0;
		while (infile.hasNext())
		{
			++tokenNum;
		}
		String dic[] = new String[tokenNum];

}
catch (Exception e)
{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
	System.exit( 0 );
}
	} // END MAIN


// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -



} // END CLASS
