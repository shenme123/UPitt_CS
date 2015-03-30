// Speeder
// your name:
// your andrew ID:


import java.io.*;
import java.util.*;


public class Lab1
{
	public static void main (String args[])
	{

		// Create a scanner to read from keyboard
		Scanner kbd = new Scanner (System.in);

		final int RATE1 = 30; 
		final int RATE2 = 50; 
		final int UNDERAGE = 300;

		System.out.print("Enter Last Name:");
		String lastName = kbd.next();

		System.out.print("Enter First Name:");
		String firstName = kbd.next();

		System.out.print("Enter Driver Age:");
		int age = kbd.nextInt();

		System.out.print("Enter Speed Limit:");
		int speedLimit = kbd.nextInt();

		System.out.print("Enter Actural Speed:");
		int acturalSpeed = kbd.nextInt();

		System.out.print("Was It A Construction Zone? (true/false):");
		Boolean constr = kbd.nextBoolean();

		int overSpeed = acturalSpeed > speedLimit? (acturalSpeed - speedLimit) : 0;

		int baseFine = overSpeed > 20? (overSpeed/5*RATE2):(overSpeed/5*RATE1);

		int constrFine = 0;
		int underageFine = 0;

		if(overSpeed >= 5){
			constrFine = constr? baseFine:0;
			underageFine = age < 21? UNDERAGE : 0;
		}

		int totalFine = baseFine + constrFine + underageFine;

		System.out.println("Last Name:" + lastName + "\nFirst Name:" + firstName + "\nDriver Age:" + age + 
			"\nSpeed Limit:" + speedLimit + "\nActrual Speed:" + acturalSpeed + "\nMPG over limit:" + overSpeed
			+ "\nBase Fine: $" + baseFine + "\nConstruction Zone Fine: $" + constrFine + "\nUnderage Fine: $" + underageFine
			+ "\nTotal Fine: $" + totalFine);

	}
} // END class Speeder