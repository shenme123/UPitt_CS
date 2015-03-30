// CS 0401 Fall 2011
// This example demonstrates JPanel, GridLayout and a few additional useful graphical features.
// From an example by john ramirez

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanels_1 implements ActionListener
{

	private

	JFrame window;  // the main window which contains everything
	JPanel topPanel,bottomPanel;  // two sub-windows which get added to the main window
	JButton b1, b2, b3, bQuit;
	JLabel c1, c2, c3, total;
	int count1, count2, count3, sum;


	
	public JPanels_1()
	{
		// top and bottom panels will have GridLayout defined on them
		// however each panel's GridLayout will be configured slightly different 

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(2,3)); // means 2 rows 3 columns


		// Create some Buttons to put on our top panel 

		b1 = new JButton("PUSH 1"); 
		b2 = new JButton("PUSH 2"); 
		b3 = new JButton("PUSH 3"); 

		// Add these buttons to our top panel
		// the layout affects where they position themselves
		// i.e they all go to the top row of the panel

		topPanel.add(b1); // goes to row-1 col-1
		topPanel.add(b2); // goes to row-1 col-2
		topPanel.add(b3); // goes to row-1 col-3

		// now register these buttons with a listener so that we can
		// write some code to be executed when they are clicked

		b1.addActionListener(this );
		b2.addActionListener(this );
		b3.addActionListener(this );
		
		// Create some Labels to put on our top panel
			
		c1 = new JLabel("0"); // Initialize the label text to be a "0"
		c1.setHorizontalAlignment(SwingConstants.CENTER); // the "0" string is center justified
		c2 = new JLabel("0"); // Initialize the label text to be a "0"
		c2.setHorizontalAlignment(SwingConstants.CENTER); // the "0" string is center justified
		c3 = new JLabel("0"); // Initialize the label text to be a "0"
		c3.setHorizontalAlignment(SwingConstants.CENTER); // the "0" string is center justified
		
		// Add these labels to our top panel
		// the layout affects where they position themselves
		// i.e they all go to the 2nd row of the panel
		
		topPanel.add(c1); // goes to row-2 col-1
		topPanel.add(c2); // goes to row-2 col-2
		topPanel.add(c3); // goes to row-2 col-3
 
		// count1,count2,count3 stores # times b1,b2,b3 has been clicked.

		count1 = 0; count2 = 0; count3 = 0;
		sum = 0; // the sum of all the other 3 buttons

		// SETUP THe BOTTOM PANEL - sum button goes in bottom row
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1)); // 2 rows, 1 col
		
		total = new JLabel("0");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		//total.setFont(new Font("TimesRoman", Font.BOLD, 50));  // try this 

		bQuit = new JButton("Click to Quit");
		// Note that we are not even saving the listener object below
		// in a variable.  We don't actually need a separate variable
		// since it is being attached to the JButton -- we have access
		// to it through the JButton.
		bQuit.addActionListener( this );
		bottomPanel.add(total);
		bottomPanel.add(bQuit);
		
		window = new JFrame("Counting with Buttons");
		window .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container content = window.getContentPane();

		// Now the components are placed using BorderLayout.  This
		// divides the window into 5 sections, as discussed in the
		// text
		
		content.add(topPanel, BorderLayout.NORTH);
		content.add(bottomPanel, BorderLayout.SOUTH);
		window.pack();
		window.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bQuit)
		{
			System.exit(0);
		}
		else if (e.getSource() == b1)
		{
			count1++;
			c1.setText(String.valueOf(count1));
		}
		else if (e.getSource() == b2)
		{
			count2++;
			c2.setText("" + count2);
		}
		else if (e.getSource() == b3)
		{
			count3++;
			c3.setText(String.valueOf(count3));
		}
		sum = count1 + count2 + count3;
		total.setText("" + sum);
	}
	
// ######################## M  A  I  N #############################

	public static void main(String [] args)
	{
		new JPanels_1();
	}
}

