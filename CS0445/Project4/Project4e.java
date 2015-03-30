import java.io.*;
import java.util.*;


public class Project4e
{
	static HashSet <String> found = new HashSet <String>();
	
	public static void main (String args[]) throws Exception
	{		
		
		long t1 = System.currentTimeMillis();

		BufferedReader infile = new BufferedReader ( new FileReader ("dictionary.txt") );
		ArrayList <String> dic = new ArrayList<String>();
		ArrayList <String> passed = new ArrayList<String>();

		while (infile.ready())
		{
			String line = infile.readLine();
			if (line.length()>2)
				dic.add(line);
		}
		infile.close();

		infile = new BufferedReader (new FileReader (args[0]) );
		int n = Integer.parseInt(infile.readLine());
		int row = 0;
		String [][] bog = new String [n][];
		while (infile.ready())
		{
			String line = infile.readLine();
			line = line.replace("  ", " ");
			bog[row] = line.split(" ");
			row ++;
		}
		infile.close();

		for ( String s: dic )
		{
			ArrayList<int[]> dropAt = startPoints(s, bog);
			if (!dropAt.isEmpty())
			{
				for (int[] i: dropAt)
				{
					passed.add( i[0]+"+"+i[1] );
					check(s, s.substring(bog[i[0]][i[1]].length(), s.length() ), bog, i, passed);
					passed.remove(i[0]+"+"+i[1]);
				}
			}	
		}
		
		for (String s: found) 
		{
			System.out.println(s);
		}

		long t2 = System.currentTimeMillis();
		System.out.println("Time:" + (t2 - t1));
		System.out.println(found.size());
	}



	public static ArrayList<int[]> startPoints(String s, String[][] bog)
	{
		ArrayList <int[]> points = new ArrayList<int[]>();
		for (int i=0; i<bog.length; i++)
		{
			for (int j=0; j<bog[i].length; j++)
			{
				if (s.startsWith(bog[i][j]))
				{
					int [] temp = new int[2];
					temp[0]=i; temp[1]=j;
					points.add(temp);
				}
			}
		}
		return points;
	}
	

	public static void check (String word, String cutWord, String[][] bog, int[] i, ArrayList<String> passed ) 
	{
		if (cutWord.isEmpty())
		{
			if (!found.contains(word))
				found.add(word); 
			return;
		}
		for (int row = i[0]-1; row <= i[0]+1; row++)
		{
			if (row<0 || row>=bog.length) continue;
			for (int col = i[1]-1; col<=i[1]+1; col++)
			{
				if (col<0 || col>=bog.length || (row == i[0] && col == i[1]) ) continue;
				
				if (passed.contains(row+"+"+col)) continue;
				
				if (cutWord.startsWith(bog[row][col])){
					passed.add(row+"+"+col);
					String cutWord2 = cutWord.substring(bog[row][col].length(), cutWord.length());
					int[] j = new int[2];
					j[0] = row; j[1] = col;
					check ( word, cutWord2 , bog, j, passed);
					passed.remove(passed.size()-1);
				}		
			}
		}
		
	}
}