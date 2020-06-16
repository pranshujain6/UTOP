package Starting;

import java.awt.Color;


import javax.swing.JTextPane;



class ColorChange {
	
	static void changeColor()
	{
		
		boolean value = CommonReference.getJCheckBoxColorTheme().isSelected();
		if(value)
		{
			// change status in external file
			String a[] = CommonAction.getValueStatus();
			a[3] = "true";
			CommonAction.saveNewStatus(a);
			//Done
			
			CommonReference.getJTextPaneCode().setBackground(new Color(255,255,255));
		    CommonReference.getJTextPaneCode().setCaretColor(new Color(50,50,50));
			
		}
		else
		{
			
			JTextPane textPane = CommonReference.getJTextPaneCode();
			
			// change status in external file
			String a[] = CommonAction.getValueStatus();
			a[3] = "false";
			CommonAction.saveNewStatus(a);
			//Done
			
			textPane.setBackground(new Color(50,50,50));
		    CommonReference.getJTextPaneCode().setCaretColor(new Color(255,255,255));
		}
	}
}
