package de.nhilbert.zenbell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;

/**
 * The Settings Manager controls all the settings for the program.
 * 
 * It serves the setting data (e.g. filenames) etc. to any interested class.
 * 
 * At the same time, it provides the mechanisms to change those settings.
 * 
 * It implements an action listener in order to be bound to menus etc., for example to the 
 * context menu in the main window
 * 
 * @author Norman Hilbert
 *
 */
public class SettingsManager implements ActionListener {

	/**
	 * Some default data - should in future be implemented dynamically from a settings-file
	 */
	private static final long default_period=10000;
	private static final String default_backgroundimage="resources\\buddha.png";
	private static final String default_soundfile="resources\\bell.wav";
	private static final String trayIcon="resources\\bellicon.png";
	
	/**
	 * Action constants
	 */
	public static final int BACKGROUNDCHANGE=321;
	
	/** 
	 * The settings attributes
	 * Maybe this should also be dynamic in the future (i.e. via a "setting" class), so
	 * that the settings manager has no need to know what settings exist.
	 */
	private long period;
	private String backgroundimage;
	
	private BellMaster MyBellmaster;
	
	private List<ActionListener> ListenerList;


	private String soundfile;
	
	public BellMaster getBellmaster(){
		return MyBellmaster;
	}
	
	/** 
	 * Constructor: Loading standard settings. Create a Bellmaster.
	 */
	public SettingsManager() {
		period=default_period;
		backgroundimage=default_backgroundimage;
		soundfile=default_soundfile;
		
		MyBellmaster=new BellMaster(this);
		
		//A list of listeners
		ListenerList = new ArrayList<ActionListener>();
	}

	/**
	 * Manage Actions refering to settings
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the action is of some kind, show the settings dialog
		if(e.getActionCommand()=="Settings..."){
			//show the Settings Dialog;
			requestPeriod();
		}
		if(e.getActionCommand()=="Change Background..."){
			//show the Settings Dialog;
			requestBackground();
		}
		
	}
	
	private void requestBackground(){
        JFileChooser filedialog = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        int result=filedialog.showOpenDialog(null);
        if( result == JFileChooser.APPROVE_OPTION)
        {

                setBackgroundimage(filedialog.getSelectedFile().getPath());
        }
	}
	
	private void requestPeriod(){
        boolean validInput = false;  // for input validation
        int numberIn;
        String inputStr = JOptionPane.showInputDialog("Time between bells (in s):");
        do {
           try {
              numberIn = Integer.parseInt(inputStr);
           } catch (NumberFormatException ex) {
              numberIn = -1;  // input triggered NumberFormatException, set to invalid
           }
           if (numberIn < 1) {
              inputStr = JOptionPane.showInputDialog("Invalid entry! Time between bells (in s): ");
           } else {
              JOptionPane.showMessageDialog(null, "You have entered " + numberIn);
              validInput = true;
           }
        } while (!validInput); // repeat if input is not valid
        setPeriod(numberIn*1000);
        MyBellmaster.reset();
	}
	
	
	public void addListener(ActionListener al){
		ListenerList.add(al);
	}
	
	private void triggerEvent(int id, String text){
		ActionEvent event=new ActionEvent(this, id, text);
		
		// Go through List of Listeners and call the actionPerformed method
		Iterator<ActionListener> it=ListenerList.iterator();
		while(it.hasNext()){
			it.next().actionPerformed(event);
		}
	}

	
	/**
	 * Get the Period
	 * @return
	 */
	public long getPeriod() {
		// TODO Auto-generated method stub
		return period;
	}
	
	public String getBackgroundimage() {
		return backgroundimage;
	}
	
	public String getTrayIcon() {
		return trayIcon;
	}

	public void setBackgroundimage(String backgroundimage) {
		this.backgroundimage = backgroundimage;
		triggerEvent(BACKGROUNDCHANGE,"Background changed");
	}

	public String getSoundfile() {
		return soundfile;
	}

	public void setSoundfile(String soundfile) {
		this.soundfile = soundfile;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

}
