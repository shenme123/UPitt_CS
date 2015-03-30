import java.util.*;
import java.io.*;

public class BST
{
	private BSTNode root;

	// GIVEN
	public void insert( Comparable data )
	{
		root = insertHelper( root, data );
	}
	// GIVEN
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

	// GIVEN
	public void inOrderPrint()
	{
		inOrderPrintHelper( root );
		System.out.println();
	}
	// GIVEN
	public void inOrderPrintHelper( BSTNode root)
	{
		if (root==null) return;
		inOrderPrintHelper( root.getLeft() );
		System.out.print(root.getData() + " ");
		inOrderPrintHelper( root.getRight() );
	}



	public int countNodes()
	{
		return countNodesR(root);
	}
	private int countNodesR(BSTNode root)
	{
		if (root == null)
			return 0;
		return 1 + countNodesR(root.getLeft()) + countNodesR(root.getRight());
	}

	public int countLeaves()
	{
		return countLeavesR(root);
	}
	private int countLeavesR(BSTNode root)
	{
		if (root == null)
			return 0;
		if (root!= null && root.getLeft()==null && root.getRight()==null)
			return 1;
		return countLeavesR(root.getLeft())+countLeavesR(root.getRight());
	}

	public int depth()
	{
		return depthR(root);
	}
	private int depthR(BSTNode root)
	{
		if (root == null)
			return 0;
		return 1 + Math.max(depthR(root.getLeft()), depthR(root.getRight()) );
	}


	/* Print your level counts in this format one line per level.
		0:	1
		1:	2
		2: 4
		etc.
	*/
	public void printLevelCounts()
	{
		for (int i=0; i<depth(); i++)
		{
			System.out.println(i+":\t"+levelCounts(root, i));
		}
	}
	private int levelCounts(BSTNode root, int depth)
	{
		if (root == null)
			return 0;
		if (depth == 0)
			return 1;
		return levelCounts(root.getLeft(),depth-1)+levelCounts(root.getRight(), depth-1);
	}

	public Comparable leftMost()
	{
		return leftMostR(root);
	}
	private Comparable leftMostR(BSTNode root)
	{
		if (root == null)
			return null;
		if (root.getLeft() == null)
			return root.getData();
		return leftMostR(root.getLeft());
	}

	public Comparable rightMost()
	{
		return rightMostR(root);
	}
	private Comparable rightMostR(BSTNode root)
	{
		if (root == null)
			return null;
		if (root.getRight() == null)
			return root.getData();
		return rightMostR(root.getRight());
	}

	public boolean isFull()
	{
		return isFullR(root);
	}
	private boolean isFullR(BSTNode root)
	{
		if (root == null)
			return false;
		if (root.getLeft() == null && root.getRight() == null)
			return true;
		return isFullR(root.getLeft()) && isFullR(root.getRight());
	}

	public boolean isComplete()
	{
		return isCompleteR( root);
	}
	private boolean isCompleteR( BSTNode root )
	{
		if (root == null)
			return true;
		int l = depthR(root.getLeft());
		int r = depthR(root.getRight());
		if ( l < r )
			return false;
		if (l == r )
		{
			if (Math.pow(2, l)-1 != countNodesR(root.getLeft()))
				return false;
			return isCompleteR(root.getLeft()) && isCompleteR(root.getRight());
		}
		else
		{
			if (Math.pow(2, r)-1 != countNodesR(root.getRight()))
				return false;
			return isCompleteR(root.getLeft()) && isCompleteR(root.getRight());
		}
	}

	// You may assume that any node to be deleted actually exists in the tree
	// This makes it a lot simpler
	public void remove( Comparable data )
	{
		BSTNode iter = root;
		BSTNode parent = null;
		boolean found = false;

		while (!found && (iter!= null))
		{
			int compare = iter.getData().compareTo(data);
			if (compare == 0) 
				found = true;
			else if (compare >0 )
			{
				parent = iter;
				iter = iter.getLeft();
			}
			else
			{
				parent = iter;
				iter = iter.getRight();
			}
		}

		if ( iter.getLeft()==null && iter.getRight()==null )
		{
			if (iter == root)
				root = null;
			else
			{
				if (parent.getLeft() == iter)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}
		}

		else if ( iter.getLeft()==null )
		{
			if (iter == root)
				root = root.getRight();
			else 
			{
				if (parent.getLeft() == iter)
					parent.setLeft(iter.getRight());
				else 
					parent.setRight(iter.getRight());
			}
		}

		else if ( iter.getRight()==null )
		{
			if (iter == root)
				root = root.getLeft();
			else 
			{
				if (parent.getLeft() == iter)
					parent.setLeft(iter.getLeft());
				else 
					parent.setRight(iter.getLeft());
			}
		}

		else 
		{
			if (iter == root)
			{
				Comparable replace = leftMostNode(root.getRight()).getData();
				remove(leftMostNode(root.getRight()).getData());
				root = new BSTNode(replace, root.getLeft(), root.getRight());
			}
			else
			{
				if (parent.getLeft() == iter)
				{
					Comparable replace = leftMostNode(iter.getRight()).getData();
					remove(leftMostNode(iter.getRight()).getData());
					parent.getLeft().setData(replace);
				}
				else
				{
					Comparable replace = leftMostNode(iter.getRight()).getData();
					remove(leftMostNode(iter.getRight()).getData());
					parent.getRight().setData(replace);
				}
			}
		}
	}
	private BSTNode leftMostNode( BSTNode root )
	{
		if (root.getLeft() == null || root == null)
			return root;
		return leftMostNode( root.getLeft() );
	}
} // END BST CLASS
