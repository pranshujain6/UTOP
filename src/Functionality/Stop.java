package Functionality;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
class Stop implements ActionListener ,Runnable {
	JFrame frame;
	JLabel time;
	JButton start;
	JButton stop;
	JButton reset;
	JLabel heading; 
	
	int hours = 0 ;
	int minutes = 0;
	int seconds = 0;

	
	Thread t; 
	
	
	Stop()
	{
		frame  = new JFrame();
		time = new JLabel("00:00:00:00");
		
		start = new JButton("Start");
		stop = new JButton("Stop");
		reset = new JButton("Reset");
		
		heading = new JLabel("StopWatch");
		 t = new Thread(this);
		
		addElements();
		setProperties();
		setBounds();
	}
	
	void setProperties()
	{
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		time.setFont(new Font("Arial",Font.BOLD,16));
		
		start.addActionListener(this);
		stop.addActionListener(this);
		reset.addActionListener(this);
		
	}
	void setBounds()
	{
		frame.setSize(300,300);
		
		heading.setBounds(100, 30, 100, 30);
		
		time.setBounds(100,100,100,20);
		start.setBounds(20,140,70,30);
		stop.setBounds(100,140,70,30);
		reset.setBounds(180,140,70,30);
		
	}
	void addElements()
	{
		frame.add(time);
		frame.add(start);
		frame.add(stop);
		frame.add(reset);
		frame.add(heading);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==start)
		 {
			if(t.getState()==Thread.State.NEW)
			 t.start();
			else
				t.resume();
		 }
		 else if(ae.getSource()==stop)
			 t.suspend();
		 else if(ae.getSource()==reset)
		 {
			 hours  =0;
			 seconds = 0;
			 minutes = 0;
			 time.setText("00:00:00");
			 t.suspend();
		 }
		 
		
	}
	
	public void run()
	{
		try {  
	         while (true) {  
	  
	            seconds++;
	            if(seconds>60)
	            {
	            	seconds=0;
	            	minutes++;
	            }
	            if(minutes>60)
	            {
	            	hours++;
	            	minutes=0;
	            }
	           String h ="",m="",s = "";
	           if(hours<10)
	        	   h="0"+hours;
	           else
	        	   h = hours+"";
	           if(minutes<10)
	        	   m="0"+minutes;
	           else
	        	   m=minutes+"";
	           if(seconds<10)
	        	   s="0"+seconds;
	           else
	        	   s=seconds+"";
	  
	           time.setText(h+":"+m+":"+s);
	  
	            Thread.sleep( 1000 );    
	         }
		 }
	         catch(Exception e)
	         {
	        	 JOptionPane.showMessageDialog(null, "Problem in executing StopWatch");
	         }
	}
	
	public static void main(String[] args)
	{
		new Stop();
	}

}
