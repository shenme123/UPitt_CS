/* Fraction.java  A class (data type) definition file
   This file just defines what a Fraction is
   This file is NOT a program
   ** data members are PRIVATE
   ** method members are PUBLIC
*/
public class Fraction
{
	private int numer;
	private int denom;

	// ACCESSORS
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}

	// MUTATORS
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			// error msg OR exception OR exit etc.
			System.out.println("Denominator can not be 0!");
			System.exit(1);
		}
	}

	// DEFAULT CONSTRUCTOR - no args passed in
	public Fraction(  )
	{
		this( 0, 1 ); // "this" means call a fellow constructor
	}

	// 1 arg CONSTRUCTOR - 1 arg passed in
	// assume user wants whole number
	public Fraction( int n )
	{
		this( n, 1 ); // "this" means call a fellow constructor

	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction( int n, int d )
	{
		setNumer(n);
		setDenom(d);
		this.reduce();
	}

	// COPY CONSTRUCTOR - takes ref to some already initialized Fraction object
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); // call my full C'Tor with other Fraction's data
	}

	// ADD
	public Fraction add(Fraction other)
	{
		return new Fraction(this.getNumer()*other.getDenom()+other.getNumer()*this.getDenom(), this.getDenom()*other.getDenom());
	}

	// SUBTRACT
	public Fraction subtract(Fraction other)
	{
		return new Fraction(this.getNumer()*other.getDenom()-other.getNumer()*this.getDenom(), this.getDenom()*other.getDenom());
	}
	
	// MULTIPLY
	public Fraction multiply(Fraction other)
	{
		return new Fraction(this.getNumer()*other.getNumer(), this.getDenom()*other.getDenom());
	}

	// RECIPROCAL
	public Fraction reciprocal()
	{
		return new Fraction(this.getDenom(), this.getNumer());
	}

	// DIVID
	public Fraction divide (Fraction other)
	{
		return new Fraction(this.getNumer()*other.getDenom(), this.getDenom()*other.getNumer());
	}

	// REDUCE
	public void reduce()
	{
		for (int i=this.getNumer()>this.getDenom()?this.getDenom():this.getNumer(); i>1; i--)
		{
			if(this.getNumer() % i == 0 && this.getDenom() % i == 0) 
			{
				this.setNumer(numer/i);
				this.setDenom(denom/i);
				i = this.getNumer()>this.getDenom()?this.getDenom():this.getNumer();
			}
		}
	}

}// EOF
