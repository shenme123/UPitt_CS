import java.io.*;
import java.util.*;

public class Program4
{
    public static void main(String[] args)
    {
		int myRow=2, myCol=3;  // you are dropped into the swamp at: [2][3]

		int[][] swamp1 =
		{
			{ 0,0,0,0,0,0,0,0,0,0 },
			{ 0,0,0,0,0,0,0,0,0,1 },
			{ 0,0,0,1,0,0,0,0,1,0 },
			{ 0,0,0,1,0,0,0,1,0,0 },
			{ 0,0,0,0,1,0,1,0,0,0 },
			{ 0,0,0,0,1,0,0,1,0,0 },
			{ 0,0,0,0,1,0,0,0,1,0 },
			{ 0,0,0,0,0,1,0,1,0,0 },
			{ 0,0,0,0,0,0,1,0,0,0 },
			{ 0,0,0,0,0,0,0,0,0,0 }
		};

		printSwamp( "SWAMP1",swamp1 );
		printEscapePath( swamp1, myRow,myCol );

		// Now swamp2

		myRow=2; myCol=8;  // you are dropped into the swamp at [2][8]

		int[][] swamp2 =
		{
			{ 0,0,0,0,0,0,0,0,0,0 },
		 	{ 0,0,0,0,0,0,0,0,0,0 },
	 		{ 0,0,1,0,0,0,0,1,1,0 },
		 	{ 0,0,0,1,0,0,1,0,0,0 },
	 		{ 0,0,0,0,1,1,0,0,0,0 },
		 	{ 0,0,0,0,0,0,0,0,0,0 },
	 		{ 0,0,0,0,0,0,0,0,0,0 },
		 	{ 0,0,0,0,0,0,0,0,0,0 },
	 		{ 0,0,0,0,0,0,0,0,0,0 },
		 	{ 0,0,0,0,0,0,0,0,0,0 }
	 	};

		printSwamp( "\nSWAMP2",swamp2 );
		printEscapePath( swamp2, myRow,myCol );

    } // END MAIN

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// 	DO NOT MODIFY THIS METHOD - USE AS GIVEN

    private static void printSwamp(String label, int[][] swamp )
	{
        	System.out.println( label );
	        for(int r = 0; r < swamp.length; r++)
	        {
            	for(int c = 0; c < swamp[r].length; c++)
                 	System.out.print( swamp[r][c] + " ");
            	System.out.println();
        	}
   	}

	// 	DO NOT MODIFY THIS METHOD - USE AS GIVEN

   	private static void printEscapePath(int[][] swamp, int myRow, int myCol)
    {
		int[] coords = new int[2];
		coords[0]=myRow;
		coords[1]=myCol;

		System.out.println("STARTING AT: " + "["+ myRow + "][" + myCol + "]");
		while ( ! onEdge( swamp, coords ) )
		{
			// nextStep returns true only if there is a safe step. If it returns true then before it returns,
			// it marks the spot you are sitting on as -1 then updates  the  x and y inside the coords
			// to be the new coords of where it is stepping to. You must mark your curr position as -1
			// so you don't keep going back and forth

			if ( nextStep( swamp, coords ) )
			{
				System.out.println( "STEPPED  TO: [" + coords[0] + "][" + coords[1] + "]" );
			}
			else // NO PLACE TO MOVE TO ...  YOU'RE CROC MEAT :=(
			{
				System.out.println( "STRANDED AT: [" + coords[0] + "][" + coords[1] + "]" );
						return;
			}
		} // END WHILE NOT OUT OF SWAMP YET

		// IF YOU MAKE IT HERE THEN YOU ARE ON THE EDGE .. FREEDOM!!!

		System.out.println( "ESCAPED  AT: [" + coords[0] + "][" + coords[1] + "]" );

	} // END PRINT ESCAPE PATH


	// ###############################################################


	// 	YOU MUST WRITE THIS METHOD

	// LOOKS AT EVERY ADJACENT SQUARE TO SEE IF IT'S A 1
	// IF IT IS, THEN THE CURRENT X,Y IS CHANGED TO -1 (i.e. BEEN HERE)
	// AND THE COORDS ARE CHANGED TO THOSE OF THE NEARBY SQAURE WITH A 1 IN IT
	// IF NO SAFE STEP IS FOUND THEN JUST RETURN FALSE. DO NOT MODIFY COORDS

	private static boolean nextStep( int[][] swamp, int[] coords )
	{
		// YOUR CODE HERE
		for (int row=coords[0]-1; row<=coords[0]+1; row++)
		{
			for (int col=coords[1]-1; col<=coords[1]+1; col++)
			{

				if ((row!=coords[0]||col!=coords[1]) && swamp[row][col]==1)
				{
					swamp[coords[0]][coords[1]]=-1;
					coords[0]=row;
					coords[1]=col;
					return true;
				}
			}
		}
		return false;  // just to make it compile you edit as needed
	}

	// 	YOU MUST WRITE THIS METHOD

	// RETURNS TRUE IF YOU ARE CURR COORDS ARE ON THE FIRST OR LAST ROW OR COLUMN
	// i.e RETURNS TRUE IF YOU ARE ON THE EDGE/BORDER OF THE SWAMP
	// ELSE RETURNS FALSE

	private static boolean onEdge( int[][] swamp, int[] coords )
	{
		return (coords[0]==0 || coords[0]==swamp.length-1 || coords[1]==0 || coords[1]==swamp[1].length-1);
	}
} // END CLASS PROGRAM4