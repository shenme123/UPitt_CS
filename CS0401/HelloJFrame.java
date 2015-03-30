import java.awt.*;
import javax.swing.*;


public class HelloJFrame
{
	public static void main(String args[])
	{
		JFrame window = new JFrame("m First JFrame");

		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JLabel message = new JLabel("Hello GUI World");
		message.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		message.setForeground( Color.RED);

		Container content = window.getContentPane();
		content.add(message);

		window.setSize(1000, 800);

		window.setVisible(true);
	}
}