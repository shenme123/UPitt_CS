// ReadFile.java demonstrates use of the Scanner read text files

import java.io.*;
import java.util.*;

public class ReadFile
{
	public static void main( String[] args ) throws Exception  // We will learn Exceptions later
	{
		if (args.length < 1 )
		{
			System.out.println("Must put filename on cmd line\n");
			System.exit(0);
		}

		Scanner infile  = new Scanner ( new File(args[0]) );       // whitespace is default delimiter
		int tokenNum=0;
		while( infile.hasNext() ) // while there is another token in the file
		{
			++tokenNum;
			String token= infile.next();  // reads in the next token. Use .nextLine to read entire line
			System.out.printf("%-3d %s\n",tokenNum,token);
		}

	}// END MAIN
}
