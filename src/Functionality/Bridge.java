package Functionality;

import java.awt.Dimension;

import Starting.CommonReference;

public class Bridge {
	
	static public void callTime()
	{
		new Time();
	}
	
	static public void undo(String s)
	{
		new UndoRedo(s);
	}
	static public void undoRedo()
	{
		new UndoRedo();
	}
	static public void screenShot()
	{
		new ScreenShot(new Dimension(CommonReference.getJFrame().getSize()));
	}
	static public void maleSpeak()
	{
		
		new Speak("kevin16",CommonReference.getJTextPaneCode().getText());
	}
	static public void femaleSpeak()
	{
		new Speak(CommonReference.getJTextPaneCode().getText(),"Alan");
	}
	static public void calculator()
	{
		new Calculator();
	}
	static public void colorChooser()
	{
		new ColorChooser();
	}
	static public void NumberConverter()
	{
		new NumberConverter();
	}
	static public void StopWatch()
	{
		new Stop();
	}
	
}
