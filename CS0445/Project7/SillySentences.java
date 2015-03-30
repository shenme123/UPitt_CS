import java.util.*;
import java.io.*;

public class SillySentences
{
	public static void main(String[] args) throws Exception
	{
		Random r = new Random(17 );

		BufferedReader infile = new BufferedReader( new FileReader( args[0] ) );
		TreeMap<String,ArrayList<String>> tMap = new TreeMap<String,ArrayList<String>>(); // name --> Fred Marie etc.

		// POPULATE THE MAP
		while (infile.ready())
		{
			String[] words = infile.readLine().split(" ");

			ArrayList<String> exs = new ArrayList<String>(Arrays.asList(words));
			exs.remove(0);
			
			Collections.sort(exs);
			tMap.put(words[0], exs);
		}
		infile.close();

		// ECHO THE MAP
		for (String s: tMap.keySet())
		{
			System.out.print(s+": ");
			for (String s1: tMap.get(s))
			{
				System.out.print(s1+" ");
			}
			System.out.println();
		}

		System.out.println();

		BufferedReader sillyS = new BufferedReader( new FileReader( args[1]) );
		while (sillyS.ready())
		{
			String[] wordsS = sillyS.readLine().split(" ");
			for (String s: wordsS)
			{
				int i=tMap.get(s).size();
				System.out.print(tMap.get(s).get(r.nextInt(i))+" ");
			}
			System.out.println();
		}
		sillyS.close();


		
	} // MAIN


} //EOF