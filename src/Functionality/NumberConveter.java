package Functionality;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
class NumberConverter implements KeyListener {
	
	JFrame frame;
	JLabel binarylabel;
	JLabel octallabel;
	JLabel decimallabel;
	JLabel hexlabel;
	JLabel heading;
	JTextField binary;
	JTextField octal;
	JTextField decimal;
	JTextField hex;
	NumberConverter()
	{
		frame = new JFrame("Number Converter");
		
		heading = new JLabel("Number Converter");
		
		binarylabel = new JLabel("Binary");
		octallabel = new JLabel("Octal");
		decimallabel = new JLabel("Decimal");
		hexlabel = new JLabel("HexaDecimal");
		
		binary = new JTextField();
		octal = new JTextField();
		decimal = new JTextField();
		hex = new JTextField();
		
		
		setProperties();
		setBounds();
		addElements();
		
	}	
	void setProperties()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		heading.setFont(new Font("Comic Sans ms",Font.ITALIC,18));
		
		binary.addKeyListener(this);
		octal.addKeyListener(this);
		decimal.addKeyListener(this);
		hex.addKeyListener(this);
		
	}
	void setBounds()
	{
		frame.setSize(300,300);
		
		heading.setBounds(70, 30, 160, 20);
		binarylabel.setBounds(70,70,40,20);
		binary.setBounds(120,70,80,20);
		octallabel.setBounds(70,110,40,20);
		octal.setBounds(120,110,80,20);
		decimallabel.setBounds(60,150,50,20);
		decimal.setBounds(120,150,80,20);
		hexlabel.setBounds(30,190,75,20);
		hex.setBounds(120,190,80,20);
		
	}
	void addElements()
	{
		frame.add(heading);
		frame.add(binarylabel);
		frame.add(binary);
		frame.add(octallabel);
		frame.add(octal);
		frame.add(decimallabel);
		frame.add(decimal);
		frame.add(hexlabel);
		frame.add(hex);
	}
	
	
	@Override
	public void keyPressed(KeyEvent ae) {
		
	
		
	}
	@Override
	public void keyReleased(KeyEvent ae) {
		try{
		boolean noissue = true;
		String text ="" ; 
		int no =0;
		if(ae.getSource()==hex)
		{
			text = hex.getText().trim().toString();
			if(text.equals(""))
			{
				return;
			}
			no = 16;
			for(int i=0;i<text.length();i++)
			{
				char a = text.charAt(i);
				if(!((a>='a'&&a<='f')||(a>='A'&&a<='F')||(a>='0'&&a<='9')))
				{
					noissue = false;
					break;
				}
			}
			
		}
		else if(ae.getSource()==decimal)
		{
			text = decimal.getText().trim().toString();
			if(text.equals(""))
			{
			
				return;
			}
			no  = 10;
			for(int i=0;i<text.length();i++)
			{
				char a = text.charAt(i);
				if(!(a>='0'&&a<='9'))
				{
					noissue = false;
					break;
				}
			}
		}
		else if(ae.getSource()==octal)
		{
			text = octal.getText().trim().toString();
			if(text.equals(""))
			{
				return;
			}
			no = 8;
			
			for(int i=0;i<text.length();i++)
			{
				char a = text.charAt(i);
				if(!(a>='0'&&a<='8'))
				{
					noissue = false;
					break;
				}
			}
		}
		else if(ae.getSource()==binary)
		{
			text = binary.getText().trim().toString();
			if(text.equals(""))
			{
				return;
			}
			no = 2;
		
			for(int i=0;i<text.length();i++)
			{
				char a = text.charAt(i);
				if(!(a>='0'&&a<='1'))
				{
					noissue = false;
					break;
				}
			}
		}
		if(noissue)
		{
			int a = Integer.parseInt(text,no);
			binary.setText(Integer.toBinaryString(a));
			octal.setText(Integer.toOctalString(a));
			decimal.setText(a+"");
			hex.setText(Integer.toHexString(a));
		}
		else
		{
			binary.setText("");
			decimal.setText("");
			octal.setText("");
			hex.setText("");
		}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Sorry out of range");
			binary.setText("");
			decimal.setText("");
			octal.setText("");
			hex.setText("");
			
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent ae) {
		
	}
	
	

}
