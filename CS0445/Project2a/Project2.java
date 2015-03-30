import java.io.*;
import java.util.*;

public class Project2
{
    public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];

		printSwamp(          "\n   SWAMP: dropped in at: ["+row+","+col+"]\n",swamp );
		System.out.println("\n   ESCAPE PATHS:\n");

		// YOUR CODE HERE. DECLARE WHATEVER OBJECTS AND VARIABLES NEEDED
		// CALL YOUR METHOD(s) TO PRINT ALL ESCAPE PATHS
		printPath(swamp, dropInPt);
	} // END MAIN

	// ###################################################

  	// DO NOT MODIFY THIS METHOD
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
    {
        System.out.println( label );
        System.out.print("   ");
        for(int c = 0; c < swamp.length; c++)
        	System.out.print( c + " " ) ;
        System.out.print( "\n   ");
        for(int c = 0; c < swamp.length; c++)
        	System.out.print("- ");
       System.out.print( "\n");

        for(int r = 0; r < swamp.length; r++)
        {	System.out.print( r + "| ");
            for(int c = 0; c < swamp[r].length; c++)
                 System.out.print( swamp[r][c] + " ");
            System.out.println("|");
        }
        System.out.print( "   ");
        for(int c = 0; c < swamp.length; c++)
        	System.out.print("- ");
       System.out.print( "\n");
    }

	// DO NOT MODIFY THIS METHOD
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
    {
        Scanner infile = new Scanner( new File(infileName) );
        int rows=infile.nextInt();
        int cols = rows;  		// ASSUME A SQUARE GRID
        dropInPt[0]=infile.nextInt();  dropInPt[1]=infile.nextInt();
        int[][] swamp = new int[rows][cols];
        for(int r = 0; r < rows ; r++)
        	for(int c = 0; c < cols; c++)
                 swamp[r][c] = infile.nextInt();

        infile.close();
        return swamp;
    }

	private static void printPath(int[][] swamp, int[] dropInPt)
	{
		int[] point = new int[2];
		point[0]=dropInPt[0];
		point[1]=dropInPt[1];
		ArrayList<String> pathes = new ArrayList<String>();
		String path = "["+ point[0] +","+ point[1] +"]";
		
		pathes.add(path);
		for (String p : pathes)
		{
			go(swamp, point, pathes, path);
		}
	}

	private static void go(int[][] swamp, int[] point, ArrayList<String> pathes, String path)
	{
		if (nextStep(swamp, point, pathes, path))
		{
			if (!path.contains("["+ point[0] +","+ point[1] +"]"))
			{
				path= path+"["+ point[0] +","+ point[1] +"]";
			}
			if (point[0]==0 || point[0]==swamp.length-1 || point[1]==0 || point[1]==swamp[1].length-1)
			{
				System.out.println(path);
			}
			else 
			{
				go(swamp, point, pathes, path);
			}
		}
	}

	private static boolean nextStep(int[][] swamp, int[] point, ArrayList<String> pathes, String path) 
	{
		boolean next = false;
		int count = 0;
		for (int i=point[0]-1; i<=point[0]+1; i++)
		{
			for (int j=point[1]-1; j<point[1]+1; j++)
			{
				if (swamp[i][j]==1)
				{
					next = true;
					count++;
					if (count>1)
					{
						if (!path.contains("["+ point[0] +","+ point[1] +"]"))
						{
							String pathNew = new String(path);
							pathNew = pathNew+"["+ point[0] +","+ point[1] +"]";
							pathes.add(pathNew);
						}		
					}
					else 
					{
						point[0]=i;
						point[1]=j;
					}
				}
			}
		}
		count= 0;
		return next;
	}
}