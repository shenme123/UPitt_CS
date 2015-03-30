/*

                                  A           ------  1
                                /  \
                              /      \
                             B        C       ------  2
                            / \         \
                          /     \         \
                         D       E         H  ------  3
                                / \       /
                              /     \    /
                             F       G  I     ------  4
*/


public class UseTreeDisplay{
    
    public Node buildTree(){
        Node btF = new Node("F"); 
        Node btG = new Node("G");    
        Node btE = new Node("E",btF,btG);
        
        Node btD = new Node("D");
        Node btB = new Node("B",btD,btE);
        
        Node btH = new Node("H",new Node("I"),null);
        Node btC = new Node("C",null,btH);
        
        Node btA = new Node("A",btB,btC);
        
        return btA;
    }
        
    public static void main(String[] args) throws CloneNotSupportedException{
        UseTreeDisplay utd = new UseTreeDisplay();
        TreeDisplay display = new TreeDisplay("Test");
		Expression exp = new Expression("(A ^ (B ^ (C ^ (DvE))))");
        display.setRoot(exp.root);
		exp.setAtom("A", "true");
		exp.setAtom("B", "true");
		exp.setAtom("C", "false");
		exp.setAtom("D", "true");
		exp.setAtom("E", "false");
		System.out.println("result: "+exp.evaluate(exp.root));
		exp.displayNormalized(exp);
		display.setRoot(exp.root);
//		TreeDisplay display_n = new TreeDisplay("Test2");
//		display_n.setRoot(ancestor.right);
    }
}