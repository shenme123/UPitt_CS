/*	Program2.java
	YOUR NAME: Wentao jiang
	YOUR PITT ID: wej10
*/

import java.io.*;
import java.util.*;

public class Program2a
{

    public static void main( String args[] )
    {
		if (args.length<2)
		{
			System.out.printf("\n...You must enter the name of a dictionary file and the jumbles file on cmd line\n");
			System.exit(0);
		}

try // WE WILL LEARN EXCEPTIONS SOON - PUT ALL YOUR MAIN CODE IN HERE 
{
	
	
	BufferedReader dictionaryFile = new BufferedReader( new FileReader(args[0]) ); // if it fails, Exception catch block will trap it 
	BufferedReader jumblesFile = new BufferedReader( new FileReader(args[1]) ); // if it fails, Exception catch block will trap it 
	
	
	// THE  2 WHILE LOOPS BELOWR ARE FOR FILE READING ILLUSTRATION AND INITIAL DEBUGGING ONLY
	// DO NOT ECHO THE WORDS FROM THE FILES IN YOUR FINSIHED PROGRAM
	ArrayList<String> dWordList = new ArrayList<String>();
	ArrayList<String> jWordList = new ArrayList<String>();

	while ( dictionaryFile.ready() )
	{
		dWordList.add(dictionaryFile.readLine());  // grab the whole line because we are assuming the whole line is just one word 
	}
	dictionaryFile.close();

	while ( jumblesFile.ready() )
	{
		jWordList.add(jumblesFile.readLine());   // grab the whole line because we are assuming the whole line is just one word 
	}
	jumblesFile.close();
	
	long startTime = System.currentTimeMillis();
	for (String j: jWordList)
		{
			System.out.print(j+":");
			char jWord[] = j.toCharArray();
			Arrays.sort(jWord);
			String jWordSorted = new String (jWord);
			for (String d: dWordList)
			{
				char dWord[] = d.toCharArray();
				Arrays.sort(dWord);
				String dWordSorted = new String (dWord);
				if (jWordSorted.length() == dWordSorted.length() )
				{
					if (jWordSorted.equals(dWordSorted))
						System.out.print(d);
				}
			}
			System.out.print("\n");
		}

	long endTime = System.currentTimeMillis();
	long ms = endTime-startTime;
	System.out.println("Eclipsd time in ms:" + ms);
}
catch (Exception e)
{
	System.out.println("EXCEPTION DETECTED: " + e );
	System.exit(0);
}

    } // END MAIN

	// =================== Y O U R   M E T H O D S  B E L O W  ======================


	
	


} // END GRAPH CLASS
