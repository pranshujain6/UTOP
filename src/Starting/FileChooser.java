package Starting;
import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class FileChooser extends JPanel{
    
	private static final long serialVersionUID = 1L;
	private JFileChooser fc;

    
   public FileChooser() {
        super(new BorderLayout());
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);        
    }

   
    String call() {
    		int returnVal = fc.showOpenDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile();
                if(file==null)
                {	
                	JOptionPane.showMessageDialog(this, "Please Select Proper Path");
                	return null;
                }
                return file.getPath();
            } 
            else 
            {
                return null;
            }
      }    
}