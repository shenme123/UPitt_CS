The ExpressionEvaluator and ExpressionDisplayer take an argument, which is the name of the file (that matches the format of data2eval.txt and data.txt respectively). 

The ExpressionEvaluator checks expression for correctness, and then evaluate and output the expression one by one.

The ExpressionDisplayer checks expression for correctness, and the display the tree built based on the expression and the normalized tree one by one. (Note that the tree and normalized tree windows overlap. Please drag to see two layers.)

Stack is used for building the tree so when certain operater is met, the stack pops the operand from the top. For building the normalized tree, recursion is used with different conditions clasified.