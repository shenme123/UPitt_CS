//Wentao Jiang, wej10@pitt.edu, 9394

import java.util.*;
import java.io.*;

public class  ExpressionEvaluator {
	public static void main(String[] args) throws Exception {
		BufferedReader data = new BufferedReader( new FileReader(args[0]) );
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		ArrayList<String> exps = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		int ord = 1;
		while (data.ready()){
			String line = data.readLine();
			if (!line.startsWith("(") ){
				String token[] = line.split("\\s+");
				if (token[1].equals("true") )
					map.put(token[0], Boolean.TRUE);
				else 
					map.put(token[0], Boolean.FALSE);
			}
			else 
				exps.add(line);
		}
		data.close();

		for (String s: map.keySet()){
			System.out.println(s + " = " + map.get(s) + "\t");
		}
		System.out.println();
		for (String expstr: exps ) {
			boolean flag = new ParseError(expstr).checkExp();
			if (flag)
			{
				Expression exp = new Expression(expstr);
				exp.map = map;
				System.out.println(ord + ". "+ expstr + " = " + exp.evaluate());
				ord++;
				System.out.print("\tContinue? y or n : ");
				String yesno = input.next();
				if (yesno.equals("n"))
					System.exit(1);
				else if (yesno.equals("y") )
					continue;
				else 
				yesno = input.next();
			}	
		}		
	}
}
