package Starting;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


// This class Fontchange has been written separately just for making it easy to everyone who sees the code ...
 


class FontChange  extends WindowAdapter implements ActionListener
{                
                 Font font ;
                 private static JFrame parentJFrame;
                 private static JTextPane jTextPanecode ;
                 private static JDialog jDialog;
                 private static JComboBox<String> jcombobox_font;
                 private static JComboBox<String> jcombobox_font_style;
                 private static JComboBox<String> jcombobox_size;
                 private static JButton OK;
                 private static JButton Cancel;
                 
	       FontChange(JTextPane code)
                  {    
	    	            parentJFrame=CommonReference.getJFrame();
	    	            jDialog=new JDialog(parentJFrame,"Style");
                        parentJFrame.setEnabled(false);
                         
                         jTextPanecode=code;
                        GraphicsEnvironment graphicsenvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
                       
	       
                       jcombobox_font=new JComboBox<String>(graphicsenvironment.getAvailableFontFamilyNames()); 
                       jcombobox_font_style=new JComboBox<String>(new String[]{"plain","bold","italic","bold italic"}); 
                       jcombobox_size=new JComboBox<String>(new String[]{"8","9","10","11","12","14","16","18","20","22","24","26","28","30"});
                     
                       OK=new JButton("OK");
                       Cancel=new JButton("Cancel");
                       jDialog.add(OK);
                       jDialog.add(Cancel);
                                      
                       jDialog.add( jcombobox_font);
                       
                       jDialog.add(jcombobox_font_style);	
                       jDialog.add(jcombobox_size);
                       jDialog.setVisible(true);
                       jDialog.setSize(300,300);
                       jDialog.setLayout(null);
                       
                       jcombobox_font.setBounds(20,10,200,20);
                       jcombobox_font_style.setBounds(20,50,200,20);
                       jcombobox_size.setBounds(20,90,200,20);
                       Cancel.setBounds(170,230,100,20);
                       OK.setBounds(50,230,100,20);
                       
                       jDialog.addWindowListener(this);
                       OK.addActionListener(this);
                       Cancel.addActionListener(this);  
                       jDialog.setLocationRelativeTo(null);
                       jDialog.setAlwaysOnTop(true);
                       
                       // Setting all combo to last entered values
                       String[] a = CommonAction.getValueStatus();
                       String font = a[0];
                       String type = a[1];
                       String size = a[2];
                       
                       jcombobox_font.setSelectedItem(a[0]);
                       jcombobox_font_style.setSelectedItem(a[1]);
                       jcombobox_size.setSelectedItem(a[2]);
                       
              
                       
                       
                       //Done
                  }   

            public void windowClosing(WindowEvent e)
                  {
            	parentJFrame.setEnabled(true);                     
	 }

            public void actionPerformed(ActionEvent e)
                 {
                    if(e.getSource()==OK)
                        {
                             int style;
                              
                             if(jcombobox_font_style.getSelectedItem().toString().equals("plain"))
                                style=Font.PLAIN;
                             else if(jcombobox_font_style.getSelectedItem().toString().equals("bold"))
                                style=Font.BOLD;
                             else if(jcombobox_font_style.getSelectedItem().toString().equals("bold italic"))
                                style=Font.BOLD+Font.ITALIC ;
                             else
                                style=Font.ITALIC;
                                
                            font=new Font( jcombobox_font.getSelectedItem().toString(),style,Integer.parseInt( jcombobox_size.getSelectedItem().toString())); 
                            jTextPanecode.setFont(font);    
                            
                             
                           String[] a = CommonAction.getValueStatus();
                           
                            a[0] = jcombobox_font.getSelectedItem().toString();
                            a[1] = style+"";
                            a[2] =jcombobox_size.getSelectedItem().toString();
                            CommonAction.saveNewStatus(a);
                            
                            parentJFrame.setEnabled(true);
                            jDialog.dispose();
                            
                            
                        }
	   else
	        {
		                    parentJFrame.setEnabled(true);
                            jDialog.dispose();
                        }
                }  
}

