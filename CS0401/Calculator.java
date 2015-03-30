import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.script.*;

public class Calculator extends JFrame implements ActionListener 
{
	private JButton[] j;
	private JButton jCE, jC;
	private JButton jAdd, jSub, jMult, jDiv;
	private JButton equals;
	private JPanel topPanel, bottomPanel;
	private JPanel digits, ops;
	private JTextField expr, result;
	private final int WINDOW_WIDTH = 420, WINDOW_HEIGHT = 220;

	public Calculator ()
	{
//set Window
		setTitle("Calculator");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	//Bottom Panel		
		//digits
		j = new JButton [10];
		for (int i=0; i<10; i++)
		{
			j[i]= new JButton(""+i);
			j[i].addActionListener( this );
		}
		jCE = new JButton("CE");
		jCE.addActionListener(this);
		jC = new JButton("C");
		jC.addActionListener(this);

		digits = new JPanel();
		digits.setLayout( new GridLayout(4, 3) );

		for (int i=0; i<10; i++)
		{
			digits.add(j[i]);
		}
		digits.add(jCE);
		digits.add(jC);

		//ops
		ops = new JPanel();
		ops.setLayout ( new GridLayout(4, 1) );

		jAdd = new JButton("+");
		jSub = new JButton("-");
		jMult = new JButton("*");
		jDiv = new JButton("/");

		jAdd.addActionListener(this);
		jSub.addActionListener(this);
		jMult.addActionListener(this);
		jDiv.addActionListener(this);

		ops.add(jAdd);
		ops.add(jSub);
		ops.add(jMult);
		ops.add(jDiv);

		bottomPanel = new JPanel();
//		bottomPanel.setLayout( new BorderLayout() );
//		bottomPanel.add(digits, BorderLayout.WEST);
//		bottomPanel.add(ops,   BorderLayout.EAST);
		bottomPanel.add(digits);
		bottomPanel.add(ops);



	//Top Panel	
		equals = new JButton("=");
		expr = new JTextField(15);
		result = new JTextField(15);
		
		equals.addActionListener(this);

		topPanel = new JPanel();
		topPanel.setLayout( new FlowLayout());
		topPanel.add(expr);
		topPanel.add(equals);
		topPanel.add(result);

		

//		setLayout(new BorderLayout());
//		add(topPanel, BorderLayout.NORTH);
//		add(bottomPanel, BorderLayout.SOUTH);

		setLayout(new FlowLayout());
		add(topPanel);
		add(bottomPanel);
		
		setVisible(true);
		
	}




	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == j[0])
		{
			txt("0");
		}
		else if(e.getSource() == j[1])
		{
			txt("1");
		}
		else if(e.getSource() == j[2])
		{
			txt("2");
		}
		else if(e.getSource() == j[3])
		{
			txt("3");
		}
		else if(e.getSource() == j[4])
		{
			txt("4");
		}
		else if(e.getSource() == j[5])
		{
			txt("5");
		}
		else if(e.getSource() == j[6])
		{
			txt("6");
		}
		else if(e.getSource() == j[7])
		{
			txt("7");
		}
		else if(e.getSource() == j[8])
		{
			txt("8");
		}
		else if(e.getSource() == j[9])
		{
			txt("9");
		}
		else if(e.getSource() == jCE)
		{
			expr.setText(expr.getText().substring(0, expr.getText().length()-1));
		}
		else if(e.getSource() == jC)
		{
			expr.setText("");
		}
		else if(e.getSource() == jAdd)
		{
			txt("+");
		}
		else if(e.getSource() == jSub)
		{
			txt("-");
		}
		else if(e.getSource() == jMult)
		{
			txt("*");
		}
		else if(e.getSource() == jDiv)
		{
			txt("/");
		}
		else if (e.getSource()== equals)
		{
			try{
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");

			result.setText(""+engine.eval(expr.getText()));
			}
			catch(Exception err)
			{
			}
		}

		
	}
	
	public void txt(String s)
	{
		expr.setText(expr.getText()+s);
	}

	public static void main (String[] args) 
	{
		Calculator ca = new Calculator();
	}
}