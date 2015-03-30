/*
	F12 cs401 Instructor Tim Hoffman
	FINAL EXAM PROGRAMMING PROBLEM

	YOUR NAME:
	YOUR PITT ID: (i.e. "JFK63", not your pSoft#)
*/


import java.util.*;
import java.io.*;

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader("state2Presidents.txt") );
		BufferedReader infile2 = new BufferedReader( new FileReader("allPresidents.txt") );
		BufferedReader infile3 = new BufferedReader( new FileReader("allStates.txt") );

		// YOUR CODE HERE TO DECLARE MAPS OR SETS TO HOLD THE DATA OF THESE THREE INPUT FILES
		TreeMap<String, TreeSet<String>> stat2pre = new TreeMap<String, TreeSet<String>>();
		TreeMap<String, String> pre2stat = new TreeMap<String, String>();
		TreeSet<String> allPre = new TreeSet<String>();
		TreeSet<String> allStat = new TreeSet<String>();




		// ################# STEP #1 worth 60% or 70% ###################

		// YOUR CODE HERE TO READ infile1 INTO A Map
		while (infile1.ready())
		{
			String[] token1 = infile1.readLine().split(" ");
			TreeSet<String> preSet = new TreeSet<String>(Arrays.asList(token1));
			preSet.remove(token1[0]);
			stat2pre.put(token1[0], preSet);
		}
		infile1.close();
		System.out.println( "The following states had these presidents born in them:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO *PRINT* THE MAP ACCORDING TO THe FORMAT SPECIFIED FOR STEP #1
		// DUMP IT LAZY = 60%  OR  PRINT IT FORMATTED = 70%
		for (String s2p: stat2pre.keySet())
		{
			System.out.print(s2p+" ");
			for (String pre: stat2pre.get(s2p) )
			{
				System.out.print(pre+" ");
			}
			System.out.println();
		}



		// ################# STEP #2 worth 15% ###################

		System.out.println( "\nList of presidents and the state each was born in:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO PRINT THE INVERSION OF THE MAP worth 15%
		for (String s2p: stat2pre.keySet() )
		{
			for (String pre: stat2pre.get(s2p) )
			{
				pre2stat.put(pre, s2p);
			}
		}
		for (String p2s: pre2stat.keySet())
		{
			System.out.println(p2s+" "+pre2stat.get(p2s));
		}


		// ################# STEP #3 worth 10% ###################

		System.out.println( "\nThese presidents were born before the states were formed:\n");  // DO NOT REMOVE OR MODIFY

		// YOUR CODE HERE TO PRINT THE NAME(S) Of ANY PRESIDENT(s)
		//  WHO WERE BORN BEFORE THE STATES WERE FORMED = 10%
		while (infile2.ready())
		{
			allPre.add(infile2.readLine());
		}
		infile2.close();

		for (String pre: allPre)
		{
			if (!pre2stat.containsKey(pre))
			{
				System.out.println(pre);
			}
		}


		// ################# STEP #4 worth 5% ###################

		System.out.println( "\nThese states had no presidents were born in them:\n");

		// YOUR CODE HERE TO PRINT THE NAME(S) OF ANY STATE(s) WHICH HAD NO PRESIDENT BORN IN THEM 5%
		while (infile3.ready())
		{
			allStat.add(infile3.readLine());
		}
		infile3.close();

		for (String stat: allStat )
		{
			if (!stat2pre.containsKey(stat))
			{
				System.out.println(stat);
			}
		}



	} // END MAIN

	//              - - - - - - - - - - -  H E L P E R    M E T H O D S     D O W N    H E R E  - - - - - - - - - -







}	// END POTUS CLASS