import java.io.*;
import java.util.*;

public class ComputeDistanceBetween {

    public static void main(String[] args) throws Exception {
        
        //1st file
        try{
            if (args.length !=2) throw new Exception();
        }
        catch (Exception e){
            System.out.println("Usage: java ComputeDistanceBetween filename_1 filename_2");
            System.exit(0);
        }
        
 //       try{
            BufferedReader infile = new BufferedReader(new FileReader(args[0]) );
            HashMap<String, Integer> wd2freq_1 = new HashMap<>();
            int lineNo1 = 0;
            int wordNo1 = 0;


            while (infile.ready()){
                lineNo1++;
                String line = infile.readLine();
                line = rep(line);
                String[] wds = line.split(" ");
                //for (String s: wds) System.out.println(s);

                for (String s: wds){
                    if (s.trim().length()>0) {
                        wordNo1++;
                        s = s.toLowerCase();
                        if (wd2freq_1.containsKey(s))
                             wd2freq_1.put(s, wd2freq_1.get(s)+1);
                        else {
                            wd2freq_1.put(s, 1);
                        }
                    }
                }
            }
            infile.close();
 /*       }
        catch (FileNotFoundException e1) {
            System.out.println(args[0]+"is not found!");
            System.out.println("File prince.txt: 0 lines, 0 words, 0 distinct words");
        }
        */
        
        //2nd file
  //      try{
            infile = new BufferedReader(new FileReader(args[1]) );
            HashMap<String, Integer> wd2freq_2 = new HashMap<>();
            int lineNo2 = 0;
            int wordNo2 = 0;

            while (infile.ready()){
                lineNo2++;
                String line = infile.readLine();
                line = rep(line);
                String[] wds = line.split(" ");

                for (String s: wds){
                    if ( s.trim().length()>0 ) {
                        wordNo2++;
                        s = s.toLowerCase();
                        if (wd2freq_2.containsKey(s))
                             wd2freq_2.put(s, wd2freq_2.get(s)+1);
                        else {
                            wd2freq_2.put(s, 1);
                        }
                    }
                }
            }
            infile.close();
/*        }
        catch(FileNotFoundException e2){
            System.out.println(args[0]+"is not found!");
            System.out.println("File prince.txt: 0 lines, 0 words, 0 distinct words");
        }
        */
        double angle = Math.acos( innerProd(wd2freq_1, wd2freq_2)/(norm(wd2freq_1)*norm(wd2freq_2)) );
        System.out.println("File "+args[0]+": "+lineNo1+" lines, "+wordNo1+" words, "+wd2freq_1.size()+" distinct words");
        System.out.println("File "+args[1]+": "+lineNo2+" lines, "+wordNo2+" words, "+wd2freq_2.size()+" distinct words");
        System.out.printf("The distance between the documens is: %.6f radians\n", angle);
    }
    
    static String rep(String line) {
        line = line.replace(",", " ");
        line = line.replace(".", " ");
        line = line.replace("!", " ");
        line = line.replace("(", " ");
        line = line.replace(")", " ");
        line = line.replace(":", " ");
        line = line.replace(";", " ");
        line = line.replace("'", " ");
        line = line.replace("?", " ");
        line = line.replace("-", " ");
        line = line.replace("*", " ");
        line = line.replace("+", " ");
        line = line.replace("\"", " ");
        line = line.replace("@", " ");
        line = line.replace("#", " ");
        line = line.replace("$", " ");
        line = line.replace("%", " ");
        line = line.replace("^", " ");
        line = line.replace("&", " ");
        line = line.replace("[", " ");
        line = line.replace("]", " ");
        line = line.replace("_", " ");
        return line;
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
