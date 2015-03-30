import java.util.*;
import java.io.*;

public class Drugs
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader infile = new BufferedReader (new FileReader("foodDrug2Category.txt"));
		TreeMap <String, TreeSet<String>> f2c = new TreeMap <String, TreeSet<String>> ();
		while (infile.ready())
		{
			String[] token = infile.readLine().split(",");
			TreeSet <String> cata = new TreeSet <String> (Arrays.asList(token));
			cata.remove(token[0]);
			f2c.put(token[0], cata);
		}
		infile.close();
		for (String s: f2c.keySet() )
		{
			System.out.print(s+" ");
			for (String s1: f2c.get(s) )
			{
				System.out.print(s1+" ");
			}
			System.out.println();
		}

		//part2
		infile = new BufferedReader (new FileReader("patient2FoodDrug.txt"));
		TreeMap <String, TreeSet<String>> p2f = new TreeMap <String, TreeSet<String>> ();
		while (infile.ready())
		{
			String[] token2 = infile.readLine().split(",");
			TreeSet <String> foods = new TreeSet<String> (Arrays.asList(token2));
			foods.remove(token2[0]);
			p2f.put (token2[0], foods);
		}
		infile.close();
		for (String s: p2f.keySet() )
		{
			System.out.print(s+" ");
			for (String s1: p2f.get(s) )
			{
				System.out.print(s1+" ");
			}
			System.out.println();
		}
		System.out.println();

		//Part3
		infile = new BufferedReader (new FileReader("dontMix.txt"));
		while (infile.ready())
		{
			String[] token3 = infile.readLine().split(",");
			TreeSet <String> dontMix = new TreeSet <String> (Arrays.asList(token3));
			for (String s: p2f.keySet() )
			{
				TreeSet <String> personCata = new TreeSet <String>();
				for (String s1: p2f.get(s))
				{
					for (String s2: f2c.keySet())
					{
						if (f2c.get(s2).contains(s1))
						{
							personCata.add(s2);
						}
					}
				}
				if (personCata.containsAll(Arrays.asList(token3)))
				{
					System.out.println(s);
				}
			}
		}
		infile.close();
	}		
}