package Starting;

import java.io.*;
import javax.swing.JOptionPane;

public class FileHandling {

	private String path;
	private File file ;
	FileHandling(String path)
	{
		this.path =path; 
	}
	
	boolean open()
	{
		if(path==null)
		{
			JOptionPane.showMessageDialog(null,"Invalid path");
			return false;
		}
		file = new File(path);
		if(!file.exists())
		{
			JOptionPane.showMessageDialog(null,"Path doest not exist");
			return false;
		}
		if(!file.isDirectory())
		{
			JOptionPane.showMessageDialog(null,"Only directory are allowed");
			return false;
		}
		String name  = JOptionPane.showInputDialog("Please enter file name");
		if(name==null||name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please provide Proper name");
			return false;
		}
		name = name.trim();
		if(name.endsWith(".java"))
		{}
		else
			name=name+".java";
		path = path+"\\"+name;
		file = new File(path);
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
				JOptionPane.showMessageDialog(null, "File sucessfully Created");
				CommonReference.setFile(file);
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Operation failed");
				return false;
			}
		}
		else
		{
			CommonReference.setFile(file);
			JOptionPane.showMessageDialog(null, "File already exist opened that file");
		}
		CommonReference.setFile(file);
		return true;
	}
	
	boolean update()
	{
		if(path==null)
		{
			JOptionPane.showMessageDialog(null, "Please select Proper Path");
			return false;
		}
		file = new File(path);
		if(!file.exists())
		{
			JOptionPane.showMessageDialog(null,"File does not exist");
			return false;
		}
		if(!file.isFile())
		{
			JOptionPane.showMessageDialog(null, "Only files are allowed");
			return false;
		}
		if(!file.getName().endsWith(".java"))
		{
			JOptionPane.showMessageDialog(null, "Only java source files are allowed");
			return false;
		}
		CommonReference.setFile(file);
		JOptionPane.showMessageDialog(null, "File open sucess");
		return true;
		
	}
}
