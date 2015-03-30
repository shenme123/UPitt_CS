import java.io.*;
import java.util.*;

public class ComputeDistanceBetween {

    public static void main(String[] args) throws Exception {
        
		long before = System.currentTimeMillis();
        //1st file
        try{
            if (args.length !=2) throw new Exception();
        }
        catch (Exception e){
            System.out.println("Usage: java ComputeDistanceBetween filename_1 filename_2");
            System.exit(0);
        }
        
		HashMap<String, Integer> wd2freq_1 = new HashMap<>();
		int lineNo1 = 0;
        int wordNo1 = 0;
        try{
            BufferedReader infile = new BufferedReader(new FileReader(args[0]) );

            while (infile.ready()){
                lineNo1++;
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
								if (wd2freq_1.containsKey(s)){
									 wd2freq_1.put(s, wd2freq_1.get(s)+1);
								}
								else {
									wd2freq_1.put(s, 1);
								}
								wordNo1++;
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
            System.out.println(args[0]+" is not found!");
        }
        System.out.println("File "+args[0]+": "+lineNo1+" lines, "+wordNo1+" words, "+wd2freq_1.size()+" distinct words");        
        
        //2nd file
		HashMap<String, Integer> wd2freq_2 = new HashMap<>();
		int lineNo2 = 0;
        int wordNo2 = 0;
        try{
            BufferedReader infile = new BufferedReader(new FileReader(args[1]) );


            while (infile.ready()){
                lineNo2++;
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
								if (wd2freq_2.containsKey(s)){
									 wd2freq_2.put(s, wd2freq_2.get(s)+1);
								}
								else {
									wd2freq_2.put(s, 1);
								}
								wordNo2++;
								i=j;
							}
							else j++;
						}
					}
				}
            }
            infile.close();
        }
        catch(FileNotFoundException e2){
            System.out.println(args[1]+" is not found!");
        }
        System.out.println("File "+args[1]+": "+lineNo2+" lines, "+wordNo2+" words, "+wd2freq_2.size()+" distinct words");
		
        double angle = Math.acos( innerProd(wd2freq_1, wd2freq_2)/(norm(wd2freq_1)*norm(wd2freq_2)) );
        System.out.printf("The distance between the documens is: %.6f radians\n", angle);

		long after = System.currentTimeMillis();
		double time = (after-before)/1000.0;
		System.out.printf("Time elapsed: %.2f seconds",time);
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
