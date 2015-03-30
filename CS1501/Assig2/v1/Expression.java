//Wentao Jiang, wej10@pitt.edu, 9394

import java.io.*;
import java.util.*;

public class Expression{
	
	public String str;
	public Node root;
	static TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
	
	public Expression(){}

	public Expression(String s){
		this.str = s;
		s=s.replaceAll("\\s+", "");
		root = this.drawTree(s);
	}

/*	private static Node drawTree(String exp) {
		
	}
*/
	private static Node drawTree(String exp) {
        Stack<Character> op = new Stack<Character>();
        Stack<Node> parenth = new Stack<Node>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '!' || ch == '^' || ch == 'v') {
                op.add(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                Node atom = new Node(ch);
                parenth.add(atom);
            } else if (ch == '(') {
            } else if (ch == ')') {
                if (op.isEmpty()) {
                    //break
                } else if (op.peek() == '!') {
                    Node minusOp = new Node(op.peek());
                    Node atom = null;
                    atom = parenth.pop();
                    minusOp.setRight(atom);
                    parenth.add(minusOp);
                    op.pop();
                } else if (op.peek() == '^' || op.peek() == 'v') {
                    Node biOp = new Node(op.peek());
                    Node leftAtom = null;
                    Node rightAtom = null;
                    Node right = parenth.pop();
                    Node left = parenth.pop();
                    biOp.setLeft(left);
                    biOp.setRight(right);
                    parenth.add(biOp);
                    op.pop();
                }
            }
        }
        return parenth.pop();
    }

	public static void setAtom(String atom, String value){
		if (value == "true" )
			map.put(atom, Boolean.TRUE);
		else
			map.put(atom, Boolean.FALSE);	
	}
	
	public boolean evaluate(){
		return evaluateH(root);
	}
	private boolean evaluateH(Node root){
		if (root.getValue() == '!') {
            return !evaluateH(root.right);
        } else if (root.getValue() == '^') {
            return evaluateH(root.left) && evaluateH(root.right);
        } else if (root.getValue() == 'v') {
            return evaluateH(root.left) || evaluateH(root.right);
        } else if (root.getValue() >= 'A' && root.getValue() <= 'Z') {
            return map.get(root.symbol);
        } else {
            //error
            return false;
        }
	}

	public Expression copy(){
		Node root_new = new Node();
		copyH(root, root_new);
		Expression exp_new = new Expression();
		exp_new.root = root_new;
		for (String s: this.map.keySet() ){
			exp_new.map.put(s, this.map.get(s));
		}
		return exp_new;
	}
	private void copyH(Node root, Node root_new){
		if (root!=null){			
			root_new.symbol = root.symbol;
			if (root.left !=null){
				root_new.left = new Node();
				copyH(root.left, root_new.left);
			}
			if (root.right != null){
				root_new.right = new Node();
				copyH(root.right, root_new.right);
			}   
		}
	}


	public void normalize(Node root, Node parent, Node ancester) throws CloneNotSupportedException{
		if (root == null || root.getValue() == '*') { 
            return;
        }
        normalize(root.left, root, parent);
        normalize(root.right, root, parent);
        if (parent == null || ancester == null) {
            return;
        }
        char ch = root.getValue(), chParent = parent.getValue();
        if (ch == '!' && chParent == '!') {
            parent.setValue('*');
            ancester.right = root.right;
        } else if (chParent == '!' && (ch == '^' || ch == 'v')) {
            Node leftMinus = new Node('!'), rightMinus = new Node('!');
            parent.setValue(ch == 'v' ? '^' : 'v');
            root.setValue('*');
            leftMinus.right = root.left;
            rightMinus.right = root.right;
            parent.left = leftMinus;
            parent.right = rightMinus;
            ancester.right = parent;
        } else if ((chParent == '^' && ch == 'v' && parent.left == root && parent.right.getValue() <= 'Z' && parent.right.getValue() >= 'A')
                || (chParent == '^' && ch == 'v' && parent.right == root && parent.left.getValue() <= 'Z' && parent.left.getValue() >= 'A')
                || (chParent == 'v' && ch == '^' && parent.left == root && parent.right.getValue() <= 'Z' && parent.right.getValue() >= 'A')
                || (chParent == 'v' && ch == '^' && parent.right == root && parent.left.getValue() <= 'Z' && parent.left.getValue() >= 'A')) {
            parent.setValue(ch);
            root.setValue('*');
            Node boLeft = new Node(chParent), boRight = new Node(chParent), Single = null, BiLeft = root.left, BiRight = root.right;
            if (parent.left == root) {
                Single = parent.right;
                boLeft.left = root.left;
                boLeft.right = (Node) Single.Clone();
                boRight.left = root.right;
                boRight.right = (Node) Single.Clone();
            } else {
                Single = parent.left;
                boLeft.left = (Node) Single.Clone();
                boLeft.right = root.left;
                boRight.left = (Node) Single.Clone();
                boRight.right = root.right;
            }
            parent.left = boLeft;
            parent.right = boRight;
            ancester.right = parent;
        }
	}

	public void displayNormalized(Expression exp) throws CloneNotSupportedException{
		Expression exp_new = exp.copy();
		Node ancestor = new Node("*");
		ancestor.right = exp_new.root;

		TreeDisplay display2 = new TreeDisplay(str+"_normalized");
		display2.setRoot(exp_new.root);

		exp_new.normalize(exp_new.root, ancestor, null);
	}

	public String toString(){
		return str;
	}
}