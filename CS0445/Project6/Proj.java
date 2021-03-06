import java.util.*;
import java.io.*;

public class Proj {
	public static void main(String[] args) throws Exception {
		
		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
        String[] cities = infile.readLine().split("\t");
		int num = cities.length;

		int[][] dists = new int[num][num];

		int i = 0;
        while (infile.ready()) {
			String line = infile.readLine().replaceAll("#", "-1");
            String[] split = line.split("\t");
			for (int j=0; j<num; j++)
				dists[i][j] = Integer.parseInt(split[j]);
			i++;
        }
		infile.close();

		for (int a=0; a<num; a++)
		{
			for (int b=0; b<num; b++)
			{
				System.out.print(dists[a][b]);
			}
			System.out.println();
		}
	}
}