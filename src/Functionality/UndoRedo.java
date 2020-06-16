package Functionality;
import java.util.*;
import javax.swing.JTextPane;

import Starting.CommonReference;
public class UndoRedo implements Runnable {
	
	static private Stack<String> undoStack= Data.undoStack;
	static private Stack<String> redoStack= Data.redoStack;
	static private JTextPane jTextPaneCode= CommonReference.getJTextPaneCode();
	
	UndoRedo()
	{
		new Thread(this).start();
	}
	
	public void run()
	{
		while(true)
		{
			try{
				if(!undoStack.empty())
				{
					if(!(undoStack.peek().equals(jTextPaneCode.getText().trim())))
						undoStack.push(jTextPaneCode.getText().toString().trim());
				}
				else
				{
					undoStack.push(jTextPaneCode.getText().toString().trim());
					
				}
				Thread.sleep(3000);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	UndoRedo(String s)
	{
		if(s.equals("undo"))
		{
			undo();
		}
		else
		{
			redo();
		}
	}
	private void redo()
	{
		if(!redoStack.empty())
			jTextPaneCode.setText(redoStack.pop());
	}
	private void undo()
	{
		if(!undoStack.empty())
		{
			String print = jTextPaneCode.getText().trim();
			redoStack.push(print);
			jTextPaneCode.setText(undoStack.pop());
			
		}
	}
	

}
