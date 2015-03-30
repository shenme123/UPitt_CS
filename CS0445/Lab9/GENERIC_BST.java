import java.util.*;
import java.io.*;


public class GENERIC_BST<T extends Comparable<T>>
{
	private GENERIC_BSTNode root;

	// GIVEN
	public void insert( T data )
	{
		root = insertHelper( root, data );
	}
	// GIVEN
	private GENERIC_BSTNode insertHelper( GENERIC_BSTNode root, T data )
	{
		if (root == null) return new GENERIC_BSTNode(data); // L,R default to null
		int comp = data.compareTo( root.data );
		if (comp==0) return root;
		if (comp < 0)
			root.left = insertHelper(root.left, data  );
		else
			root.right = insertHelper(root.right, data  );

		return root;
	} // END insertHelper

	// GIVEN
	public void inOrderPrint()
	{
		inOrderPrintHelper( root );
		System.out.println();
	}
	// GIVEN
	public void inOrderPrintHelper( GENERIC_BSTNode root)
	{
		if (root==null) return;
		inOrderPrintHelper( root.left );
		System.out.print(root.data + " ");
		inOrderPrintHelper( root.right );
	}

	class GENERIC_BSTNode
	{
		public T data;
		public GENERIC_BSTNode left,right;
		public GENERIC_BSTNode( T data )
		{
			this.data = data;
		}
	}


} // END STRING_BST CLASS