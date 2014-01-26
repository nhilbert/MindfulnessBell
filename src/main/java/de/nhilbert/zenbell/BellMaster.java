package de.nhilbert.zenbell;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

public class BellMaster implements MouseListener, WindowListener{

	/**
	 * The Bell which the BellMaster owns an rings
	 */
	private Bell myBell;
	private SettingsManager MySettings;

	TimerTask action ;
	
	/**
	 * A timer in order to let the BellMaster know when to ring the bell
	 */
	private Timer belltimer;
	
/**
 * Closes the bell master down : Cancels the timer in a controlled fashion.
 */
    public void close(){
    	belltimer.cancel();
        System.out.println("Goodbye!");    	
    }
	
    /**
     * Public constructor - 
     * sets up the BellMaster, creates a new Bell and schedules it to ring the bell regularly.
     */
	public BellMaster(SettingsManager s){
		MySettings=s;
		myBell=new Bell(MySettings.getSoundfile());
		action = new TimerTask() {
			
            public void run() {		
                myBell.ring();
  
            }
        };		
        System.out.println("Welcome!!!");
        belltimer = new Timer();
		
		belltimer.schedule(action, 1000, MySettings.getPeriod());
	}
	
	
	public void  reset(){
		belltimer.cancel();
		System.out.println("Setting Timer....");
		action = new TimerTask() {
			
            public void run() {		
                myBell.ring();
  
            }
        };		
        belltimer = new Timer();
		belltimer.schedule(action, 0, MySettings.getPeriod());
	}
	
	/**
	 * The bell master is also a mouse listener and will ring the bell whenever asked for
	 * by a mouse clicked event on a component that registered a BellMaster instance.
	 */
	@Override
	 public void mouseClicked(MouseEvent e)  
	  {  	
        if (e.getButton()==MouseEvent.BUTTON1)
	       myBell.ring();
	    }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Watches for window Close events (i.e. from the main window) in order to shut down itself, too.
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		close();
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  
}
