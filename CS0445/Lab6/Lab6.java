// Lab6.java STARTER FILER

import java.io.*;
public class Lab6
{
  public static void main(String args[])
  {
    String fname = new String( args[0] );
    File f = new File (fname);

	if ( ! f.exists() )
	{
		System.out.println("FILE: "+f.getAbsolutePath()+" does not exist.");
		// print the absolute path of the file and report that it does not exist
	}
    else if ( f.isDirectory() )
    {
		// print the absolute path of the file and then list its children (all the files in this dir)
		System.out.println("FILE: "+f.getAbsolutePath()+" is a DIRECTORY. Its children are:");
		String [] chil = f.list();
		for (String s: chil )
		{
			System.out.println(s);
		}
 	}
 	else
 	{
		// print the absolute path of the file and its size in bytes
		System.out.println("FILE: "+f.getAbsolutePath()+" contains "+f.length()+ " bytes");
	}
  } // END MAIN
} // END LAB6 CLASS


