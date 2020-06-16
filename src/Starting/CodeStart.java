package Starting;




public class CodeStart {
	void newFile() 
	{		
		CommonReference.getJTextPaneCode().setEnabled(true);
		CommonReference.getJLabelFileName().setText(CommonReference.getFile().getName());
	}
	void existingFile() 
	{
		CommonReference.getJTextPaneCode().setEnabled(true);	
		CommonReference.getJLabelFileName().setText(CommonReference.getFile().getName());
	}

}
