import java.io.*;
import java.util.*;

public class ComputeDistanceBetween {

    public static void main(String[] args) throws Exception {
        
		long before = System.currentTimeMillis();
 
        try{
            if (args.length !=2) throw new Exception();
        }
        catch (Exception e){
            System.out.println("Usage: java ComputeDistanceBetween filename_1 filename_2");
            System.exit(0);
        }

        //1st file       
		HashMap<String, Integer> wd2freq_1 = readFile(args[0]);
        
        //2nd file
		HashMap<String, Integer> wd2freq_2 = readFile(args[1]);
		
		
        double angle = Math.acos( innerProd(wd2freq_1, wd2freq_2)/(norm(wd2freq_1)*norm(wd2freq_2)) );
        System.out.printf("The distance between the documens is: %.6f radians\n", angle);

		long after = System.currentTimeMillis();
		double time = (after-before)/1000.0;
		System.out.printf("Time elapsed: %.2f seconds",time);
    }
    
	static HashMap<String, Integer> readFile(String filename) throws Exception{
		HashMap<String, Integer> wd2freq = new HashMap<>();
		int lineNo = 0;
        int wordNo = 0;
        try{
            BufferedReader infile = new BufferedReader(new FileReader(filename) );

            while (infile.ready()){
                lineNo++;
                String line = infile.readLine();
				line = line.toLowerCase();
				for (int i=0; i<line.length(); i++)
				{
					if ( (Character.isDigit( line.charAt(i) ) || Character.isLetter( line.charAt(i) )) ) {
						int j=i+1;
						boolean flag = true;
						while (flag)
						{

							if ( j==line.length() || !(Character.isDigit( line.charAt(j) ) || Character.isLetter( line.charAt(j) )) ){
								flag=false;
								String s = line.substring(i, j);
//								System.out.println(s);
								if (wd2freq.containsKey(s)){
									 wd2freq.put(s, wd2freq.get(s)+1);
								}
								else {
									wd2freq.put(s, 1);
								}
								wordNo++;
								i=j;
							}
							else j++;
						}
					}
				}
            }
            infile.close();
        }
		catch (FileNotFoundException e1) {
            System.out.println(filename+" is not found!");
        }
        System.out.println("File "+filename+": "+lineNo+" lines, "+wordNo+" words, "+wd2freq.size()+" distinct words");  
		return wd2freq;
	}

    static double innerProd(HashMap<String, Integer> x, HashMap<String, Integer> y){
        double sum=0;
        if (x.size()<y.size()) {
            for (String sx: x.keySet()){
                if ( y.containsKey(sx) ) {
                    sum += x.get(sx)*y.get(sx);
                }
            }
            return sum;
        }
        else {
            for (String sy: y.keySet()){
                if ( x.containsKey(sy) ) {
                    sum += y.get(sy)*x.get(sy);
                }
            }
            return sum;
        }
    }
    
    static double norm(HashMap<String, Integer> x) {
        return Math.sqrt(innerProd(x, x));
    }
}
