import java.util.*;
import java.io.*;

public class Lab8
{
	public static void main (String args[]) throws Exception {
		BufferedReader infile = new BufferedReader ( new FileReader (args[0]) );
		TreeMap<String, ArrayList<String>> t2p = new TreeMap<String, ArrayList<String>>();
		while (infile.ready()){
			String[] tokens = infile.readLine().split(",");
			ArrayList<String> names = new ArrayList<String>( Arrays.asList(tokens) );
			names.remove(0);
			t2p.put(tokens[0], names);
		}
		infile.close();

		TreeMap<String, String> p2t = new TreeMap<String, String>();
		for ( String type : t2p.keySet() ){
			System.out.print(type + "\t");
			for ( String name : t2p.get(type) ) {
				System.out.print(name + " ");
				p2t.put (name, type);
			}
			System.out.println();
		}

		for (String name: p2t.keySet() ){
			System.out.println( name + "\t" + p2t.get(name) );
		}
	}
}