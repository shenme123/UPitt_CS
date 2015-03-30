/*
	Ex_2.java

	- requires you to try/catch recovery from a format mismatch error
*/
import java.io.*;
import java.util.*;

public class Ex_2
{
	public static void main( String args[] )
	{

		Scanner kbd = new Scanner(System.in);


		System.out.print("Enter a number between 1 and 100 ");
		System.out.printf("You entered %d\n", kbd.nextInt() );

	} //END main
} //EOF