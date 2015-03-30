import java.util.*;
import java.io.*;

public class ALDemo1
{

	public static void main(String[] args) throws Exception
    {
		 if (args.length < 1 ) die( "CMD LINE INPUT ERROR: pass name of input  file on cmd line." );

		ArrayList<String> wordList= new ArrayList<String>();  // Notice we use default C'TOr  - sets starting capacity to be 10

		BufferedReader infile= new BufferedReader( new FileReader( args[0] ) );
        long startTime = System.currentTimeMillis();
		while ( infile.ready() )
		{
			wordList.add( infile.readLine() ); // ArrayList will resize itself automatically and increment count (size) automatically.
		}
		long endTime = System.currentTimeMillis();
		infile.close();
		long ms = endTime-startTime;
		System.out.println("Elapsed time in ms: " + ms );
		System.out.println("WorldList contains " + wordList.size() + " words");

		// SPECIAL FOR LOOP FOR ARRAYLIST
		if ( wordList.size() < 1000 )
        {
        	for (String w: wordList)
                     System.out.print(w + " ");
        }
        System.out.println();

	} // MAIN

    private static void die( String errmsg )
    {
                System.out.println( "\nFATAL ERROR: " + errmsg + "\n" );
                System.exit(0);
    }

} // ALDEMO1
