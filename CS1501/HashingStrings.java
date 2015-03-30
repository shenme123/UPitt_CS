/*
 *  $ java HashingStrings M string1 string 2 string 3 ...
 * 
 *  S java HashingStrings 97 hashing strings is a fun activity
 * 
 *  Table size = 97
 * 'hashing' hashes to location 74 in table T
 * 'strings' hashes to location 63 in table T
 * 'is' hashes to location 72 in table T
 * 'a' hashes to location 0 in table T
 * 'fun' hashes to location 6 in table T
 * 'activity' hashes to location 65 in table T
 **/

public class HashingStrings{
    
    
    //Hash string s into table T of size M
    public static int hash(String s, int M){
        int hash = 0;
        int R = 31; //radix used in String's hashcode()
        
        for(int i = 0; i < s.length(); i++)
            hash = (R * hash + s.charAt(i)) % M; 

        
        return hash;
    }
    
   
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        StdOut.println("Table size = " + M);
        
        for(int j = 1; j < args.length; j++)
            StdOut.printf("'%s' hashes to location %d in table T\n", args[j], hash(args[j],M));
    }
}