import java.io.*;
import java.util.*;

public class Program5
{

	public static void main(String args[])
	{
try
{
		// ALL YOUR MAIN CODE GOES HERE

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

