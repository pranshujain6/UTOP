package Functionality;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


class ColorChooser implements ActionListener
{
	private JColorChooser chooser;
	private Color color;
	private JFrame frame;
	private JButton button;
	JLabel hexl1,hexl2,hexl3;
	JLabel rgbl1,rgbl2,rgbl3;
	JLabel hex , rgb;
	JTextField hex1 , hex2 , hex3 ;
	JTextField rgb1, rgb2, rgb3;
	ColorChooser()
	{
	     chooser = new JColorChooser();
	     frame= new JFrame();
	     button = new JButton("Color Chooser");
	     
	     hex = new JLabel("Hex values");
	     rgb = new JLabel("RGB values");
	     
	     hexl1 = new JLabel("Red");
	     hexl2 = new JLabel("Green");
	     hexl3 = new JLabel("Yellow");
	     
	     rgbl1 = new JLabel("Red");
	     rgbl2 = new JLabel("Green");
	     rgbl3 = new JLabel("Yellow");
	     
	     hex1 = new JTextField();
	     hex2 = new JTextField();
	     hex3 = new JTextField();
	     
	     rgb1 = new JTextField();
	     rgb2 = new JTextField();
	     rgb3 = new JTextField();
	     
	     setProperties();
	     setBounds();
	     addElements();
	     }
	private void setBounds()
	{
		frame.setSize(550,550);
		hex.setBounds(250, 20, 100, 30);
		hexl1.setBounds(200, 70, 50, 30);
		hex1.setBounds(250,70,100,30);
		hexl2.setBounds(200,120,50,30);
		hex2.setBounds(250,120,100,30);
		hexl3.setBounds(200,170,50,30);
		hex3.setBounds(250,170,100,30);
		rgb.setBounds(250,230, 100, 30);
		rgbl1.setBounds(200,280,50,30);
		rgb1.setBounds(250, 280, 100, 30);
		rgbl2.setBounds(200,330,50,30);
		rgb2.setBounds(250,330,100,30);
		rgbl3.setBounds(200,380,50,30);
		rgb3.setBounds(250,380,100,30);
		button.setBounds(200,430,200,30);
	}
	private void addElements()
	{
		frame.add(hex);
		frame.add(hexl1);
		frame.add(hex1);
		frame.add(hexl2);
		frame.add(hex2);
		frame.add(hexl3);
		frame.add(hex3);
		frame.add(rgb);
		frame.add(rgbl1);
		frame.add(rgb1);
		frame.add(rgbl2);
		frame.add(rgb2);
		frame.add(rgbl3);
		frame.add(rgb3);
		frame.add(button);
	}

	private void setProperties()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		chooser.setVisible(false);
		button.addActionListener(this);
		
		hex1.setEnabled(false);
		hex2.setEnabled(false);
		hex3.setEnabled(false);
		rgb1.setEnabled(false);
		rgb2.setEnabled(false);
		rgb3.setEnabled(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
		 color = chooser.showDialog(chooser, "SHOW THE COLOR", chooser.getColor());
         {
             if(color!= null)
             {
                
                 hex1.setText(Integer.toHexString(color.getRed()));
                 hex2.setText(Integer.toHexString(color.getGreen()));
                 hex3.setText(Integer.toHexString(color.getBlue()));
                 rgb1.setText(color.getRed()+"");
                 rgb2.setText(color.getGreen()+"");
                 rgb3.setText(color.getBlue()+"");
            }

         }
	}
	
}


