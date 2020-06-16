

package Functionality;
import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.IOException;
 

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

import Starting.CommonReference;


class ScreenShot 
{
	ScreenShot(Dimension dimensionOfScreenShot)
     {
       try {
    	
	         JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setDialogTitle("Specify a file to save");

	         int userSelection = fileChooser.showSaveDialog(CommonReference.getJFrame());
	         if (userSelection == JFileChooser.APPROVE_OPTION) 
                            {
	         Thread.sleep(100);
	         Robot robot = new Robot();
	       
	 
	         Rectangle screenRect = new Rectangle(dimensionOfScreenShot);
	         BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	         ImageIO.write(screenFullImage, "jpg", fileChooser.getSelectedFile() );
	 
	        /* setLocation(500, 500);
	         JLabel text = new JLabel("A full screenshot saved!");
	         add(text);
	         setSize(200, 100);
	         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         getContentPane().setLayout(new FlowLayout());
	         setVisible(true);*/
                          }
	      } catch (AWTException | IOException | InterruptedException ex) {
	               System.err.println(ex);
	      }         
     }
}