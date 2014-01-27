/**
 * 
 */
package de.nhilbert.zenbell;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
import javax.swing.UIManager;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This is the applications main window.
 * 
 * @author Norman
 *
 */
public class MainWindow extends JFrame implements MouseListener, WindowStateListener {
	
	/**
	 * The BellMaster which is connected to the window. 
	 * This enables the window to add the BellMaster as a Listener to various objects in the layout (e.g. the background)
	 */
	private BellMaster WindowBellMaster;

	private ContextMenu MyContextMenu;
	private JLabel label;
	
    private TrayIcon trayIcon;
    private SystemTray tray;
    
    private SettingsManager mySettings;
	
	
	/**
	 * A serial Version UID
	 */
	private static final long serialVersionUID = -817316398147262828L;
	
	/**
	 * The public constructor
	 * @param title Title of the window
	 * @param sm A bell Master
	 */
	public MainWindow(String title, SettingsManager sm){
		super(title);
		mySettings=sm;
		label = new JLabel();
		label.addMouseListener(this); //the window handles its clicks itself (i.e. for popups)
		this.getContentPane().add(label);
		MyContextMenu = new ContextMenu(); //add a new context menu
//		this.getContentPane().add(new ContextMenu());

		/**
	     * Do everything needed for the system Tray hiding
		 * Code in part from: http://stackoverflow.com/questions/7461477/how-to-hide-a-jframe-in-system-tray-of-taskbar
		 *
		 * @author Mohammad Faisal
		 * ermohammadfaisal.blogspot.com
		 * facebook.com/m.faisal6621
		 *
		 */

		

        if(SystemTray.isSupported()){
            tray=SystemTray.getSystemTray();
           

            ActionListener exitListener=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting....");
                    closeWindow();
                }
            };
            
            MyContextMenu.addCloseListener(exitListener);
            
            PopupMenu popup=new PopupMenu();
            
            MenuItem defaultItem=new MenuItem("Beenden");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            
            defaultItem=new MenuItem("�ffnen");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            
    		//Load the tray icon image

            BufferedImage myTrayIcon;
			try {
				myTrayIcon = ImageIO.read(new File(mySettings.getTrayIcon()));
	            trayIcon=new TrayIcon(myTrayIcon, "Mindfulness Bell", popup);
	            trayIcon.setImageAutoSize(true);
	        } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}            
            


        }else{
            System.out.println("system tray not supported");
        }
        addWindowStateListener(this);
            
        //If BackgroundImage is changed, too something
        mySettings.addListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(e.getID()==SettingsManager.BACKGROUNDCHANGE){
        			updateBackgroundImage();

        		}
        	}
        });
	
	}
	
	/** Close the window and shut everything down.
	 * 
	 */
	private void closeWindow(){
        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
	
    private void createContextMenu(MouseEvent e){
        
        MyContextMenu.show(e.getComponent(), e.getX(), e.getY());
    }

	
	/**
	 * Register a BellMaster for the window
	 * @param SomeBellMaster
	 */
	public void registerBellMaster(BellMaster SomeBellMaster){
		label.addMouseListener(SomeBellMaster);		
	}
	
	public void registerMenuHandler(){
		
	}
	
	/**
	 * Loads a new background image for the window. It is created as a label. The windows BellMaster is set up as a MouseListener for events on the background.
	 * @param myImage The background image to be used for the main window. Needs to be the right size.
	 */
	public void setBackgroundImage(BufferedImage myImage){

		label.setIcon(new ImageIcon(myImage));
		
	}

	/**
	 * Loads a new background image for the window. It is created as a label. The windows BellMaster is set up as a MouseListener for events on the background.
	 * @param myImage The background image to be used for the main window. Needs to be the right size.
	 */
	public void updateBackgroundImage(){

		BufferedImage myBImage;
		try {
			myBImage = ImageIO.read(new File(mySettings.getBackgroundimage()));
			setBackgroundImage(myBImage);	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * If a popup-mouseclick is detected, create the context menu
	 */
	@Override
	public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger())
        	createContextMenu(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	       if (e.isPopupTrigger())
	    	   createContextMenu(e);
	 		
	}

	/**
	 * Add some Action Listener to the window. The window will know which events it wants to handle
	 * @param al
	 */
	public void addActionListener(ActionListener al) {
		// Listen to Actions of the Context Menu
		MyContextMenu.addActionListener(al);
		// Maybe listen to other stuff, too?
	}
	
	/**
	 * A window state handler in order to minimize the window to the tray.
	 * All necessary pre-work is done when constructing the image (i.e. loading the
	 * tray icon image and setting up the popup menu.
	 */
	public void windowStateChanged(WindowEvent e) {
        if(e.getNewState()==ICONIFIED){
            try {
                tray.add(trayIcon);
                setVisible(false);
                System.out.println("added to SystemTray");
            } catch (AWTException ex) {
                System.out.println("unable to add to tray");
            }
        }
		if(e.getNewState()==7){
		            try{
		    tray.add(trayIcon);
		    setVisible(false);
		    System.out.println("added to SystemTray");
		    }catch(AWTException ex){
		    System.out.println("unable to add to system tray");
		}
	    }
		if(e.getNewState()==MAXIMIZED_BOTH){
		            tray.remove(trayIcon);
		            setVisible(true);
		            System.out.println("Tray icon removed");
		}
		if(e.getNewState()==NORMAL){
		            tray.remove(trayIcon);
		            setVisible(true);
		            System.out.println("Tray icon removed");
		}
	}
}

