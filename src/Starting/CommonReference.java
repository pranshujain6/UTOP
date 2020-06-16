package Starting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.io.*;
public class CommonReference {
	
	private static JTextPane jTextPaneCode; 
	
	private static JLabel jLabelTime;
	
	private static JCheckBox jCheckBoxColorTheme;
	
	private static JPanel jPaneltwo;
	
	private static JFrame jFrame;
	
	private static JLabel jLabelRowStatus;
	private static JLabel jLabelColStatus;
	
	private static File file;
	
	private static JLabel jLabelFileName;
	
	private static JLabel jLabelWordCount;
	
	private static File statusFile;
	
	public static void setStatusFile(File file)
	{
		statusFile = file;
	}
	public static File getStatusFile()
	{
		return statusFile;
	}
	
	
	public static void setJLabelWordCount(JLabel wordCount)
	{
		jLabelWordCount = wordCount;
	}
	
	public static JLabel getJLabelWordCount()
	{
		return jLabelWordCount;
	}
	
	public static void setJLabelFileName(JLabel fileName)
	{
		jLabelFileName = fileName;
	}
	public static JLabel getJLabelFileName()
	{
		return jLabelFileName;
	}
	
	public static void setFile(File file)
	{
		CommonReference.file = file;
	}
	public static File getFile()
	{
		return file;
	}
	public static void setJTextPaneCode(JTextPane code)
	{
		jTextPaneCode = code;
	}
	public  static JTextPane getJTextPaneCode()
	{
		return jTextPaneCode;
	}
	public static void setJLabelTime(JLabel time)
	{
		jLabelTime = time;
	}
	public static JLabel getJLabelTime()
	{
		return jLabelTime;
	}
	public static void setJCheckBoxColorTheme(JCheckBox checkbox)
	{
		jCheckBoxColorTheme = checkbox;
	}
	public static JCheckBox getJCheckBoxColorTheme()
	{
		return jCheckBoxColorTheme;
	}
	
	public static void setJPanel2(JPanel jpanel)
	{
		jPaneltwo = jpanel;
	}
	public static JPanel getJPanel2()
	{
		return jPaneltwo;
	}
	
	public static void setJFrame(JFrame jf)
	{
		jFrame = jf;
	}
	public static JFrame getJFrame()
	{
		return jFrame;
	}
	public static void setJLabelRowStatus(JLabel row)
	{
		jLabelRowStatus = row;
	}
	public static JLabel getJLabelRowStatus()
	{
		return jLabelRowStatus;
	}
	
	public static void setJLabelColStatus(JLabel col)
	{
		jLabelColStatus= col;
	}
	public static JLabel getJLabelColStatus()
	{
		return jLabelColStatus;
	}

}
