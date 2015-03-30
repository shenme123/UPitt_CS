
/*
  	Program3.java
	YOUR NAME:
	YOUR ID:
*/


import java.io.*;
import java.util.*;


public class Program3
{
	private static final int NOT_FOUND = -1;

    public static void main( String[] args )
    {
try
	{
		int[] arr;

        if (args.length < 1 )
        {
            System.out.println("\n\n      !! You must enter a desired array length on the cmd line !!\n");
            System.exit(0);
        }

        int dimension = Integer.parseInt(args[0]);

		// MUST VALIDATE THAT 10 < DIMENSION < 50.  JUST EXIT IF INVALID

		if (dimension <= 10 || dimension >=50) System.exit(0);  // this will do it :=)

		arr = new int[dimension];

		randomizeArray( arr ); // fill with random ints between 1 .. dimension*10 inclusive
		printArray( "\nRANDOM:", arr );
		bubbleSort( arr );
		printArray( "BUBBLESORTED:", arr );

		randomizeArray( arr );  // fill with random ints between 1 .. dimension inclusive
		printArray( "RANDOM:", arr );
		selectionSort( arr );
		printArray( "SELECTIONSORTED:", arr );


	} // LEAVE THIS HERE - DO NOT MODIFY
	catch (Exception e ) // catch-all  Exception is the most general Exception type
	{
		System.out.println("EXCEPTION DETECTED\n" + e );  // THIS WILL SHOW UP IN YOUR OUTPUT AND I CAN DETECT IT
		System.exit(0);
	}

	} // END MAIN

	// ########################################################################################
// - - - - - - - - -  Y O U  A R E    G I V E N    T H E S E   M E T H O D S.  D O  N O T   M O D I F Y   - - - - - - - - - - -

    // USE THIS METHOD AS GIVEN: DO NOT CHANGE

    private static void printArray( String label, int[] array )
    {
        System.out.println(label);
        for( int i=0 ; i<array.length ;++i )
            System.out.printf("%-3d ",array[i] );
        System.out.println();
    }

    // USE THIS METHOD AS GIVEN: DO NOT CHANGE

	private static void randomizeArray( int[] arr )
	{
		Random r = new  Random(17);
		int i=0;
		while ( i < arr.length  )
		{
			int n = r.nextInt(arr.length*10) + 1;

			// INSERT ONLY IF NUMBER NOT ALREADY IN ARRAY

			if (  linearSearch( arr, n ) == -1  ) arr[i++] = n;
		}
	}


 	// USE THIS METHOD AS GIVEN: DO NOT CHANGE

	private static int linearSearch( int[] arr, int target )
	{
		for ( int i=0 ; i < arr.length ; ++ i )
			if (arr[i] == target ) return i;

		return NOT_FOUND; // i.e. return -1 which is never a valid index - means NOT_FOUND
	}

// - - - - - - - - -  Y O U   W R I T E   T H E S E   M E T H O D S   B E L O W - - - - - - - - - - -

	private static void bubbleSort( int[] arr )
	{
		int last;
		int index;
		int temp;
		for (last = (arr.length-1); last>=0; last--)
		{
			for (index=0; index<last; index++)
			{
				if (arr[index]>arr[index+1])
				{
					temp=arr[index];
					arr[index]=arr[index+1];
					arr[index+1]=temp;
				}
			}
		}
	}

	private static void  selectionSort( int[]  arr )
	{
		int start;
		int index;
		int minIndex;
		int minValue;
		for (start=0; start<(arr.length-1); start++)
		{
			minIndex = start;
			minValue = arr[start];
			for (index = start; index<arr.length; index++)
			{
				if (minValue > arr[index])
				{
					minValue = arr[index];
					minIndex = index;
				}
			}
			arr[minIndex] = arr[start];
			arr[start] = minValue;
		}
	}

} // END Of CLASS PROGRAM2
