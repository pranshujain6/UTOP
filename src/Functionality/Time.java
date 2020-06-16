package Functionality;

import Starting.CommonReference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time implements Runnable{
	int hours=0, minutes=0, seconds=0;  
	String timeString = "";  
	Time()
	{
		new Thread(this).start();
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
	  
	        
	           timeString = h+":"+m+":"+s;
	  
	            printTime();  
	  
	            Thread.sleep( 1000 );    
	         }  
	      }  
	      catch (Exception e) { }  
	}
	void printTime()
	{
		CommonReference.getJLabelTime().setText(timeString);
	}
}
