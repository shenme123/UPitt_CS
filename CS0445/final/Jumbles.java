import java.io.*;
import java.util.*;

public class Jumbles
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader dictFile = new BufferedReader(new FileReader( "dictionary.txt" ) );     // leave this  as given
		BufferedReader jumblesFile = new BufferedReader(new FileReader( "jumbles.txt" ) );  // leave this  as given
		//Tree/HashMap<String,String> dictMap = new Tree/HashMap<String,String>();
		
		TreeMap<String, String> dictMap = new TreeMap<String,String>();

		/*
		With each dWord from the dictionary make a sorted (canonical) copy sWord
		if map does not contain sWord the put <sWord,dWord>
		if already contains key sWord then put <sWord, value + " " + dWord>
		close dictFile


		With each jWord from jumbles file make a sorted (canonical) copy sWord
		if map contains key sWord then print jWord followed by value stored in map with sWord
		close jumblesFile

		*/
		ArrayList<String> dic = new ArrayList<String>();

		while ( dictFile.ready() )
		{
			String word = dictFile.readLine();
			dic.add(word);
		}
		dictFile.close();
		Collections.sort(dic);

		for (String s:  dic )
		{
			String sorted = toCanonical (s);
			if ( dictMap.containsKey( sorted ) )
			{
				dictMap.put( sorted, dictMap.get(sorted)+" "+(s) );
			}
			else {
				dictMap.put (sorted, s);
			}
		}

		TreeSet<String> jumbles = new TreeSet<String>();
		while ( jumblesFile.ready() )
		{
			jumbles.add(jumblesFile.readLine() );
		}
		jumblesFile.close();

		for (String j: jumbles )
		{
			String sortedj = toCanonical (j);
			System.out.print( j + ": ");
			if ( dictMap.containsKey(sortedj) )
			{
				System.out.print( dictMap.get(sortedj) );
			}
			System.out.println();
		}
			
	} // END MAIN

	// you should use this to make a sorted copy of a word
	static String toCanonical( String word )
	{
		char[] letters = word.toCharArray();
		Arrays.sort( letters );
		return new String( letters );
	}

} // END JUMBLES CLASS
