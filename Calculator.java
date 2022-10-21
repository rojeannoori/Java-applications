import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class Calculator extends JFrame
{

private ActionListener listener;
private JButton clearlast;
private JButton clearall;
private JTextArea resultarea;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JButton button5;
private JButton button6;
private JButton button7;
private JButton button8;
private JButton button9;
private JButton button0;
private JButton buttonsum;
private JButton buttonmin;
private JButton buttonmul;
private JButton buttondiv;
private JButton buttondec;
private JButton buttonequ;

private String input;
private double number1=0;
private double number2=0;
private double result;
private int operator=0;
private String num1="",num2="", results="";
private ArrayList <JButton> buttonlist = new ArrayList();
private int num1d=0, num2d=0; 

private static final int FRAME_WIDTH =500;
private static final int FRAME_HEIGHT = 700;
private static final int AREA_ROWS = 1000;
private static final int AREA_COLUMNS = 40;

	
	public Calculator()
	{
		createControlPanel();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	
	
	public void createControlPanel() //add all the containers together to create the complete calculator layout.
	{
		JPanel panel1 = createButtons();
		JPanel panel2 = createTextArea();
		JPanel panel3 = createNumberButtons();
		
		JPanel panel4 = new JPanel();    //create panel4 and add clearlast and clearall buttons to the top and the result area to the center.
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1,BorderLayout.NORTH);
		panel4.add(panel2,BorderLayout.CENTER);
		
		JPanel panel5 = new JPanel();     //create panel5 and add clear buttons and resultrea to the top half and the buttons to the bottom half.
		panel5.setLayout(new GridLayout(2,1));
		panel5.add(panel4);
		panel5.add(panel3);
		add(panel5);
	
	}
	
	class buttonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
									//when a button with a number is clicked, that number will show in the text area. if have an operator (+,-,*,/)
									//the status of operator will be other than zero so the number will be added to the num2 string 
									//otherwise it is still part of number one and it will be added to num1 string
			if(event.getSource()==button0) {
				resultarea.setText(resultarea.getText()+"0");
				if(operator>0)
					num2=num2+0;
				else
					num1=num1+0;
			}
			if(event.getSource()==button1) {
				resultarea.setText(resultarea.getText()+"1");
				if(operator>0)
					num2=num2+1;
				else
					num1=num1+1;
			}
			if(event.getSource()==button2) {
				resultarea.setText(resultarea.getText()+"2");
				if(operator>0)
					num2=num2+2;
				else
					num1=num1+2;
			}
			if(event.getSource()==button3) {
				resultarea.setText(resultarea.getText()+"3");
				if(operator>0)
					num2=num2+3;
				else
					num1=num1+3;
			}
			if(event.getSource()==button4) {
				resultarea.setText(resultarea.getText()+"4");
				if(operator>0)
					num2=num2+4;
				else
					num1=num1+4;
			}
			if(event.getSource()==button5) {
				resultarea.setText(resultarea.getText()+"5");
				if(operator>0)
					num2=num2+5;
				else
					num1=num1+5;
			}
			if(event.getSource()==button6) {
				resultarea.setText(resultarea.getText()+"6");
				if(operator>0)
					num2=num2+6;
				else
					num1=num1+6;
			}
			if(event.getSource()==button7) {
				resultarea.setText(resultarea.getText()+"7");
				if(operator>0)
					num2=num2+7;
				else
					num1=num1+7;
			}
			if(event.getSource()==button8) {
				resultarea.setText(resultarea.getText()+"8");
				if(operator>0)
					num2=num2+8;
				else
					num1=num1+8;
			}
			if(event.getSource()==button9) {
				resultarea.setText(resultarea.getText()+"9");
				if(operator>0)
					num2=num2+9;
				else
					num1=num1+9;
			}
			
			
			if(event.getSource()==buttonsum){							//for each of the operators, if its value is zero, the we set the appropriate operator number
																		// if we already have an operator in the calculation the the program will calculate the result 
				if(operator==0)											// for the previous operator and display the result (as the first number) and also the operator 
					{													//that we just entered.
					operator=1;											//also if we don't have an operator but num1 is empty we assume that the result of the previous calculation
					resultarea.setText(resultarea.getText()+"+\n");		//is num1 and add the operator.
					if (num1.length()<1)
						num1 = results;
					}
				else 
				{
					calculate();
					operator=1;
					resultarea.setText(resultarea.getText()+"+");
					num1=results;
				}
				

				
			}
			if(event.getSource()==buttonmin) {
				
				if(operator==0)
					{	operator=2;resultarea.setText(resultarea.getText()+"-\n"); 
						if (num1.length()<1)
							num1 = results;
					}
				else 
				{
					calculate();
					operator=2;
					resultarea.setText(resultarea.getText()+"-");
					num1=results;
				}
				
			}
			if(event.getSource()==buttonmul) {
				if(operator==0)
				{operator=3;resultarea.setText(resultarea.getText()+"*\n");
				if (num1.length()<1)
					num1 = results;
				}
				else 
				{
					calculate();
					operator=3;
					resultarea.setText(resultarea.getText()+"*");
					num1=results;
				}
			}
			
			if(event.getSource()==buttondiv) {   						
				
				if(operator==0)
				{
					operator=4;resultarea.setText(resultarea.getText()+"/\n");
					if (num1.length()<1)
						num1 = results;
				}
				else 
				{
					calculate();
					operator=4;
					resultarea.setText(resultarea.getText()+"/");
					num1=results;
				}
			}
			if(event.getSource()==buttondec) {							//  for the decimal point button, first we check if num2 is empty and a decimal point is not added to num1
																		//  then we are still creating num1 so the decimal point will be added to its string and displayed
					if(num2.length()<1 && num1d<1) {						//  otherwise we are creating num2 and it will be added to that.
						num1 = num1+ ".";								//  we have a variable num1d and num2d which hold the number of times that decimal point is added to that number
						num1d++;											//  if it is equal or more than 1, no extra decimal point will be added to that number.
						resultarea.setText(resultarea.getText()+".");
					}
					else if(num2d<1) {
						num2 = num2+".";
						num2d++;
						resultarea.setText(resultarea.getText()+".");
					}
					
				
			}
			
			if(event.getSource()==buttonequ){  					//when ever the = button is clicked external by the user 
				calculate();										//then calculate method is called
				
			}
			
			if(event.getSource()==clearlast)						
			{	
				input = resultarea.getText();   				//we put all the text in the text area in to input variable
				char last = input.charAt(input.length()-1) ;			//we put the last character entered in the area in to last variable
				if (last=='+' || last=='-' || last=='*' || last=='/') {  //if last is equal to any operators, we set that operator to 0 and display everything but the last character
					operator=0;
					input = input.substring(0, input.length()-1);
				}
				
				else if(last=='.')   //if the last character is a decimal point if the num2 is empty then it must be for num1 so we set the num1 decimal point number to 0
				{					//otherwise it belongs to num2 and we set the decimal point numbers for num2 to zero and display everything but the last character
					if(num2.length()<1) {
						num1=num1.substring(0, num1.length()-1);
						num1d=0;
					}
					else {                                         
						num2=num2.substring(0, num2.length()-1);
						num2d=0;
					}
					input = input.substring(0, input.length()-1);
				}
				
				else if(last=='\n')					//if the last character was a white space(new line) if the character before that were operators it will erase the last two 
				{									// characters and set operator to zero.
					
					if (input.charAt(input.length()-2) == '+' || input.charAt(input.length()-2) == '-' ||input.charAt(input.length()-2) == '*' ||input.charAt(input.length()-2) == '/')
					{
						operator=0;
						input = input.substring(0, input.length()-2);
					}
					else 													//if the second last character was not an operator then the white space must have been created by the 
					{														//end of a calculation.so we calculate the length of the result string add 1 for the while space 
																			//and add 1 for the equal sign and one because of the substring rule, and we display all the text in the text 
						int noshow = results.length() + 1 + 1 +1;			//area except the result and the equal sign. we then can start a new calculation in the new line.
						input = input.substring(0, input.length()-noshow) + "\n";
						
					}
				}
				
				else { 										//if it is a number we check which number is being constructed and we reduce that last character from that number 
															// then display
					if(num2.length()<1) 
						num1=num1.substring(0, num1.length()-1);
					else 
						num2=num2.substring(0, num2.length()-1);
					input = input.substring(0, input.length()-1);
				}
				
				

				resultarea.setText(input);
				
				
			}
			
			if(event.getSource()==clearall) {     //when this button id clicked, all the text area will we cleared (we set it to an empty string)
				input="";						// and all the variables participating in the calculation will set "" or 0 like as they were at the beginning
				num1="";
				num2="";
				results="";
				result=0;
				num1d=0;num2d=0;
				resultarea.setText(input);
				
			}
			
			
			
		}
		
	}
	
	public JPanel createButtons() //creating two buttons, clear last and clear all and adding an action listener to each 
	{								//so that when clicked proper action will be performed when actionPerformed method is invoked.
		clearlast = new JButton("Clear Last");
		clearall = new JButton("Clear All");
		listener = new buttonListener();
		clearlast.addActionListener(listener);
		clearall.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(clearlast);
		panel.add(clearall);
		
		return panel;
		
	}
	
	public JPanel createTextArea()  //creating a text area that use cannot access its content directly.
	{
		resultarea = new JTextArea(AREA_ROWS,AREA_COLUMNS);
		JScrollPane scrollpane = new JScrollPane(resultarea);
		resultarea.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scrollpane, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel createNumberButtons()
	{
		button7 = new JButton("7");     //creating calculating buttons
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonsum = new JButton("+");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		buttonmin = new JButton("-");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		buttonmul = new JButton("*");
		button0 = new JButton("0");
		buttondec = new JButton(".");
		buttonequ = new JButton("=");
		buttondiv = new JButton("/");
		
		buttonlist.add(button0);
		buttonlist.add(button1);
		buttonlist.add(button2);
		buttonlist.add(button3);
		buttonlist.add(button4);
		buttonlist.add(button5);
		buttonlist.add(button6);
		buttonlist.add(button7);
		buttonlist.add(button8);
		buttonlist.add(button9);
		buttonlist.add(buttonsum);
		buttonlist.add(buttonmin);
		buttonlist.add(buttonmul);
		buttonlist.add(buttondiv);
		buttonlist.add(buttondec);
		buttonlist.add(buttonequ);

		
		JPanel panel = new JPanel();		//creating a 4 by 4 grid layout for the panel and adding the buttons in the order we want
		panel.setLayout(new GridLayout(4,4)); 
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonsum);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonmin);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(buttonmul);
		panel.add(button0);
		panel.add(buttondec);
		panel.add(buttonequ);
		panel.add(buttondiv);
			
		
		for (JButton button : buttonlist)
			button.addActionListener(listener);
				
		return panel;
		
	}
	
	
	public void calculate()								//when the calculate method is called, we transform strings num1 and num2 to double values													
	{													//and according to the value of the operator, the appropriate calculation is done
		
			number1 = Double.parseDouble(num1);
			number2 = Double.parseDouble(num2);
		
			if(operator==1)
				result=number1+number2;
			else if(operator==2)
				result=number1-number2;
			else if(operator==3)
				result=number1*number2;
			else if(operator==4) 
			{
				if (number2==0)									//if an illegal division is being done(ie dividing by zero), an error massage is displayed in the 
				{												//text area and the calculation will not be done. instead the first number will be displayed as result.
					resultarea.append("\nIllegal Operation!");
					result = number1;
				}
				else
				result=number1/number2;
			}
		
		
		resultarea.append("=\n" + result + "\n");
		
		num1="";	//after the calculation is done, we set every thing to "" and 0 to begin a new calculation
		num2="";
		operator=0;
		results = "" + result;
		num1d=0;num2d=0;
		
	}
	
	
	

}
