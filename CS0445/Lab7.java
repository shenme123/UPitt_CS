import java.util.*;
import java.io.*;

public class Lab7
{
	public static void main (String args[]) throws Exception
	{
		String test = "hof3adb";
		String regex ="([a-zA-Z]+([0-9]|)){0,8}";
		System.out.println ( test.matches(regex) );
	}
}

//"([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]"
//(^[a-zA-Z]+[0-9]*$){0,8}