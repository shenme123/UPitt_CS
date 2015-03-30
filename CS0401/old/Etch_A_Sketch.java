import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener  // NOTE multiple interfaces
{

	JFrame window;
	Container content;
	int mouseX,mouseY,oldX,oldY;
	JLabel coords;



	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		content = window.getContentPane();
		content.setLayout( new FlowLayout() );

		coords = new JLabel();
		coords.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		
		content.add( coords); 
		content.addMouseListener(this);        // "this" is the class that impliments that listener
		content.addMouseMotionListener(this);  // "this" is the class that impliments that listener
		window.setSize(640,480);
		window.setVisible(true);
	}


	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse clicked at: " +
			mouseX + "," + mouseY );
		
	}
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse Pressed at: " +
			mouseX + "," + mouseY );
		//repaint();
	}

	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse released at: " +
			mouseX + "," + mouseY );
		//repaint();
	}

	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse exited at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse Entered at: " +
			mouseX + "," + mouseY );
		//repaint();
	}

	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		// drawPoint( x,y );
		Graphics g = content.getGraphics();
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		reportCoords("Mouse Dragged at: " +
			mouseX + "," + mouseY );
		//repaint();
	}
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportCoords("Mouse Moved at: " +
			mouseX + "," + mouseY );
		//repaint();
	}



	// ..............................................................
	

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	}
	// a helper utility
	private void reportCoords( String msg )
	{
		coords.setText( msg ); 
	}


}//EOF
