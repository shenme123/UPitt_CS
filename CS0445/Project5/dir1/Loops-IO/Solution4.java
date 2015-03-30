/*
	Solution4.java  Nested loops and ifs

	This program prompts the user for a lower bound and an upper bound.  You must put these prompts in
	a loop that repeats until the following is true:
		- both numbers are greater than 0
		- lower is strictly less than the upper

	After the lower and upper are validated write another loop that finds all the prime numbers between
	lower and hupper inclusive.

	A prime number is one which does not divide evenly with any number except 1 and itself.  A brute force
	way to find if a number is prime is to divide it by 2,3,4,5 .. up to number/2 and if none of the remainders
	are 0, you have a prime number. If at any time you get a non-zero remainder, your number is NOT prime.

	You must do the above for every number between lower and upper inclusive and print only those that pass
	the prime test.

	Here is the pseudo code for testing a number for prime:

	divisor = 2
	do
		remainder = number % divisor
		if remainder not 0 then
			increment divisor
	while (divisor <= half the number  AND  remainder is not zero )

	if remainder is still not zero, the number is prime - print it out
*/

import java.io.*;
public class Solution4
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
		int lower, upper;

		// prompt for and validate lower and upper bound
		do
		{
			System.out.print("Enter lower bound (positive number) ");
			lower = Integer.parseInt( kbd.readLine() );

			System.out.print("Enter upper bound (positive number) ");
			upper = Integer.parseInt( kbd.readLine() );
		} while ( upper <= lower && lower > 0);

		// now apply prime test to every number from lower thru upper inclusive

		int number = lower;
		do
		{	int remainder, divisor = 2;
			do
			{
				remainder = number % divisor;
				if (remainder != 0)
					++divisor;
			} while ( (divisor <= number/2) && (remainder != 0) );

			// out of loop. check for last remainder produced
			// if it's non-zero - you found a prime

			if (remainder!=0)
				System.out.println( number + " is prime ");

			++number; // try next number

		} while ( number <= upper );

	} // END main
} //EOF