import java.io.*;
import java.util.*;


public class Project4b 
{
	public static void main (String args[]) throws Exception
	{		
		
		long t1 = System.currentTimeMillis();

		BufferedReader infile = new BufferedReader ( new FileReader ("dictionary.txt") );
		ArrayList <String> dic = new ArrayList<String>();
		
		while (infile.ready())
		{
			dic.add(infile.readLine());
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
					check(s, bog, i);
				}
			}
			
		}
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

	public static void check (String s, String[][] bog, int[] i) 
	{
		ArrayList<String> pathes = new ArrayList<String>();
		String path = "["+i[0]+","+i[1]+"]";
		pathes.add(path);
		
		for (int a=0; a<pathes.size(); a++)
		{
			go(s, bog, i, pathes, pathes.get(a), 0);
		}

	}

	public static void go( String s, String[][] bog, int[] i, ArrayList<String> pathes, String path, int index)
	{
		if (index >=3 && index == s.length())
		{
			System.out.println(s);
			return;
		}
		if (next(s, bog, i, pathes, path, index))
		{
			if (!path.contains("["+i[0]+","+i[1]+"]") )
			{
				path = path+"["+i[0]+","+i[1]+"]";
			}
			go (s, bog, i, pathes, path, index+(bog[i[0]][i[1]].length()));
		}
	}

	public static boolean next(String s, String[][] bog, int[] i, ArrayList<String> pathes, String path, int index)
	{
		boolean nex = false;
		int count = 0;
		for (int row = i[0]-1; row <= i[0]+1; row++)
		{
			for (int col = i[1]-1; col <= i[1]+1; col++)
			{
				if (row>=0 && col>=0 && row<bog.length && col<bog[row].length && (row!=i[0] || col!=i[1]) )
				{
					if (s.substring(index, s.length()).startsWith(bog[row][col]))
					{
						if (!path.contains("["+row+","+col+"]"))
						{
							nex = true;
							count++;
							if (count>1)
							{
								String pathNew = new String(path);
								pathNew = pathNew + "[" + row + "," + col +"]";
								pathes.add(pathNew);
							}
							else
							{
								i[0]=row;
								i[1]=col;
							}
						}
					}
				}
			}
		}
		count = 0;
		return nex;
	}
}