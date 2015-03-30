public class Test1
{
	public static void main (String args[])
	{
		int x=28;
		int sum = 0;
		for (int i=1; i<=28; i++)
		{
			if(x%i == 0)
				sum += i;
		}
		System.out.print(sum);
	}
} // END class Speeder