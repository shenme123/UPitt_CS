/*
	BinaryPrint.java
	uses ">>" and "&" operators to print numbers 0 thru 64 in binary
*/

import java.io.*;

public class BinaryPrint
{
	public static void main( String[] args )
	{

	  System.out.printf("        B I T   P O S I T I O N\n");
	  System.out.printf("       1111100000000000\n");
	  System.out.printf("       15432109876543210\n");
	  System.out.printf("\n");

	  for ( short number=0 ; number < 65 ; ++number)
	  {
	    System.out.printf("%3d == ", number);
	    for (int  i = 15 ; i >=0  ; --i )
	    {
	       /* shift i'th bit to the end position then AND it with 1 */
	       if (  (number>>i  & 1) == 1) /* >> has higher precedence than & */
	          System.out.printf("1" );
	       else
	          System.out.printf("0" );
	    } // END FOR i
	    System.out.printf("\n");
	  } // END FOR number
	} // END MAIN
} // END CLASS BINARY PRINT