/*
	Program3.java  THE SWAMP

*/

import java.io.*;
import java.util.*;

public class Program3
{
    public static void main(String[] args)
    {

try
{
	// PROCESS SWAMP 1  45% of the grade

	Scanner infile = new Scanner( new File(args[0]) ); // // on cmd line will be swamp1.txt
		// 1st line (header) of swamp file is DIMENSION of swamp then startRow, startCol where you are dropped into the swamp.
	int dimension=infile.nextInt(),
		 startRow=infile.nextInt(),
		 startCol=infile.nextInt();
	int[][] swamp1 = new int[dimension][dimension];
	loadSwamp( swamp1, infile ); // read in the swamp grid using a nested for loop
	infile.close();

	printSwamp( "SWAMP1",swamp1 );
	printEscapePath( swamp1, startRow,startCol);


	// NOW SWAMP 2   45% of the grade

	infile = new Scanner( new File(args[1]) ); // on cmd line will be swamp2.txt
	// 1st line (header) of swamp file is DIMENSION of swamp then startRow, startCol where you are dropped into the swamp.
	dimension=infile.nextInt();
	startRow=infile.nextInt();
	startCol=infile.nextInt();
	int[][] swamp2 = new int[dimension][dimension];
	loadSwamp( swamp2, infile ); // read in the swamp grid using a nested for loop
	infile.close();

	printSwamp( "SWAMP2",swamp2 );
	printEscapePath( swamp2, startRow,startCol);


/* OPTIONAL FOR THE LAST 10% - DO NOT HAND IN ( i.e. DO NOT UNCOMMENT) UNTIL YOU ARE SURE THE FIRST 2 ARE CORRECT

	// NOW SWAMP 3  (the hard one!)

	Scanner infile = new Scanner( new File(args[2]) ); // on cmd line will be swamp3.txt
	// 1st line (header) of swamp file is DIMENSION of swamp then startRow, startCol where you are dropped into the swamp.
	dimension=infile.nextInt();
	startRow=infile.nextInt();
	startCol=infile.nextInt();
	int[][] swamp3 = new int[dimension][dimension];
	loadSwamp( swamp3, infile ); // read in the swamp grid using a nested for loop
	infile.close();

	printSwamp( "SWAMP3",swamp3 );
	printEscapePath( swamp3, startRow,startCol);
*/




}
catch( Exception e)
{
	StringWriter sw = new StringWriter();
	e.printStackTrace(new PrintWriter(sw));
	System.out.println("EXCEPTION CAUGHT: " + sw.toString() );
	System.exit( 0 );
}

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

private static void printEscapePath(int[][] swamp, int myX, int myY)
{

	int[] coords = new int[2];
	coords[0]=myX;
	coords[1]=myY;

	System.out.println("STARTING AT: " + "["+ myX + "][" + myY + "]");
	while ( ! onEdge( swamp, coords ) )
	{
		// nextStep returns true if there IS a safe step,  else returns false
		// If it returns true then before it returns, it marks the spot you are sitting on as -1
		// then updates  the  x and y inside the coords to be the new coords of where it is stepping to.
		// You must mark your curr position as -1 so you don't keep going back and forth

		if ( nextStep( swamp, coords ) )
		{
			System.out.println( "STEPPED  TO: [" + coords[0] + "][" + coords[1] + "]" );
		}
		else // YOU'RE CROC MEAT :=(
		{
			System.out.println( "STRANDED AT: [" + coords[0] + "][" + coords[1] + "]" );
			return;
		}
	} // END NOT TO THE EDGE YET

	// IF YOU MAKE IT HERE THEN YOU ARE ON THE EDGE .. FREEDOM!!!

	System.out.println( "ESCAPED  AT: [" + coords[0] + "][" + coords[1] + "]" );

} // END PRINT ESCAPE PATH


// ###############################################################

	// 	YOU MUST WRITE THIS METHOD

	// LOOKS AT EVERY ADJACENT SQUARE TO SEE IF IT'S A 1
	// IF IT IS, THEN THE CURRENT X,Y IS CHANGED TO -1 (i.e. BEEN HERE)
	// AND THE COORDS ARE CHANGED TO THOSE OF THE NEARBY SQAURE WITH A 1 IN IT
	// IF NO SAFE STEP IS FOUND THEN JUST RETURN FALSE w/out MODIFYING COORDS

	private static boolean nextStep( int[][] swamp, int[] coords )
	{
		// YOUR CODE HERE

		return false;  // just to make it compile you edit as needed
	}

	// 	YOU MUST WRITE THIS METHOD

	// RETURNS TRUE IF YOU ARE CURR COORDS ARE ON THE FIRST OR LAST ROW OR COLUMN
	// i.e RETURNS TRUE IF YOU ARE ON THE EDGE/BORDER OF THE SWAMP
	// ELSE RETURNS FALSE

	private static boolean onEdge( int[][] swamp, int[] coords )
	{
		return false;  // just to make it compile you edit as needed
	}


	// 	YOU MUST WRITE THIS METHOD

	private static void loadSwamp( int[][] swamp, Scanner infile ) //
	{
		/* your nested for loop to read in the 10 rows of 1 or 0 from the samp file using infile.nextInt()
		  HINT : Look at printSwamp loops
	   */
	}


}
