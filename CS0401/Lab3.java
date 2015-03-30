// Lab3
// YOUR NAME: Wentao Jiang
// YOUR PITT ID: WEJ10


import java.io.*;
import java.util.*;


public class Lab3
{
	public static void main (String args[])
	{

		String infileName=null,outfileName=null;
		BufferedReader infile=null;
		PrintWriter outfile=null;
		int capacity = 50;
		int count=0;
		int lenOfLongest=0,lenOfShortest= 2147483647; // lengths of longest/shortest words stored in the array
		String wordList[] = new String[50];
try
{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED ARGS ON THE COMMAND LINE
		if (args.length < 2 )
		{
			System.out.println("CMD LINE INPUT ERROR: Must enter two filenames on cmd line: (i.e. java Lab3  dictionary.txt  report.txt)\n");
			System.exit(0);
		}

		// now its safe to copy the two cmd args into the filenames

		infileName = args[0];
		outfileName = args[1];

		// - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - -
		// . . . . . . . . . . . . . . . . . . .. .YOUR CODE BELOW  . . . . . . . . . . . . . . . . .
		
		// Open the input file and read all the Strings into the wordList.
		// Always check for the array getting full so you  can resize it any time it fills up.
		// Also track the lengths of the longelst and shortest Strings found as well as total


		infile = new BufferedReader( new FileReader(infileName) );
		while (infile.ready())  // i.e while there is another line in the file
		{
			// READ A LINE INTO A STRING
			String temp = infile.readLine();
			// UPDATE  SHORTEST/LONGEST
			if (temp.length() > lenOfLongest)
				lenOfLongest = temp.length();
			if (temp.length() < lenOfShortest)
				lenOfShortest = temp.length();
			// CHECK TO SEE IF WORDLIST ARRAY NEEDS RESIZED ( is count == .length yet? )
			// IF SO CALL YOUR RESIZE METHOD AND ASSIGN ITS RETURN VALUE INTO WORDLIST
			if (count == capacity)
			{
				capacity *= 2;
				wordList = resize(wordList);
			}

			// NOW SAFE COPY STRING INTO WORLDLIST (update count)
			wordList[count] = temp;
			count++;
		}
		infile.close();

		// Open the output file and write a report of the shortest and longest lengths,
		// total count of words and final length of the wordList

		outfile = new PrintWriter( outfileName );
		outfile.println("length of longest String: " + lenOfLongest );
		outfile.println("length of shortest String: " + lenOfShortest );
		outfile.println("total number of Strings read/stored: " + count );
		outfile.println("final length (capacity) of wordList: " + wordList.length );
		outfile.close();

		// . . . . . . . . . . . . . . . . . . . . . . . . . . NO CODE BELOW HERE . . . . . . . . . . . . . . . . . .

}
catch ( Exception e)
{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
	System.exit( 0 );
}

	} // END MAIN


	// ....................................................... RESIZE METHOD ...............................................
	// This method returns a ref to newly dimension array that is twice the length of old
	// The returned array has all the old String refs copied into it

	private static String[] resize( String[] oldArr )
	{
		//allocate a new array opf strings twice the length of oldArr
		String arr[] = new String[oldArr.length*2];
		//copy all the strings from old to new
		for (int i=0; i<oldArr.length; i++)
			arr[i] = oldArr[i];
		//return ref to new
		return arr;
	}
} // END CLASS LAB2
