import java.util.*;
import java.io.*;

public class Project6 {

	static HashMap<String, Integer> finalized = new HashMap<String, Integer>();
	static HashMap<String, Integer> temp = new HashMap<String, Integer>();
	static ArrayList<String> path = new ArrayList<String>();
	static String[] cities = null;
	static String[][] dists = null;
	static int num = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
        cities = infile.readLine().split("\t");
		num = cities.length;

		dists = new String[num][];

		int i = 0;
        while (infile.ready()) {
            dists[i] = infile.readLine().split("\t");
			i++;
        }
		infile.close();

		String start = args[1];
		String dest = args[2];

		System.out.println("Finding path from "+start+" to "+dest);

		int startInd = getIndex( args[1] );

		finalized.put( cities[startInd], 0);

		next(startInd);

		if (finalized.containsKey(dest) )
		{
			path.add(dest);
			findPath( dest );
		
			System.out.print(start);
			for (int j=path.size(); j>0; j--)
				System.out.print("->" + path.get(j-1) );
			System.out.println("\tDIST="+finalized.get(dest) );
		}
		else 
			System.out.println("NO PATH");	
    }

	private static void findPath ( String dest ) {
		int dist = finalized.get(dest);
		int destInd = getIndex (dest);
		for (int i=0 ; i<num; i++){
			if (dists[i][destInd].equals("#") || destInd == i )
				continue;
			int distBack = dist - Integer.parseInt( dists[i][destInd] );
			if (distBack == 0)
				return;
			for (String city: finalized.keySet() ){
				if (distBack == finalized.get(city) ){
					path.add(city);
					findPath( city );
					break;
				}
			}
		}
	}

	private static void next(int startInd ) {

		//put cities to temp
		for (int i=0; i<num; i++){
			if ( dists[startInd][i].equals("#") || startInd == i )
				continue;
			int curDist = Integer.parseInt(dists[startInd][i]) + finalized.get(cities[startInd]);
			if ( !finalized.containsKey(cities[i]) ){	
				if ( !temp.containsKey(cities[i]) ){
					temp.put (cities[i], curDist);
				}
				else {
					if ( curDist < temp.get(cities[i]) ){
						temp.put (cities[i], curDist);
					}
				}
			}
		}
		
		//base case
		if ( temp.isEmpty() )
			return; 

		//find next finalized
		int infin = 100000;
		String nextCity = null;
		for (String city: temp.keySet() ){
			if ( temp.get(city) < infin ){
				infin = temp.get(city);
				nextCity = city;
			}
		}
		if ( !(nextCity == null) ){
			finalized.put ( nextCity, temp.get(nextCity) );
			temp.remove (nextCity);
			next ( getIndex(nextCity) );
		}
	}

	private static int getIndex(String city){
		for ( int i=0 ; i<num ; i++ ){
			if ( city.equals(cities[i]) ){
				return i;
			}
		}
		return -1;
	}
}