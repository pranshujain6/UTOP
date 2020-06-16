

package Starting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.File;

import java.net.URL;

import javax.swing.event.*;
import javax.swing.*;

import Functionality.Bridge;

public class Beginning implements KeyListener , ActionListener,Runnable ,MenuListener,CaretListener,MouseMotionListener   {
	
	
	private static JFrame jFrame;
	 
	private static JPanel jPanel0; // ye jmenu bar ke liye
	private static JPanel jPanel1; // ye text pane ke liye
	private static JPanel jPanel2; // ye last wala pointer status and all options ke liye
	
	private static JLabel jLabelRowStatus;
	private static JLabel jLabelColStatus;
	
	private static JMenuBar jMenuBar;
	private static JMenu jMenuFile;
	private static JMenu jMenuShare;
	//private static JMenu jMenuScreenShot;
	private static JMenu jMenuStyle;
	private static JMenu jMenuSpeak;
	private static JMenu jMenuTools;
	private static JMenu jMenuString;
	private static JMenu jMenuHelp;
	
	private static JMenuItem jMenuItemCreate;
	private static JMenuItem jMenuItemOpen;
	private static JMenuItem jMenuItemClose;
	private static JMenuItem jMenuItemPrint;
	private static JMenuItem jMenuItemRename;
	private static JMenuItem jMenuItemSaveAs;
	private static JMenuItem jMenuItemScreenShot;
	
	private static JMenuItem jMenuItemCopy;
	private static JMenuItem jMenuItemPaste;
	private static JMenuItem jMenuItemPrintInPopup;
	
	private static JMenuItem jMenuItemToolsColorChooser;
	private static JMenuItem jMenuItemToolsNumberConverter;
	private static JMenuItem jMenuItemToolsCalculator;
	private static JMenuItem jMenuItemToolsStopWatch;
	private static JMenuItem jMenuItemToolsCompetetiveCode;
	
	private static JMenuItem jMenuItemFont ;
	private static JMenuItem jMenuItemSearch;
	private static JMenuItem jMenuItemReplace;
	
	private static JMenuItem jMenuSpeakMale;
	private static JMenuItem jMenuSpeakFemale;

	private static JTextPane jTextPaneCode; 
	
	private static JLabel jLabelTime;
	
	private JCheckBox jCheckBoxColorTheme;
	
	private JScrollPane jScrollPaneCode;
	
	private  JPopupMenu popup ;
	
	private JSplitPane jsplitpane;
	
	private String path;
	
	private JLabel jLabelMousePointer;
	
	private JLabel jLabelFileName; 
	
	private JLabel jLabelWordCount;
	
	
	
	private int fontType;
	private String fontName;
	private int fontSize;
	private boolean enable;
	
	private void fileReading()
	{
		
		try{

			URL url = this.getClass().getResource("/Resources/Info");
			
			File newfile = new File(url.toURI());
			CommonReference.setStatusFile(newfile);
			
			String a[]  = CommonAction.getValueStatus();
			
			
			fontName = a[0].trim();
			fontType = Integer.parseInt(a[1].trim())  ;
			fontSize = Integer.parseInt(a[2].trim());
			if(a[3].trim().equals("true"))
				enable = true;
			else
				enable  =false;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Cant find reosurce"+e);
		}

	}

