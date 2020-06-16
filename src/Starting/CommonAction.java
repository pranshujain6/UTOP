package Starting;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import Functionality.Bridge;
import java.io.*;

import javax.swing.JOptionPane;

import javax.swing.event.CaretEvent;
import javax.swing.text.Element;
public class CommonAction {
	
	
	static void caretUpdate(CaretEvent ce) 
	 {
    	int pos = CommonReference.getJTextPaneCode().getCaretPosition();
        Element map = CommonReference.getJTextPaneCode().getDocument().getDefaultRootElement();
        int row = map.getElementIndex(pos);
        Element lineElem = map.getElement(row);
        int col = pos - lineElem.getStartOffset();        
        CommonReference.getJLabelRowStatus().setText(""+row);
        CommonReference.getJLabelColStatus().setText(""+col);  
    }
	
	static void  keyPressedCallFunction(KeyEvent ke)
	{
		int key = ke.getKeyCode();
		if(ke.isControlDown()&&key==KeyEvent.VK_Z)
		{
			Bridge.undo("undo");
		}
		else if(ke.isControlDown()&&key==KeyEvent.VK_Y)
		{
			Bridge.undo("redo");
		}
	}
	
	static void keyReleased(KeyEvent ke)
	{
		writeToFile();
		String s = CommonReference.getJTextPaneCode().getText().trim();
		CommonReference.getJLabelWordCount().setText(s.split(" ").length+"");
		
	}
	
	static void writeToFile()
	{
		
		File file = CommonReference.getFile();
		if(file!=null)
		{
			String s = CommonReference.getJTextPaneCode().getText().toString().trim();
			try{
				FileOutputStream fout = new FileOutputStream(file);
				for(int i=0;i<s.length();i++)
				{
					fout.write((s.charAt(i)));
				}
				fout.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Auto save creating problem");
			}
		}
	}
	
	static void newBeginningWithExist()
	{
		
		CommonReference.getJTextPaneCode().setEnabled(false);
		CommonReference.getJTextPaneCode().setText("");
		CommonReference.getJLabelFileName().setText("No file Selected");
	}
	
	static void saveNewStatus(String[] arr)
	{
		try {
			String fontname = arr[0];
			String fonttype = arr[1];
			String fontsize = arr[2];
			String checkbox = arr[3];
			String line = fontname+" , "+fonttype+" , "+fontsize+" , "+checkbox;
			BufferedWriter bf = new BufferedWriter(new FileWriter(CommonReference.getStatusFile().getAbsoluteFile()));
			bf.write(line);
			bf.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Resource does not found software may misbehave");
		}
	}
	static String[] getValueStatus() 
	{
		try {
			File f = CommonReference.getStatusFile();
			BufferedReader bf  = new BufferedReader(new FileReader(f.getAbsoluteFile()));
			String line = bf.readLine();
			String a [] = line.split(",");
			
			bf.close();
			return a;
		}
		catch(Exception e)
		{
			String a[] = {"Arial","0","16","true"};
			JOptionPane.showMessageDialog(null, "Resource data file not found"+e);
			return a;
		}
	}
	
}
