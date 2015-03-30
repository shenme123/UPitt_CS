/*	Program2.java
	YOUR NAME:
	YOUR PITT ID:
*/

import java.io.*;
import java.util.*;

public class Program2
{

    public static void main( String args[] )
    {
		if (args.length<2)
		{
			System.out.printf("\n...You must enter the name of a dictionary file and the jumbles file on cmd line\n");
			System.exit(0);
		}

try // WE WILL LEARN EXCEPTIONS SOON - PUT ALL YOUR MAIN CODE IN HERE 
{
	
	
	BufferedReader dictionaryFile = new BufferedReader( new FileReader(args[0]) ); // if it fails, Exception catch block will trap it 
	BufferedReader jumblesFile = new BufferedReader( new FileReader(args[1]) ); // if it fails, Exception catch block will trap it 
	
	int dWordsFound=0;
	
	// THE  2 WHILE LOOPS BELOWR ARE FOR FILE READING ILLUSTRATION AND INITIAL DEBUGGING ONLY
	// DO NOT ECHO THE WORDS FROM THE FILES IN YOUR FINSIHED PROGRAM
	long time1 = System.currentTimeMillis();

	String dWordList[] = new String[50];

	while ( dictionaryFile.ready() )
	{
		dWordList[dWordsFound] = dictionaryFile.readLine();// grab the whole line because we are assuming the whole line is just one word 
		++dWordsFound;
		if (dWordsFound == dWordList.length)
		{
			dWordList = resize(dWordList);
		}

	}
	dictionaryFile.close();

	String aListS[] = new String [50];
	String aList[] = new String [50];
	int countA = 0;
	String fListS[] = new String [50];
	String fList[] = new String [50];
	int countF = 0;
	String nListS[] = new String [50];
	String nList[] = new String [50];
	int countN = 0;
	for (int index=0; index <dWordsFound; index++)
	{
		char dWord[] = dWordList[index].toCharArray();
		Collections.sort(dWord);
		String dWordS = new String(dWord);
		if(dWordS.charAt(0)<'d' && dWordS.charAt(0)>='a')
		{
			aList[countA] = dWordList[index];
			aListS[countA] = dWordS;
			countA++;
			if(countA == aList.length)
			{
				aList= resize(aList);
				aListS= resize(aListS);
			}
		}
		else if (dWordS.charAt(0)<'h' && dWordS.charAt(0)>='d')
		{
			fList[countF] = dWordList[index];
			fListS[countF] = dWordS;
			countF++;
			if(countF == fList.length)
			{
				fList= resize(fList);
				fListS= resize(fListS);
			}
		}
		else
		{
			nList[countN] = dWordList[index];
			nListS[countN] = dWordS;
			countN++;
			if(countN == nList.length)
			{
				nList= resize(nList);
				nListS= resize(nListS);
			}
		}
	}

	String jWordList[] = new String [50];
	int jWordsFound=0;
	while ( jumblesFile.ready() )
	{
		jWordList[jWordsFound] = jumblesFile.readLine(); // grab the whole line because we are assuming the whole line is just one word 
		jWordsFound++;
		if(jWordsFound==jWordList.length)
			jWordList=resize(jWordList);
	}
	jumblesFile.close();

	String jWordListS [] = new String[jWordsFound];

	for(int i=0; i<jWordsFound; i++)
		jWordListS[i]=jWordList[i];

	Arrays.sort(jWordListS);

	for (int index=0; index<jWordListS.length; index++)
	{
		System.out.print(jWordListS[index]+ ": ");
		char jWord [] = jWordListS[index].toCharArray();
		Arrays.sort(jWord);
		String jWordS = new String(jWord);
		if (jWordS.charAt(0)<'d' && jWordS.charAt(0)>='a')
		{
			String a = new String();
			for (int i=0; i<(countA); i++)
			{
				if(jWordS.length()==aListS[i].length())
				{
					if(jWordS.equals(aListS[i]))
						a=a+aList[i]+" ";		
				}

			}
			String aS[] = a.split(" ");
			Arrays.sort(aS);
			for (String as: aS )
			{
				System.out.print(as+" ");
			}
		}
		else if (jWordS.charAt(0)<'h' && jWordS.charAt(0)>='d')
		{
			String f = new String();
			for (int i=0; i<(countF); i++)
			{
				if(jWordS.length()==fListS[i].length())
				{
					if(jWordS.equals(fListS[i]))
						f=f+fList[i]+" ";	
				}

			}
			String fS[] = f.split(" ");
			Arrays.sort(fS);
			for (String fs: fS )
			{
				System.out.print(fs+" ");
			}
		}
		else
		{
			String n = new String();
			for (int i=0; i<(countN); i++)
			{
				if(jWordS.length()==nListS[i].length())
				{
					if(jWordS.equals(nListS[i]))
						n=n+nList[i]+" ";	
				}

			}
			String nS[] = n.split(" ");
			Arrays.sort(nS);
			for (String ns: nS )
			{
				System.out.print(ns+" ");
			}
		}
		System.out.print("\n");
	}

		long time2 = System.currentTimeMillis();
	long ms = time2-time1;
	//System.out.println("time used:"+ms);

	

}
catch (Exception e)
{
	System.out.println("EXCEPTION DETECTED: " + e );
	System.exit(0);
}

    } // END MAIN

	// =================== Y O U R   M E T H O D S  B E L O W  ======================
	
private static String[] resize( String[] oldArr )
	{
		//allocate a new array opf strings twice the length of oldArr
		String arr[] = new String[oldArr.length*2];
		//copy all the strings from old to new
		for (int i=0; i<oldArr.length; i++)
			arr[i] = oldArr[i];
		//return ref to new
		return arr;
	}	
	


} // END GRAPH CLASS
