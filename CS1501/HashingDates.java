/*
 *  $ java HashingDates M month1 day1 year1 month2 day2 year2 ...
 * 
 *  S java HashingDates 97 
 * 
 *  Table size = 97
 *  7/25/1976 hashes to location 28 in table T
 *  10/30/1902 hashes to location 2 in table T
 *  4/1/2000 hashes to location 78 in table T
 **/

public class HashingDates{  
    public static int hashDate(int month, int day, int year, int M){
        int R = 31;
        return (((day * R + month) % M) * R + year) % M;
    }
    
    
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        StdOut.println("Table size = " + M);
        
        for(int j = 1; j < args.length; j = j + 3){
            int x = Integer.parseInt(args[j]);
            int y = Integer.parseInt(args[j+1]);
            int z = Integer.parseInt(args[j+2]);
            StdOut.printf("%s/%s/%s hashes to location %d in table T\n", args[j], args[j+1], args[j+2], hashDate(x,y,z,M));
        }
    }
}