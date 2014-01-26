package de.nhilbert.zenbell;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * This is the main class. It opens up the Main Window, configures it and invokes a bell master.
 * @author Norman
 *
 */
public class Main {
	
	
	public static void main(String[] args)  throws IOException {
		
		// Show the main window
		
		SettingsManager MySettings = new SettingsManager();

		
		BufferedImage myBImage = ImageIO.read(new File(MySettings.getBackgroundimage()));
		
		//Set Up Main Window
		MainWindow myWindow = new MainWindow("Mindfulness Bell", MySettings);
		myWindow.registerBellMaster(MySettings.getBellmaster());
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setBackgroundImage(myBImage);
		myWindow.pack();
		myWindow.setResizable(false);
		myWindow.addWindowListener(MySettings.getBellmaster());
		
		//Show Main Window
		myWindow.setVisible(true);
		
		
		myWindow.addActionListener(MySettings);
		
		
		
		
	}

}
