import javax.swing.JFrame;

public class CalculatorFrame 
{
	public static void main (String[] args)
	{
		JFrame frame = new Calculator();                        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setTitle("Calculator");
		frame.setVisible(true);		
		frame.setResizable(false);			//this is so the frame size will be fixed

	}

}
