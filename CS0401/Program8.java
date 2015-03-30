/*	Program2.java
	YOUR NAME:
	YOUR PITT ID:
*/

import java.io.*;
import java.util.*;

public class Program8
{

    public static void main( String args[] )
    {
		long t1 = System.currentTimeMillis();
		if (args.length<2)
		{
			System.out.printf("\n...You must enter the name of a dictionary file and the jumbles file on cmd line\n");
			System.exit(0);
		}

try // WE WILL LEARN EXCEPTIONS SOON - PUT ALL YOUR MAIN CODE IN HERE 
{
	
	
	BufferedReader dictionaryFile = new BufferedReader( new FileReader(args[0]) ); // if it fails, Exception catch block will trap it 
	BufferedReader jumblesFile = new BufferedReader( new FileReader(args[1]) ); // if it fails, Exception catch block will trap it 
	
	int dWordsFound=0;

	ArrayList<String> dWord = new ArrayList<String>();
	ArrayList<String> jWord = new ArrayList<String>();
	
	// THE  2 WHILE LOOPS BELOWR ARE FOR FILE READING ILLUSTRATION AND INITIAL DEBUGGING ONLY
	// DO NOT ECHO THE WORDS FROM THE FILES IN YOUR FINSIHED PROGRAM
	
	while ( dictionaryFile.ready() )
	{
		dWord.add(dictionaryFile.readLine());  // grab the whole line because we are assuming the whole line is just one word 	
	}
	dictionaryFile.close();
	Collections.sort(dWord);

	while ( jumblesFile.ready() )
	{
		jWord.add( jumblesFile.readLine());  // grab the whole line because we are assuming the whole line is just one word 
	}
	Collections.sort(jWord);
	jumblesFile.close();

	HashMap<String, String> dMap = new HashMap<String, String>();
	for (String d: dWord )
	{
		char[] dCharArr=d.toCharArray();
		Arrays.sort(dCharArr);
		String dSorted = new String(dCharArr);
		String dWords = dMap.containsKey(dSorted)? dMap.get(dSorted)+" "+d:d;
		dMap.put(dSorted, dWords);
	}

	for (String j: jWord)
	{
		char[] jCharArr=j.toCharArray();
		Arrays.sort(jCharArr);
		String jSorted = new String(jCharArr);
		System.out.print(j+": ");
		if (dMap.containsKey(jSorted))
		{
			System.out.println(dMap.get(jSorted));
		}
		else
		{
			System.out.println();
		}
	}
	long t2 = System.currentTimeMillis();
	long t=t2-t1;
	System.out.println(t);
}
catch (Exception e)
{
	System.out.println("EXCEPTION DETECTED: " + e );
	System.exit(0);
}

    } // END MAIN

	// =================== Y O U R   M E T H O D S  B E L O W  ======================
	
	
	


} // END GRAPH CLASS
