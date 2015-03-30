import java.io.*;
import java.util.*;

public class HMDemo1
{
	public static void main(String args[]) throws Exception
	{
		HashMap<String,String> states  = new HashMap<String,String>();
		BufferedReader infile = new BufferedReader( new FileReader("StateCapitols.txt") );
        
		String line;
		while  (  (line=infile.readLine()) != null )
		{	
			String[] fields= line.split( " " );
			states.put( fields[0], fields[1] );
		} // Note this ASSUMES two tokens per line
		infile.close();
        
		// the modern way with the new for loop
        
		for (Map.Entry<String,String> entry : states.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("state: " + key + " capitol: " + value );
		}
        
		System.out.println("---------------------------------");
        
		// an even simpler  variation using keySet()
        
		for (String state : states.keySet() )
		{
			String value = states.get( state );
			System.out.println("state: " + state + " capitol: " + value );
		}
        
		System.out.println("---------------------------------");
        
		// you can even grab just the values
        
		for(String capitol  : states.values())
			System.out.println(capitol);
        
    } // MAIN
    
} // CLASS 