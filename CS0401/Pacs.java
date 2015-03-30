import java.io.*;
import java.util.*;

public class Pacs
{
	public static void main( String args[] )  throws Exception
	{
		BufferedReader pacsF = new BufferedReader( new FileReader(args[1]) );
		ArrayList<String> pacs = new ArrayList<String>();
		while (pacsF.ready())
		{
			pacs.add(pacsF.readLine());
		}
		pacsF.close();
		Collections.sort(pacs);


		BufferedReader membersF = new BufferedReader( new FileReader(args[0]) );
		HashMap<String, ArrayList<String>> pacs2names = new HashMap<String, ArrayList<String>>();
		while (membersF.ready())
		{
			String[] line = membersF.readLine().split(" ");
			for (int i=1; i<line.length; i++)
			{
				if (pacs2names.containsKey(line[i]))
				{
					pacs2names.get(line[i]).add(line[0]);
				}
				else 
				{
					ArrayList<String> names = new ArrayList<String>();
					names.add(line[0]);
					pacs2names.put(line[i], names);
				}
			}
		}
		membersF.close();

		for (String s: pacs2names.keySet())
		{
			Collections.sort(pacs2names.get(s));
		}

		for (String s: pacs )
		{
			System.out.print(s+" ");
			if (pacs2names.get(s)!=null)
			{
				for (String s1:pacs2names.get(s))
				{
					System.out.print(s1+" ");
				}
			}
			System.out.println();
		}
	} // END MAIN

} // CLASS