	private Beginning() 
	{
		jFrame = new JFrame("IDE");
		CommonReference.setJFrame(jFrame);
		
		jPanel0 = new JPanel();
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		CommonReference.setJPanel2(jPanel2);
			
		jLabelRowStatus=new JLabel();
		CommonReference.setJLabelRowStatus(jLabelRowStatus);	
		
		jLabelColStatus=new JLabel();
		CommonReference.setJLabelColStatus(jLabelColStatus);
		
		fileReading();
		
		jMenuBar =new JMenuBar();
		jMenuFile = new JMenu("File");
		jMenuShare = new JMenu("Share");
		jMenuStyle = new JMenu("Style");
		jMenuSpeak = new JMenu("Speak");
		jMenuTools = new JMenu("Tools");
		jMenuString = new JMenu("String");
		jMenuHelp  = new JMenu("Help");
		
		jMenuItemCreate =new JMenuItem("  Create     ctrl+N  ");
		jMenuItemOpen =new JMenuItem("  Open     ctrl+O  ");
		jMenuItemClose =new JMenuItem("  Close     ctrl+X  ");
		jMenuItemPrint =new JMenuItem("  Print...     ctrl+P  ");
		jMenuItemRename =new JMenuItem("  Rename     ctrl+R  ");
		jMenuItemScreenShot = new JMenuItem(" Screen Shot");
		
		jMenuItemSaveAs=new JMenuItem("  SaveAs...  ");

		jMenuItemFont =new JMenuItem("  Font...  ");
		
		jMenuItemToolsColorChooser = new JMenuItem("ColorChooser");
		jMenuItemToolsNumberConverter = new JMenuItem("Number Converter");
		jMenuItemToolsCalculator = new JMenuItem("Calculator");
		jMenuItemToolsStopWatch = new JMenuItem("StopWatch");
		jMenuItemToolsCompetetiveCode = new JMenuItem("Competeive Coding");
		
		jMenuSpeakMale = new JMenuItem("Male");
		jMenuSpeakFemale = new JMenuItem("Female");
		
		jMenuItemSearch=new JMenuItem("  Search  ");
		jMenuItemReplace=new JMenuItem("  Replace...  ");
		
		jTextPaneCode = new JTextPane();
		CommonReference.setJTextPaneCode(jTextPaneCode);
		jScrollPaneCode = new JScrollPane(jTextPaneCode);
		
		TextLineNumber t = new TextLineNumber(jTextPaneCode);
		jScrollPaneCode.setRowHeaderView(t);
		
		jLabelTime = new JLabel();
		CommonReference.setJLabelTime(jLabelTime);
		
		jCheckBoxColorTheme = new JCheckBox("Bright Color Theme");
		CommonReference.setJCheckBoxColorTheme(jCheckBoxColorTheme);
		
		popup = new JPopupMenu();
        jMenuItemCopy =new JMenuItem("  copy  ");
        jMenuItemPaste =new JMenuItem("  paste  ");
        jMenuItemPrintInPopup =new JMenuItem("  print  ");
        
        jsplitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jPanel1,jPanel2);
        
        jLabelMousePointer = new JLabel("0 : 0"); 
        
        jLabelFileName = new JLabel("No file Selected");
        CommonReference.setJLabelFileName(jLabelFileName);
        
        jLabelWordCount = new JLabel("0");
        CommonReference.setJLabelWordCount(jLabelWordCount);

        
		
		setProperties();
		setBounds();
		addElements();
		
		
		
		Bridge.callTime();
		Bridge.undoRedo();
		
