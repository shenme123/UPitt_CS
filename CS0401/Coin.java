/*
	CoinTester.java - tests the Coin class by
	constructing variables and calling it's methods
*/
import java.util.*;

public class Coin
{
	int numHeads=0;
	int numTails=0;
	Random r = new Random (17);

	public int getNumHeads()
	{
		return numHeads;
	}
	public int getNumTails()
	{
		return numTails;
	}

	public char flip()
	{
		if(r.nextInt(2)==0)
		{
			numHeads++;
			return 'H';
		}
		numTails++;
		return 'T';
	}

	public void reset()
	{
		numHeads = 0;
		numTails = 0;
	}
}

