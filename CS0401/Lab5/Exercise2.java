/*
	Exercise2.java

	- requires you to try/catch recovery from a format mismatch error
*/
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{

		Scanner kbd = new Scanner(System.in);

		Boolean right=false;
		int num=0;
		do
		{
			System.out.print("Enter a number between 1 and 100: ");
		
			try
			{
				num = kbd.nextInt();
				if (num<1 || num>100)
					throw new Exception();
				right = true;
			}
			catch (InputMismatchException e1)
			{
				System.out.println("Input not a number. Try again.");
				System.out.println("\n");
				kbd.next();
			}
			catch (Exception e2)
			{
				System.out.println(e2+": Out of Range Exception.  Must be in 1..100");
				System.out.println("\n");
			}
		}
		while (!right);
		System.out.printf("You entered %d\n", num );

	} //END main
} //EOF