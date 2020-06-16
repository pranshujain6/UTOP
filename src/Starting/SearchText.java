package Starting;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;


class SearchText extends FocusAdapter implements ActionListener
{
	private static JFrame parentJFrame;
    private static JTextField jTextField ;
    private static JDialog jDialog;
    private static JButton findNext;
    private static JButton Cancel;
    private static JCheckBox matchCase ;
    private static JRadioButton up;
    private static JRadioButton down;
    private static JTextPane  jTextPaneCode ;
    private static int c1;   // c1 holds the value for next upward search 
    private int pos;
    
    SearchText()
    {
    	parentJFrame=CommonReference.getJFrame();
    	jDialog=new JDialog(parentJFrame,"Find");
        jTextField =new JTextField();
        findNext=new JButton("Find Next");
        Cancel=new JButton("cancel");
        matchCase=new JCheckBox("Match Case");
        up=new JRadioButton("up",true);
        down=new JRadioButton("down");        
        jTextPaneCode =CommonReference.getJTextPaneCode();
        
        ButtonGroup jButtonGroup=new ButtonGroup();
        jButtonGroup.add(up);
        jButtonGroup.add(down);
                
        JPanel jDirectionPanel=new JPanel();
                
        jDirectionPanel.setLayout(new FlowLayout());
        jDirectionPanel.setBorder(BorderFactory.createTitledBorder("Direction"));
        jDirectionPanel.add(up);
        jDirectionPanel.add(down);
                
        jDialog.setVisible(true);
        jDialog.setSize(450,190);
        jDialog.setLayout(null);
       
        jDialog.add(jTextField);
        
        jDialog.add(findNext);
        jDialog.add(Cancel);
        jDialog.add(matchCase);
        jDialog.add(jDirectionPanel);
        
        jTextField.setBounds(20,20,250,25);
        findNext.setBounds(300,20,110,25);
        matchCase.setBounds(20,100,95,25);
        Cancel.setBounds(300,70,110,25);
       
        jDirectionPanel.setBounds(125,70,150,50);       
               
        jDialog.setLocationRelativeTo(null);
        jDialog.setIconImage((Image)null);
        jDialog.setResizable(false);
        jDialog.setAlwaysOnTop(true);
        
        addListeners();
    }
    
    private  void addListeners()
    {
    	findNext.addActionListener(this);
    	Cancel.addActionListener(this);
    	up.addActionListener(this);
    	down.addActionListener(this);
    	matchCase.addActionListener(this);
    	
    	jTextPaneCode.addFocusListener(new FocusAdapter(){ 
    		public void focusLost(FocusEvent e)
    		{
    			c1=pos=jTextPaneCode.getCaretPosition(); 
    		} 
    		
    	    });
    	
    	c1=jTextPaneCode.getText().length();
    }
    
  
    public void actionPerformed(ActionEvent e)
    {
    	
    	if(e.getSource()==Cancel )
    	{
    		jDialog.dispose();
    	}
    	else if(e.getSource()==findNext)
    	{
    		search();
    	}
    	
    }
    
    public  void search()
    {
    	
    	try
    	{
    	 
    	 Document doc=jTextPaneCode.getDocument();
    	 String text;
    	 pos=jTextPaneCode.getCaretPosition();
    		
    	 if(up.isSelected() && matchCase.isSelected())
    	 {   
    		 
    		 if(c1<pos)
    		   {
    			 pos=c1 ;
    			 
    		   }
    	 
    		 text=doc.getText(0, pos);
    		 if((pos=text.lastIndexOf(jTextField.getText()))>=0)
    		 {
    			 jTextPaneCode.select(pos, pos+jTextField.getText().length());
    			 c1=pos;
    				 
    		 }
    		 else
    		 {
    			 JOptionPane.showMessageDialog(jDialog, "can not find  \" "+jTextField.getText()+" \" ","UTOP", JOptionPane.WARNING_MESSAGE);
    			 
    		 }
    		
    	 }
    	 
    	 if(up.isSelected() && !matchCase.isSelected())
    	 {
    		 if(c1<pos)
      		   pos=c1 ;
    		 
    		 text=doc.getText(0, pos);
    		 if((pos=text.toLowerCase().lastIndexOf(jTextField.getText().toLowerCase()))>=0)
    		 {
    			 jTextPaneCode.select(pos, pos+jTextField.getText().length());
    				 
    			 c1=pos;
    		 }
    		 else
    		 {
    			 JOptionPane.showMessageDialog(jDialog, "can not find  \" "+jTextField.getText()+" \"  "," UTOP ", JOptionPane.WARNING_MESSAGE);
    			 
    		 }
    	 }
    	 
    	
    	 if(down.isSelected() && matchCase.isSelected())
    	 {   c1=pos;
    	     
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
    	 
    	 if(down.isSelected() && !matchCase.isSelected())
    	 {   c1=pos;
    	     
    	     int len=doc.getText(0, pos).length();
    		 text=doc.getText(pos, doc.getLength()-pos);
    		// System.out.println(text);
    		 if((pos=text.toLowerCase().indexOf(jTextField.getText().toLowerCase()))>=0)
    		 {
    			 jTextPaneCode.select(len+pos, len+pos+jTextField.getText().length());
    			
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
    

 

