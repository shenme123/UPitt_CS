import java.io.*;
import java.util.*;

public class Sports
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader infile = new BufferedReader (new FileReader(args[0]));
		ArrayList<String> line_per2spo = new ArrayList<String>();
		HashMap<String, HashSet<String>> per2spo = new HashMap<String, HashSet<String>>();

		while (infile.ready())
		{
			String line = infile.readLine();
			String[] token_p2s = line.split(",");
			HashSet<String> lineSet_p2s = new HashSet<String>(Arrays.asList(token_p2s[1].split(" ")));
			lineSet_p2s.remove(token_p2s[0]);
			per2spo.put(token_p2s[0], lineSet_p2s);
		}
		infile.close();

		infile = new BufferedReader( new FileReader(args[1]));
		while (infile.ready())
		{
			String line = infile.readLine();
			System.out.print(line+": ");
			String[] token_whoP = line.split(",");
			for (String per: per2spo.keySet() )
			{
				if (per2spo.get(per).containsAll(Arrays.asList(token_whoP)))
				{
					System.out.print(per+",");
				}
			}
			System.out.println();
		}
	} // END MAIN

	// ------------------YOUR METHODS HERE -----------------------------

} // END CLASS