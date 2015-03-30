import java.io.*;
import java.util.*;

public class LinkedListIter
{
	public static void main(String args[])  throws Exception
	{
		// FILL AN LinkedList WITH STRINGS, PRINT PURGE EVEN LENGTH STRINGS AND PRINT

		BufferedReader infile1 = new BufferedReader( new FileReader( args[0] ) ); 
		LinkedList<String> words= new LinkedList<String>();
		loadWordList( words,infile1 );
		printWordList( words, "\nOriginal List\n");
		purgeWordList( words );
		printWordList( words, "\nPurged List\n" );
		infile1.close(); 
	

		// FILL AN LinkedList WITH INTEGER, PRINT PURGE EVEN NUMBERS AND PRINT

		Scanner infile2 = new Scanner( new FileReader( args[1] ) );  
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		loadNumList( numbers, infile2 );
		printNumList( numbers, "\nOriginal List\n");
		purgeNumList( numbers );
		printNumList( numbers, "\nPurged List\n" );
		infile2.close(); 

	}

	// YOUR LOAD PRINT AND PURGE METHODS HERE

	private static void loadWordList( LinkedList<String> list, BufferedReader infile ) throws Exception
	{
		while ( infile.ready() ) list.add( infile.readLine() );
	}

	private static void printWordList( LinkedList<String> list, String caption )
	{
		System.out.println( caption );
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.println( iter.next() );
	}

	private static void purgeWordList( LinkedList<String> list )
	{
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
		{
			String s = iter.next();
			if (s.length() % 2 == 0 )
				iter.remove();
		}
	}

	private static void loadNumList( LinkedList<Integer> list, Scanner infile )
	{
		while ( infile.hasNextInt() ) list.add( infile.nextInt() );
	}

	private static void printNumList( LinkedList<Integer> list, String caption)
	{
		System.out.println( caption );
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext())
			System.out.println( iter.next() );
	}

	private static void purgeNumList( LinkedList<Integer> list )
	{
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext())
		{
			int i = iter.next();
			if (i%2 == 0 )
				iter.remove();
		}
	}
}



