import java.util.*;
import java.io.*;

public class BST
{
	private BSTNode root;

	public void insert( Comparable data )
	{
		root = insertHelper( root, data );
	}
	private BSTNode insertHelper( BSTNode root, Comparable data )
	{
		if (root == null)
			return new BSTNode(data,null,null);
		int comp = data.compareTo( root.getData() );
		if (comp < 0)
			root.setLeft( insertHelper(root.getLeft(), data ) );
		else
			root.setRight( insertHelper(root.getRight(), data ) );

		return root;
    } // END insertHelper

	public void levelOrderPrint()
	{
		// YOU CODe HERE. YOU MAY DECLARE AN ARRAYLIST OR ANY OF JAVA'S BUILTIN ADTS
		// TO IMPLEMENT YOUR LEVEL PRINT. YOU ARE ALSO ALLWED TO JUST USE RECURSION
		// TO DO THE LEVEL ORDER PRINT. USING A QUEUE IS HOWEVER THE SIMPLEST.
		Queue q = new LinkedList();
		if (root!= null)
		{
			q.add(root);
		}
		while (!q.isEmpty())
		{
			BSTNode next = (BSTNode)q.remove();
			System.out.print(next.getData()+" ");
			if (next.getLeft()!= null)
				q.add(next.getLeft());
			if (next.getRight()!=null)
				q.add(next.getRight());
		}
	} // END LEVEL ORDER PRINT

} // END BST CLASS
