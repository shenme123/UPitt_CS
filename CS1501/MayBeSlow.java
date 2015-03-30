/***
  * This program computes the product of x * y by forming the sum x + x + ... + x where x appears y times.
  * The larger y is the more time is needed to compute x * y.
  */

public class MayBeSlow{
   public static void main(String args[]){
      long firstOperand = Long.parseLong(args[0]); //exmple from text is 7562
      long secondOperand = Long.parseLong(args[1]);//example from text is 400000000
      long product = 0;

      Stopwatch timer = new Stopwatch();
      
      for(; secondOperand>0; secondOperand--){
         product = product + firstOperand;
      }
     
      StdOut.println("elapsed time = " + timer.elapsedTime());
      StdOut.println(product);
   }
}
