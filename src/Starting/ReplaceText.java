package Starting;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.Document;

import java.awt.event.*;

class ReplaceText implements ActionListener 
{
	private static JFrame parentJFrame;
    private static JTextField jTextField ;
    private static JDialog jDialog;
    private static JButton findNext;
    private static JButton Cancel;
    private static JCheckBox matchCase ;
    private static JTextField jTextFieldWith ;
    private static JButton replace;
    private static JButton replaceAll;
    
    private static JTextPane jTextPaneCode;
    
    
    ReplaceText()
    {
    	parentJFrame=CommonReference.getJFrame();
    	jDialog=new JDialog(parentJFrame,"Find");
        jTextField =new JTextField();
        findNext=new JButton("Find Next");
        Cancel=new JButton("cancel");
        matchCase=new JCheckBox("Match Case");
        jTextFieldWith =new JTextField();
        replace=new JButton("Replace");
        replaceAll=new JButton("Replace All"); 
            
        jDialog.setVisible(true);
        jDialog.setSize(450,190);
        jDialog.setLayout(null);
        
        jDialog.add(jTextField);
        jDialog.add(findNext);
        jDialog.add(jTextFieldWith);
        jDialog.add(replace);
        jDialog.add(replaceAll);
        jDialog.add(Cancel);
        jDialog.add(matchCase);
        
        replace.setEnabled(false);
        jTextField.setBounds(20,20,250,25);
        findNext.setBounds(300,20,110,25);
        matchCase.setBounds(20,110,95,25);
        Cancel.setBounds(300,130,110,25);
        jTextFieldWith.setBounds(20,60,250,25);       
        replace.setBounds(300,60,110,25);
        replaceAll.setBounds(300,95,110,25);
        
        jDialog.setLocationRelativeTo(null);
        jDialog.setIconImage((Image)null);
        jDialog.setResizable(false);
        jDialog.setAlwaysOnTop(true);
        addListeners();
        jTextPaneCode=CommonReference.getJTextPaneCode();
    }
    
    private void  addListeners()
    {
    	replaceAll.addActionListener(this);
    	Cancel.addActionListener(this);
    	matchCase.addActionListener(this);
    	replace.addActionListener(this);
    	findNext.addActionListener(this);
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==replaceAll && matchCase.isSelected())
        {
        	jTextPaneCode.setText(jTextPaneCode.getText().replaceAll(jTextField.getText(), jTextFieldWith.getText()));
        }
        
        if(e.getSource()==replaceAll && !matchCase.isSelected())
        {	
        	jTextPaneCode.setText(jTextPaneCode.getText().replaceAll(jTextField.getText().toLowerCase(), jTextFieldWith.getText()));
            jTextPaneCode.setText(jTextPaneCode.getText().replaceAll(jTextField.getText().toUpperCase(), jTextFieldWith.getText()));
        
        }
       
        if(e.getSource()==Cancel)
        {
        	jDialog.dispose();
        }
        
        if(e.getSource()==replace)
        {
        	String text=jTextPaneCode.getText();
        	int selectEnd=jTextPaneCode.getSelectionEnd();
           	jTextPaneCode.setText(text.substring(0,jTextPaneCode.getSelectionStart())+jTextFieldWith.getText()+text.substring(selectEnd));
            jTextPaneCode.setCaretPosition(selectEnd-jTextField.getText().length()+jTextFieldWith.getText().length());
            replace.setEnabled(false);
        }
        
        if(e.getSource()==findNext)
        {
         	
        	search();
        }
    }
    
    public  void search()
    {
    	
    	try
    	{
    		int pos;
    	 Document doc=jTextPaneCode.getDocument();
    	 String text;
    	 pos=jTextPaneCode.getCaretPosition();
    		
    	
    	 if( matchCase.isSelected())
    	 {   
    		
    		 int len=doc.getText(0, pos).length();
    		text=doc.getText(pos, doc.getLength()-pos);  
    		
    		if((pos=text.indexOf(jTextField.getText()))>=0)
    		 {
    			 jTextPaneCode.select(len+pos, len+pos+jTextField.getText().length()); 		 
    		 } 
    		else
   		 {
   			 JOptionPane.showMessageDialog(jDialog, "can not find  \" "+jTextField.getText()+" \" ","UTOP", JOptionPane.WARNING_MESSAGE);
   			 
   		 }
    	 }
    	 
    	 if(!matchCase.isSelected())
    	 {   
    	     int len=doc.getText(0, pos).length();
    		 text=doc.getText(pos, doc.getLength()-pos);
    		
    		 if((pos=text.toLowerCase().indexOf(jTextField.getText().toLowerCase()))>=0)
    		 {
    			 jTextPaneCode.select(len+pos, len+pos+jTextField.getText().length());
    			 replace.setEnabled(true);
    		 }
    		 else
    		 {
    			 JOptionPane.showMessageDialog(jDialog, "can not find  \" "+jTextField.getText()+" \" ","UTOP", JOptionPane.WARNING_MESSAGE);
    			 
    		 }
    	 }
    	}
    	 catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }

}
