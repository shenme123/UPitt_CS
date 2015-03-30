/*	Program2.java
	YOUR NAME: Wentao jiang
	YOUR PITT ID: wej10
*/

import java.io.*;
import java.util.*;

public class Program2b
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
	
	
	// THE  2 WHILE LOOPS BELOWR ARE FOR FILE READING ILLUSTRATION AND INITIAL DEBUGGING ONLY
	// DO NOT ECHO THE WORDS FROM THE FILES IN YOUR FINSIHED PROGRAM
	ArrayList<String> dWordList = new ArrayList<String>();
	ArrayList<String> jWordList = new ArrayList<String>();

	while ( dictionaryFile.ready() )
	{
		dWordList.add(dictionaryFile.readLine());  // grab the whole line because we are assuming the whole line is just one word 
	}
	dictionaryFile.close();

	while ( jumblesFile.ready() )
	{
		jWordList.add(jumblesFile.readLine());   // grab the whole line because we are assuming the whole line is just one word 
	}
	jumblesFile.close();
	
	long startTime = System.currentTimeMillis();

	ArrayList<String> dWordListA = new ArrayList<String>();
	ArrayList<String> dWordListB = new ArrayList<String>();
	ArrayList<String> dWordListC = new ArrayList<String>();
	ArrayList<String> dWordListD = new ArrayList<String>();
	ArrayList<String> dWordListE = new ArrayList<String>();
	ArrayList<String> dWordListF = new ArrayList<String>();
	ArrayList<String> dWordListG = new ArrayList<String>();
	ArrayList<String> dWordListH = new ArrayList<String>();
	ArrayList<String> dWordListI = new ArrayList<String>();
	ArrayList<String> dWordListJ = new ArrayList<String>();
	ArrayList<String> dWordListK = new ArrayList<String>();
	ArrayList<String> dWordListL = new ArrayList<String>();
	ArrayList<String> dWordListM = new ArrayList<String>();
	ArrayList<String> dWordListN = new ArrayList<String>();
	ArrayList<String> dWordListO = new ArrayList<String>();
	ArrayList<String> dWordListP = new ArrayList<String>();
	ArrayList<String> dWordListQ = new ArrayList<String>();
	ArrayList<String> dWordListR = new ArrayList<String>();
	ArrayList<String> dWordListS = new ArrayList<String>();
	ArrayList<String> dWordListT = new ArrayList<String>();
	ArrayList<String> dWordListU = new ArrayList<String>();
	ArrayList<String> dWordListV = new ArrayList<String>();
	ArrayList<String> dWordListW = new ArrayList<String>();
	ArrayList<String> dWordListX = new ArrayList<String>();
	ArrayList<String> dWordListY = new ArrayList<String>();
	ArrayList<String> dWordListZ = new ArrayList<String>();

	for (String d: dWordList)
	{
		char dWord [] = d.toCharArray();
		Arrays.sort(dWord);
		String dWordSorted = new String (dWord);
		switch(dWordSorted.charAt(0)) 
		{
			case 'a':
				dWordListA.add(dWordSorted);
				break;
			case 'b':
				dWordListB.add(dWordSorted);
				break;
			case 'c':
				dWordListC.add(dWordSorted);
				break;
			case 'd':
				dWordListD.add(dWordSorted);
				break;
			case 'e':
				dWordListE.add(dWordSorted);
				break;
			case 'f':
				dWordListF.add(dWordSorted);
				break;
			case 'g':
				dWordListG.add(dWordSorted);
				break;
			case 'h':
				dWordListH.add(dWordSorted);
				break;
			case 'i':
				dWordListI.add(dWordSorted);
				break;
			case 'j':
				dWordListJ.add(dWordSorted);
				break;
			case 'k':
				dWordListK.add(dWordSorted);
				break;
			case 'l':
				dWordListL.add(dWordSorted);
				break;
			case 'm':
				dWordListM.add(dWordSorted);
				break;
			case 'n':
				dWordListN.add(dWordSorted);
				break;
			case 'o':
				dWordListO.add(dWordSorted);
				break;
			case 'p':
				dWordListP.add(dWordSorted);
				break;
			case 'q':
				dWordListQ.add(dWordSorted);
				break;
			case 'r':
				dWordListR.add(dWordSorted);
				break;
			case 's':
				dWordListS.add(dWordSorted);
				break;
			case 't':
				dWordListT.add(dWordSorted);
				break;
			case 'u':
				dWordListU.add(dWordSorted);
				break;
			case 'v':
				dWordListV.add(dWordSorted);
				break;
			case 'w':
				dWordListW.add(dWordSorted);
				break;
			case 'x':
				dWordListX.add(dWordSorted);
				break;
			case 'y':
				dWordListY.add(dWordSorted);
				break;
			case 'z':
				dWordListZ.add(dWordSorted);
				break;
		}
	}
	for (String j:jWordList)
	{
		System.out.print(j+": ");
		char jWord [] = j.toCharArray();
		Arrays.sort(jWord);
		String jWordSorted = new String (jWord);
		switch(jWordSorted.charAt(0)) 
		{
			case 'a':
			{
				for (String a: dWordListA )
					{
						if(a.length() == jWordSorted.length())
						{
							if(a.equals(jWordSorted))
								System.out.print(a+" ");
						}
					}
					break;
			}
			case 'b':
			{
				for (String b: dWordListB )
					{
						if(b.length() == jWordSorted.length())
						{
							if(b.equals(jWordSorted))
								System.out.print(b+" ");
						}
					}
					break;
			}
			case 'c':
			{
				for (String c: dWordListC )
					{
						if(c.length() == jWordSorted.length())
						{
							if(c.equals(jWordSorted))
								System.out.print(c+" ");
						}
					}
					break;
			}
			case 'd':
			{
				for (String d: dWordListD )
					{
						if(d.length() == jWordSorted.length())
						{
							if(d.equals(jWordSorted))
								System.out.print(d+" ");
						}
					}
					break;
			}
			case 'e':
			{
				for (String e: dWordListE )
					{
						if(e.length() == jWordSorted.length())
						{
							if(e.equals(jWordSorted))
								System.out.print(e+" ");
						}
					}
					break;
			}
			case 'f':
			{
				for (String f: dWordListF )
					{
						if(f.length() == jWordSorted.length())
						{
							if(f.equals(jWordSorted))
								System.out.print(f+" ");
						}
					}
					break;
			}
			case 'g':
			{
				for (String g: dWordListG )
					{
						if(g.length() == jWordSorted.length())
						{
							if(g.equals(jWordSorted))
								System.out.print(g+" ");
						}
					}
					break;
			}
			case 'h':
			{
				for (String h: dWordListH )
					{
						if(h.length() == jWordSorted.length())
						{
							if(h.equals(jWordSorted))
								System.out.print(h+" ");
						}
					}
					break;
			}
			case 'i':
			{
				for (String i: dWordListA )
					{
						if(i.length() == jWordSorted.length())
						{
							if(i.equals(jWordSorted))
								System.out.print(i+" ");
						}
					}
					break;
			}
			case 'j':
			{
				for (String jj: dWordListJ )
					{
						if(jj.length() == jWordSorted.length())
						{
							if(jj.equals(jWordSorted))
								System.out.print(jj+" ");
						}
					}
					break;
			}
			case 'k':
			{
				for (String k: dWordListK )
					{
						if(k.length() == jWordSorted.length())
						{
							if(k.equals(jWordSorted))
								System.out.print(k+" ");
						}
					}
					break;
			}
			case 'l':
			{
				for (String l: dWordListL )
					{
						if(l.length() == jWordSorted.length())
						{
							if(l.equals(jWordSorted))
								System.out.print(l+" ");
						}
					}
					break;
			}
			case 'm':
			{
				for (String m: dWordListM )
					{
						if(m.length() == jWordSorted.length())
						{
							if(m.equals(jWordSorted))
								System.out.print(m+" ");
						}
					}
					break;
			}
			case 'n':
			{
				for (String n: dWordListN )
					{
						if(n.length() == jWordSorted.length())
						{
							if(n.equals(jWordSorted))
								System.out.print(n+" ");
						}
					}
					break;
			}
			case 'o':
			{
				for (String o: dWordListO )
					{
						if(o.length() == jWordSorted.length())
						{
							if(o.equals(jWordSorted))
								System.out.print(o+" ");
						}
					}
					break;
			}
			case 'p':
			{
				for (String p: dWordListP )
					{
						if(p.length() == jWordSorted.length())
						{
							if(p.equals(jWordSorted))
								System.out.print(p+" ");
						}
					}
					break;
			}
			case 'q':
			{
				for (String q: dWordListQ )
					{
						if(q.length() == jWordSorted.length())
						{
							if(q.equals(jWordSorted))
								System.out.print(q+" ");
						}
					}
					break;
			}
			case 'r':
			{
				for (String r: dWordListR )
					{
						if(r.length() == jWordSorted.length())
						{
							if(r.equals(jWordSorted))
								System.out.print(r+" ");
						}
					}
					break;
			}
			case 's':
			{
				for (String s: dWordListS )
					{
						if(s.length() == jWordSorted.length())
						{
							if(s.equals(jWordSorted))
								System.out.print(s+" ");
						}
					}
					break;
			}
			case 't':
			{
				for (String t: dWordListT )
					{
						if(t.length() == jWordSorted.length())
						{
							if(t.equals(jWordSorted))
								System.out.print(t+" ");
						}
					}
					break;
			}
			case 'u':
			{
				for (String u: dWordListU )
					{
						if(u.length() == jWordSorted.length())
						{
							if(u.equals(jWordSorted))
								System.out.print(u+" ");
						}
					}
					break;
			}
			case 'v':
			{
				for (String v: dWordListV )
					{
						if(v.length() == jWordSorted.length())
						{
							if(v.equals(jWordSorted))
								System.out.print(v+" ");
						}
					}
					break;
			}
			case 'w':
			{
				for (String w: dWordListW )
					{
						if(w.length() == jWordSorted.length())
						{
							if(w.equals(jWordSorted))
								System.out.print(w+" ");
						}
					}
					break;
			}
			case 'x':
			{
				for (String x: dWordListX )
					{
						if(x.length() == jWordSorted.length())
						{
							if(x.equals(jWordSorted))
								System.out.print(x+" ");
						}
					}
					break;
			}
			case 'y':
			{
				for (String y: dWordListY )
					{
						if(y.length() == jWordSorted.length())
						{
							if(y.equals(jWordSorted))
								System.out.print(y+" ");
						}
					}
					break;
			}
			case 'z':
			{
				for (String z: dWordListZ )
					{
						if(z.length() == jWordSorted.length())
						{
							if(z.equals(jWordSorted))
								System.out.print(z+" ");
						}
					}
					break;
			}

	}
	System.out.print("\n");
	}
	long endTime = System.currentTimeMillis();
	long ms = endTime-startTime;
	System.out.println("Eclipsd time in ms:" + ms);

}
	
catch (Exception e)
{
	System.out.println("EXCEPTION DETECTED: " + e );
	System.exit(0);
}

    } // END MAIN

	// =================== Y O U R   M E T H O D S  B E L O W  ======================


	
	


} // END GRAPH CLASS
