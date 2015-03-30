/*  ArrayListDemo1.java */

import java.io.*;
import java.util.*;// ArrayList comes from the utils library

public class ArrayListDemo1
{
    public static void main( String args[] ) throws Exception // cause I didn't put  try/catch around everything
    {
        if (args.length < 1) System.exit(0); // need an input filename on cmd line
        Scanner infile = new Scanner( new File(args[0]) );
        ArrayList<String> a1  = new ArrayList<String>();
        
        // Notice we don't have to declare count value to keep track of how many elements we have in the array.
        // The ArrayList remembers how many elements have ever been added or removed
        // ArrayList allows us to call .size() the get our "count" of elementns present in the ArrayList
        
        while ( infile.hasNext() )
		    a1.add( infile.next() );
        infile.close();
        
        System.out.printf("\na1 contains %d strings read in from file: %s\n", a1.size(), args[0] );
        
        // THE OLD FOR LOOP  WAY TO PRINT OUT THE ELEMENTS FROM FRONT TO BACK
        
        System.out.println("\nPrinting the elements using old fashioned for loop and .get(i)\n");
        for ( int i=0 ; i<a1.size() ; ++i )
		   System.out.println( a1.get( i ) ); // .get() produces a ref to the element at index i
        
        // THE NEW FOR LOOP  WAY TO PRINT OUT THE ELEMENTS FROM FRONT TO BACK
        
        System.out.println("\nPrinting the elements using new for loop\n");
        for ( String s : a1 )
		    System.out.println( s ); // I like this one the best!
        
        // THE ITERATOR  WAY TO PRINT OUT THE ELEMENTS FROM FRONT TO BACK
        
        System.out.println("\nPrinting the elements using iterator\n");
        
        Iterator<String> itr = a1.iterator();
        while (itr.hasNext())
		    System.out.println(itr.next());
        
        // SORTING  LISTARAY USING THE COLLECTIONS LIBRARY
        
        Collections.sort(a1); // this is sooo simple
        System.out.println("\nPrinting the elements AFTER COLLECTIONS SORT using new for loop\n");
        for ( String s : a1 )
		    System.out.println( s );
        
        // SORTING  LISTARAY THE BRUATAL INEFFICENT WAY USING ARRAYS LIBRARY
        // I'd turn back if I were you !
        
        String[] arr = new String[ a1.size() ];  // dimension an array big enuf
        arr = a1.toArray( arr ); // arr gets a copy of that String array  we know lives somewhere inside the ArrayList.
        Arrays.sort( arr ); // now that simple array is sorted. have to convert it to a List becasue you can't init an ArrayList with a plain array
        a1 = new ArrayList<String>( Arrays.asList(arr) ); // re-initialize (destroy the old) ArrayList with a completely new one using our Strings as the initializer
        System.out.println("\nPrinting the elements AFTER ARRAYS SORT using new for loop\n");
        for ( String s : a1 )
		    System.out.println( s );
        
    } // END MAIN
} // END CLASS
