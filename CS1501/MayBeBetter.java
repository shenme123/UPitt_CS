/***
  * This program computes the product of x * y by writing y = d d ... d
                                                               1 2     k
                    k-1              k-2                   0
    and computing 10    (x * d ) + 10   (x * d ) + ... + 10 (x * d )
                              1               2                   k

  * where k = number of digits in y.
  */

public class MayBeBetter{
   public static void main(String args[]){
      long firstOperand = Long.parseLong(args[0]); //example in text is 7562
      long secondOperand = Long.parseLong(args[1]); //example in text is 400000000
      long secondOperandLength = (long)(1 + Math.floor(Math.log10((double)secondOperand)));

      StdOut.println("number of digits in " + secondOperand + " = " + secondOperandLength);
      long product = 0;

      Stopwatch timer = new Stopwatch();
      
      for(; secondOperandLength>0; secondOperandLength--){
         long digit = secondOperand - (secondOperand/10) * 10;

         //Non-dominant inner-loop
         for(; digit>0; digit--){
            product = product + firstOperand;
         }

         secondOperand = secondOperand/10;
         firstOperand = 10 * firstOperand;
      }
      

      StdOut.println("elapsed time = " + timer.elapsedTime());
      StdOut.println(product);
   }
}
