// SOLUTION

import java.util.*;
import java.io.*;

public class RandomSentences
{
	static Random r = new Random(17);

	public static void main(String[] args) throws Exception
	{
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		ArrayList<String> sentence = new ArrayList<String>();

		// STEP #1:
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while (infile.ready() )
		{
			String[] tokens = infile.readLine().split(",");
			String name = tokens[0];
			ArrayList<String> exemplars = new ArrayList<String>( Arrays.asList( tokens[1].split(" ") ) );
			map.put( name, exemplars );
		}
		infile.close();
		System.out.println( "\n20% map print:\n" + map );

		// STEP #2:
		ArrayList<String> cats = new ArrayList<String>( map.keySet() );
		Collections.sort( cats );
		System.out.println( "\n40% map print");
		for (String cat : cats)
		{
			System.out.print( cat + " can be replaced with [ ");
			ArrayList<String> exemplars = new ArrayList<String>( map.get( cat ) );
			Collections.sort( exemplars );
			for ( String exemplar : exemplars )
				System.out.print( exemplar + " " );
			System.out.println( "]");
		}

		// STEP #3:
		infile = new BufferedReader( new FileReader(args[1]) );
		cats = new ArrayList<String>( Arrays.asList( infile.readLine().split(" ") ) );
		System.out.println( "\n60% sentence generation" );
		for (String cat : cats)
		{
			ArrayList<String> exemplars = new ArrayList<String>( map.get( cat ) );
			System.out.print( randomWord(exemplars)  + " " );
		}
		System.out.println();

	} //END MAIN

	// HELPER METHOD

	static String randomWord(ArrayList<String> list)
	{
		return list.get( r.nextInt( list.size() ) );
	}

} //EOF