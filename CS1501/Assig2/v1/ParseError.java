//Wentao Jiang, wej10@pitt.edu, 9394

import java.io.*;

public class ParseError {
	String exp_orig;
	String exp;

	public ParseError ( String exp_orig ){
		this.exp_orig = exp_orig;
		this.exp = exp_orig.replaceAll("\\s+", "");
	}

	public boolean checkExp () {
		boolean flag = false;
		int count=0;
		if ( exp.charAt(exp.length()-1) != ')' ){
			System.out.println("\tError:\n\t"+ exp_orig + " Missing right parenthesis.\n\tGet next expression " );
			return flag;
		}

		for (int i=0; i< exp.length()-1; i++){
			char ch = exp.charAt(i);
			if ( !( (ch == '!' || ch == '^' || ch == 'v') || (ch >= 'A' && ch <= 'Z') || ch=='(' || ch ==')' ) ){
				System.out.println("\tError:\n\t"+ exp_orig + " Illigal binary operator. \n\tGet next expression" );
				return flag;
			}
			if (ch == '!' || ch == '^' || ch == 'v'){
				char ch2 = exp.charAt(i+1);
				if ( !((ch2 >= 'A' && ch2 <= 'Z') || ch2 =='(') ){
					System.out.println("\tError:\n\t"+ exp_orig + " Illigal Charactor : A non-atom must begin with '('.\n\tGet next expression " );
					return flag;
				}
			}
			if (ch == '('){
				count++;
			}
			if (ch == ')'){
				count--;
			}
		}
		if (count !=1 ){
			System.out.println("\tError:\n\t"+ exp_orig + " Missing parenthesis.\n\tGet next expression " );
			return flag;
		}
		return true;
	}
}
