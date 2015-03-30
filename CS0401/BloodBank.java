import java.io.*;
import java.util.*;

public class BloodBank
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( args[0] ) );
		TreeMap<String,ArrayList<String>> type2presidents  = new TreeMap<String,ArrayList<String>>();

		while (infile.ready())
		{
			String[] line = infile.readLine().split(",");

			ArrayList<String> names = new ArrayList<String>(Arrays.asList(line));
			names.remove(0);

			type2presidents.put(line[0], names);			
		}
		infile.close();

		HashMap<String, String> presidents2type = new HashMap<String, String>();
		for (String s: type2presidents.keySet())
		{
			System.out.print(s+"\t");
			for (String s1: type2presidents.get(s))
			{
				System.out.print(s1+" ");
				presidents2type.put(s1,s);
			}
			System.out.println();
		}
		System.out.println();

		BufferedReader nameFile = new BufferedReader( new FileReader( args[1]) );
		ArrayList<String> nameList = new ArrayList<String>();

		while (nameFile.ready())
		{
			nameList.add( nameFile.readLine());
		}
		nameFile.close();

		Collections.sort(nameList);

		for ( String s: nameList )
		{
			System.out.println(s+"\t"+presidents2type.get(s));
		}

	} // MAIN
} // BLOODBANK