		if(enable)
		{
			jCheckBoxColorTheme.setSelected(true);
			ColorChange.changeColor();
			
		}
		
	}
	
	
	private void setProperties()
	{	
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jFrame.getContentPane().setLayout(new FlowLayout());
		jFrame.setVisible(true);
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jPanel0.setLayout(new BorderLayout());
		
		jPanel1.setLayout(new BorderLayout());
		
		jPanel2.setLayout(null);
		jPanel2.setBackground(new Color(115,115,115));
		
		jTextPaneCode.setCaretColor(new Color(255,255,255));
		jTextPaneCode.setFont(new Font(fontName,fontType,fontSize));
		jTextPaneCode.setBackground(new Color(50,50,50));
		jTextPaneCode.setForeground(new Color(66, 226, 27).brighter());
		jTextPaneCode.addKeyListener(this);
		jTextPaneCode.addCaretListener(this);
		jTextPaneCode.setEnabled(false);
		
	    jTextPaneCode.addMouseListener(new MouseAdapter()
	    {
	    	public void mouseReleased(MouseEvent e)
	    	{
	    		if(SwingUtilities.isRightMouseButton(e))
	    		{
	    		popup.add(jMenuItemCopy);
	    		popup.add(jMenuItemPaste);
	    		popup.add(jMenuItemPrintInPopup);
	    		popup.show(e.getComponent(), e.getX(), e.getY());
	    		}
	    	}
	    	
	    });
		
	    jMenuItemCopy.addActionListener(this);
	    jMenuItemPaste.addActionListener(this);
	    jMenuItemPrintInPopup.addActionListener(this);
	    
		jMenuItemPrint.setAccelerator(KeyStroke.getKeyStroke('P',InputEvent.CTRL_DOWN_MASK));
		
		jMenuItemFont.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.CTRL_DOWN_MASK));
		
		jMenuFile.setMnemonic('F');
		jMenuFile.setToolTipText("File");
		jMenuShare.setMnemonic('s');
		jMenuShare.setToolTipText("Share");
		jMenuSpeak.setMnemonic('k');
		jMenuSpeak.setToolTipText("Speech");
		jMenuHelp.setMnemonic('h');
		jMenuHelp.setToolTipText("Help");
		jMenuString.setMnemonic('t');
		jMenuString.setToolTipText("String amendments");
		jCheckBoxColorTheme.setMnemonic('B');
		jCheckBoxColorTheme.setToolTipText("Theme revert");
		jMenuTools.setMnemonic('o');
		jMenuTools.setToolTipText("Tools");
		jMenuStyle.setMnemonic('l');
		jMenuStyle.setToolTipText("Style");
		
		jMenuItemSearch.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_DOWN_MASK));
		jMenuItemReplace.setAccelerator(KeyStroke.getKeyStroke('E',InputEvent.CTRL_DOWN_MASK));
		
		jMenuItemScreenShot.addActionListener(this);
		
		ImageIcon c= new ImageIcon(this.getClass().getResource("/Resources/Logo.jpg"));
		jFrame.setIconImage(c.getImage()); 
		
		jCheckBoxColorTheme.addActionListener(this);
		
		jMenuItemSearch.addActionListener(this);
		jMenuItemReplace.addActionListener(this);
		
		jLabelTime.setForeground(new Color(255,255,255));
		jLabelTime.setToolTipText("Using since");
		
		jMenuSpeakMale.addActionListener(this);
		jMenuSpeakFemale.addActionListener(this);
		
		jMenuItemFont.addActionListener(this);
		
		jMenuItemPrint.addActionListener(this);
		
		jMenuItemToolsCalculator.addActionListener(this);
		
		jMenuItemToolsColorChooser.addActionListener(this);
		
		jMenuItemToolsNumberConverter.addActionListener(this);
		
		jMenuItemCreate.addActionListener(this);
		
		jMenuItemOpen.addActionListener(this);
		
		jMenuItemClose.addActionListener(this);
		
		jMenuItemToolsStopWatch.addActionListener(this);
		
		jMenuItemRename.addActionListener(this);
		
		jFrame.addMouseMotionListener(this);
		jPanel0.addMouseMotionListener(this);
		jTextPaneCode.addMouseMotionListener(this);
		jPanel2.addMouseMotionListener(this);
		
		jLabelRowStatus.setToolTipText("Rows");
		jLabelColStatus.setToolTipText("Column");
		
		jLabelFileName.setToolTipText("File Name");
		
		jLabelMousePointer.setToolTipText("Mouse pointer");
		
		jLabelWordCount.setToolTipText("Word Count");
		
		
	}
	private void setBounds()
	{
		jPanel0.setPreferredSize(new Dimension(1370,32));
		jPanel1.setPreferredSize(new Dimension(1370,550));
		jPanel2.setPreferredSize(new Dimension(1370,200));
		
		jLabelTime.setBounds(1250, 50, 60, 20);
		jLabelRowStatus.setBounds(1250,80,30,10);
		jLabelColStatus.setBounds(1290,80,30,10);
		
		jLabelMousePointer.setBounds(1150,80,100,10);
		
		jLabelFileName.setBounds(50,30,150,30);
		
		jLabelWordCount.setBounds(300,30,150,30);
		
	}
	private void addElements()
	{
		jFrame.add(jPanel0);
		jFrame.getContentPane().add(jsplitpane);
		
		jPanel0.add(jMenuBar);
				
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jMenuShare);
		jMenuBar.add(jMenuStyle);
		jMenuBar.add(jMenuSpeak);
		jMenuBar.add(jMenuTools);
		jMenuBar.add(jMenuString);
		jMenuBar.add(jMenuHelp);
		//jMenuBar.addSeparator(new Dimension(800,10));
		jMenuBar.add(jCheckBoxColorTheme);
		
		jMenuFile.add(jMenuItemCreate);
		jMenuFile.add(jMenuItemOpen);
		jMenuFile.add(jMenuItemClose);
		jMenuFile.add(jMenuItemRename);
		jMenuFile.add(jMenuItemSaveAs);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuItemPrint);
		jMenuFile.add(jMenuItemScreenShot);
		
		jMenuStyle.add(jMenuItemFont);
		
		jMenuString.add(jMenuItemSearch);
		jMenuString.add(jMenuItemReplace);
		
		jMenuTools.add(jMenuItemToolsColorChooser);
		jMenuTools.add(jMenuItemToolsCalculator);
		jMenuTools.add(jMenuItemToolsNumberConverter);
		jMenuTools.add(jMenuItemToolsStopWatch);
		jMenuTools.add(jMenuItemToolsCompetetiveCode);
		
		jMenuSpeak.add(jMenuSpeakMale);
		jMenuSpeak.add(jMenuSpeakFemale);
		
		jPanel1.add(jScrollPaneCode,BorderLayout.CENTER);
		jPanel2.add(jLabelTime);
		
		jPanel2.add(jLabelRowStatus);
		jPanel2.add(jLabelColStatus);
		jPanel2.add(jLabelMousePointer);
		jPanel2.add(jLabelFileName);
		
		jPanel2.add(jLabelWordCount);
		
	
	}
	public void caretUpdate(CaretEvent ce) 
	{
       CommonAction.caretUpdate(ce);   
    }

	public void menuSelected(MenuEvent e)
	{
		 
			
	}
	public void menuCanceled(MenuEvent e)
	{
		
	}

	public void menuDeselected(MenuEvent arg0) {

	} 
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jCheckBoxColorTheme)
			ColorChange.changeColor();
		if(ae.getSource()==jMenuItemScreenShot)
			 Bridge.screenShot();	
		else if(ae.getSource()==jMenuItemSearch)
			new SearchText();
		else if(ae.getSource()==jMenuItemReplace)
			new ReplaceText();
		else if(ae.getSource()==jMenuSpeakMale)
			Bridge.maleSpeak();
		else if(ae.getSource()==jMenuSpeakFemale)
			Bridge.femaleSpeak();
		else if(ae.getSource()==jMenuItemFont)
			new FontChange(jTextPaneCode);
		else if(ae.getSource()==jMenuItemPrint  )
			try {
				jTextPaneCode.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		else if(ae.getSource()==jMenuItemCopy)
			jTextPaneCode.copy();
		else if(ae.getSource()==jMenuItemPaste)
			jTextPaneCode.paste();
		else if(ae.getSource()==jMenuItemPrintInPopup)
			try {
				jTextPaneCode.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		else if(ae.getSource()==jMenuItemToolsCalculator)
			Bridge.calculator();
		else if(ae.getSource()==jMenuItemToolsColorChooser)
			Bridge.colorChooser();
		else if(ae.getSource()==jMenuItemToolsNumberConverter)
			Bridge.NumberConverter();
		else if(ae.getSource()==jMenuItemToolsStopWatch)
			Bridge.StopWatch();
		
		
		
		// Isse modularies krna h mujhe abhi abhi to m flow flow me
		
		else if(ae.getSource()==jMenuItemCreate)
		{
			if(path!=null)
			{
				 int dialogButton = JOptionPane.YES_NO_OPTION;
				 int dialogResult =  JOptionPane.showConfirmDialog (null, "Are You sure?","Warning",dialogButton);
				    if (dialogResult == JOptionPane.YES_OPTION)
				    {
				    
				    	CommonAction.newBeginningWithExist();
				    	path = new FileChooser().call();
						boolean result = new FileHandling(path).open();
						if(result)
						{
							try{
								new CodeStart().newFile();
							}catch(Exception e1)
							{
								JOptionPane.showMessageDialog(null, "New File can not be created");
							}
						}
						else
						{
							path = null;
						}
						
				    }
			}
			else
			{
				path = new FileChooser().call();
				boolean result = new FileHandling(path).open();
				if(result)
				{
					try{
						new CodeStart().newFile();
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "File cant opened properly try again");
					}
				}
				else
				{
					path = null;
				}
			}
		}
		else if(ae.getSource()==jMenuItemOpen)
		{
			if(path!=null)
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are You sure?","Warning",dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION)
				{
				   CommonAction.newBeginningWithExist();
				  
				    path = new FileChooser().call();
					boolean result = new FileHandling(path).update();
					if(result)
					{
						try{
							new CodeStart().existingFile();
						}catch(Exception e1)
						{	
							JOptionPane.showMessageDialog(null, "File is not loded properly");
						}
					}
					else
					{
						path = null;
					}
				}
				
			}
			else
			{
				path = new FileChooser().call();
				boolean result = new FileHandling(path).update();
				if(result)
				{
					try{
						new CodeStart().existingFile();
					}catch(Exception e1)
					{	
						JOptionPane.showMessageDialog(null, "File is not loded proeprly");
					}
				}
				else
				{
					path = null;
				}
			}
		}
			
		else if(ae.getSource()==jMenuItemClose)
		{
			
			if(path!=null)
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are You sure?","Warning",dialogButton);
				 				
				if (dialogResult == JOptionPane.YES_OPTION)
				{
					CommonAction.newBeginningWithExist();
					path=null;
					JOptionPane.showMessageDialog(null,"File closed successfully");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"File parameter is not initialised");
			}
		}
		
		else if(ae.getSource()==jMenuItemRename)
		{
			if(path!=null)
			{
				File file  = CommonReference.getFile();
				String name  = JOptionPane.showInputDialog("Please enter file name");
				if(name==null||name.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please provide Proper name");
					return;
				}
				name = name.trim();
				if(name.endsWith(".java"))
				{}
				else
					name=name+".java";
				String newpath = file.getPath().replace(file.getName(), name);
				File newFile = new File(newpath);
				if(file.renameTo(newFile)) {
					CommonReference.setFile(newFile);
					jLabelFileName.setText(CommonReference.getFile().getName());
			     
			      } else {
			        JOptionPane.showMessageDialog(null, "Sorry file name already exist");
			      }
			}
			else
			{
				JOptionPane.showMessageDialog(null,"File parameter is not initialised");
			}
		}
		
		// Yha tk iske aage tu tera dekh lena pankaj
	}
	
	public void keyPressed(KeyEvent ke)
	{
		CommonAction.keyPressedCallFunction(ke);
	}
	public void keyReleased(KeyEvent ke)
	{
		CommonAction.keyReleased(ke);
	}
	public void keyTyped(KeyEvent ke)
	{
		
	}
	
	public void mouseMoved(MouseEvent me)
	{
		jLabelMousePointer.setText(me.getX()+" : "+me.getY());
	}
	
	public void mouseDragged(MouseEvent me)
	{
		
	}
	
	public void run()
	{
		
	}
	
	public static void main(String[] args) 
	{
		
		SwingUtilities.invokeLater(new Thread()	{public void run(){new Beginning();}});
		
		
	}
	
	
	
}
