
public class LL
{
	private LE head;

	public LL()
	{
		head = null;
	}

	public void insertAtHead(String data)
	{
		// YOUR CODE HERE
		LE newLE = new LE(data);
		if (head==null)
			head = newLE;
		else {
			newLE.setNext(head);
			head = newLE;
		}
	}

	// make head point to whatever is AFTER the first element
	// by doing so we leap frog over the first element and remove it from the list
	public void removeAtHead()
	{
		// YOUR CODE HERE
		if (head != null)
		{
			if (head.getNext()!= null)
				head = head.getNext();
			else{
				head = null;
			}
		}
	}

	// search the list for an LE with this data in it. Remove this node
	// remove by making the LE before it point to the one after it.
	public void remove( String data)
	{
		// YOUR CODE HERE
		if (head != null)
		{
			if (head.getData()== data)
				removeAtHead();
			else
				removeR (head, data);
		}
	}
	private void removeR ( LE le, String data)
	{
		if (le.getNext() != null )
		{
			if (le.getNext().getData().equals(data))
				le.setNext(le.getNext().getNext());
			else {
				removeR (le.getNext(), data);
			}
		}
	}


	public void insertAtTail( String data)
	{
		// YOUR CODE HERE
		if (head == null)
			head = new LE(data);
		else 
			insertAtTailR (head, data);
	}
	private void insertAtTailR( LE le, String data)
	{
		LE newLE = new LE(data);
		if (le.getNext() == null)
			le.setNext(newLE);
		else {
			insertAtTailR (le.getNext(), data);
		}
	}

	public void removeAtTail()
	{
		// YOUR CODE HERE
		if (head != null)
		{
			if (head.getNext()== null)
				head = null;
			else
				removeAtTailR(head);
		}

	}
	private void removeAtTailR( LE le)
	{
		if (le.getNext().getNext() == null)
			le.setNext(null);
		else removeAtTailR( le.getNext());
	}

	public int length()
	{
		return lengthR (head);  // JUST FOR COMILATION - YOU CHANGE AS NEEDED
	}
	private int lengthR (LE le)
	{
		if (le == null) return 0;
		if (le.getNext()== null)
			return 1;
		return 1 + lengthR(le.getNext());
	}


	public boolean search( String data )
	{
		return searchR (head, data);
		// JUST FOR COMILATION - YOU CHANGE AS NEEDED
	}
	private boolean searchR (LE le, String data)
	{
		if (le == null) return false;
		if (le.getData().equals(data))
			return true;
		return searchR (le.getNext(), data);
	}
	
	public void makeEmpty()
	{
		// YOUR CODE HERE
		head = null;
	}


	// GIVEN AS IS DO NOT MODIFY
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


