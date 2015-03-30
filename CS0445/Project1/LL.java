import java.util.*;
import java.io.*;

public class LL
{
	private LE head = null;  // pointer to the front (first) element of the list.  None yet

	public LL( String fileName, String insertionMode ) throws Exception
	{
		head = loadList( fileName ,  insertionMode); // compiler does this anyway. just for emphasis
	}

	public LL( LL other )
	{
		// YOUR CODE HERE
		if (other.head == null)
			head = null;
		else 
		{
			LE iter = new LE(other.head.getData());
			this.head = iter;
			LE iterO = other.head;
			while (iterO.getNext()!= null)
			{
				iter.setNext(new LE(iterO.getNext().getData()));
				iter = iter.getNext();
				iterO = iterO.getNext();
			}
		}
	}

	//---------------------------------------------------------

	public LE loadList( String fileName , String insertionMode ) throws Exception
	{
			Scanner inFile = new Scanner( new File( fileName) );
			String data;

			while ( inFile.hasNext() )
			{
				data =  inFile.next();

				if (insertionMode.equals( "head" ))
					head = insertAtHead( data );
				else if (insertionMode.equals( "tail" ))
					head =  insertAtTail(  data );
				else if (insertionMode.equals( "ordered" ))
					head = insertInOrder( data  );
				else
					throw new RuntimeException("Unrecognized insertion mode: <" + insertionMode + ">");
			}
			inFile.close();
			return head;
	}


	public LE insertAtHead(String data)
	{
		return insertAtHeadRecursive(head, data); // need recursive version since main can't pass head in (it's private)
	}

	private LE insertAtHeadRecursive(LE head, String data)
	{
		return new LE(data,head); // need recursive version since main can't pass head in (it's private)
	}

	public LE insertAtTail( String data)
	{
		return insertAtTailRecursive(head, data); // need recursive version since main can't pass head in (it's private)
	}

 	private  LE insertAtTailRecursive( LE head, String data)
 	{
 	   if (head == null)
 		 head = new LE(data,null);
 	   else
 	     head.setNext( insertAtTailRecursive(head.getNext(), data) );
 	   return head;
 	 }

	public  LE insertInOrder (String data)
	{
		return insertInOrderRecursive( head, data); // need recursive version since main can't pass head in (it's private)
	}

 	private  LE insertInOrderRecursive(LE head, String data)
 	{
     	// YOUR CODE HERE
		if (head == null)
			head = new LE(data);
		else if (head.getData().compareTo(data)>0)
			head = new LE(data, head);
		else
		{
			if (head.getNext() == null)
				head.setNext(new LE(data));
			else if (head.getNext().getData().compareTo(data)>0)
				head.setNext(new LE(data, head.getNext()));
			else 
				insertInOrderRecursive(head.getNext(), data);
		}
		return head;
  	}

	public LE removeFirst(String data)
	{
		return removeFirstRecursive( head,  data); // need recursive version since main can't pass head in (it's private)
	}

  	private LE removeFirstRecursive(LE head, String data)
	{
		// YOUR CODE HERE
		if (head != null)
		{
			if (head.getData().equals(data))
				return head = head.getNext();
			if (head.getNext()!=null)
			{
				if (head.getNext().getData().equals(data))
					head.setNext(head.getNext().getNext());
				else 
					removeFirstRecursive(head.getNext(), data);
			}
		}
		return head;
  	}

	public LE removeAll(String data)
	{
		return removeAllRecursive( head,  data); // need recursive version since main can't pass head in (it's private)
	}

	private  LE removeAllRecursive(LE head, String data)
	{
		// YOUR CODE HERE
		if (head != null)
		{
			if (head.getData().equals(data))
				return head = head.getNext();
			if (head.getNext()!=null)
			{
				while (head.getNext().getData().equals(data))
					head.setNext(head.getNext().getNext());
				removeAllRecursive(head.getNext(), data);
			}
		}
		return head = null;
  	}

	public boolean search(String data)
	{
		return searchRecursive( head,  data); // need recursive version since main can't pass head in (it's private)
	}

	private boolean searchRecursive(LE head, String data)
	{
		// YOUR CODE HERE
		if (head == null)	return false;
		if (head.getData().equals(data))	return true;
		return searchRecursive(head.getNext(), data);
	}

	public boolean equals(LL other)
	{
		return equalsRecursive( head, other.head); // need recursive version since main can't pass head in (it's private)
	}

	private boolean equalsRecursive(LE head, LE otherHead)
	{
		// YOUR CODE HERE
		if (head == null && otherHead == null)
			return true;
		if (!head.getData().equals(otherHead.getData()))
			return false;
		return equalsRecursive(head.getNext(), otherHead.getNext());
	}

	public int length(  )
	{
			return lengthRecursive( head ); // need recursive version since main can't pass head in (it's private)
	}

	private int lengthRecursive( LE head )
	{
		if (head==null) return 0;
		return 1 + lengthRecursive( head.getNext() );
	}

	public boolean isEmpty()
	{
		// YOUR CODE HERE
		if (head == null) return true;
		else return false;
	}

	public void makeEmpty()
	{
		// YOUR CODE HERE
		head = null;
	}

	public String toString()
	{
		String s = new String();

		for (LE curr = head; curr != null; curr = curr.getNext())
		{
			s += curr.getData().toString();
			if (curr.getNext() != null)
				s += "->";
		}
		s += "\n";

		return s;
	}

} // END LINKED LIST CLASS



