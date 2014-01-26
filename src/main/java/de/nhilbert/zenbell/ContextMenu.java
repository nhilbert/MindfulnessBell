package de.nhilbert.zenbell;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

/** 
 * The context menu for the main window.
 * This provides the user with action possibilities (e.g. access to settings etc.)
 * @author Norman Hilbert
 *
 */
public class ContextMenu extends JPopupMenu {

	JMenuItem SettingsItem;
	JMenuItem BackgroundItem;
	JMenuItem CloseItem;
	JMenuItem InfoItem;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The public constructor. Creates the menu structure.
	 */
    public ContextMenu(){
    	BackgroundItem = new JMenuItem("Change Background...");
    	add(BackgroundItem);
        SettingsItem = new JMenuItem("Settings...");
        add(SettingsItem);
        add(new JSeparator(JSeparator.HORIZONTAL));
        InfoItem = new JMenuItem("Info");
        add(InfoItem);
        add(new JSeparator(JSeparator.HORIZONTAL));
        CloseItem = new JMenuItem("Close");
        add(CloseItem);

    }

    /**
     * This adds an action listener to the menu. 
     * The action listener will handle all events from the context menu.
     * Obviously, the action listener needs knowlegde about the menu items.
     * @param al
     */
	public void addActionListener(ActionListener al) {
		SettingsItem.addActionListener(al);
		BackgroundItem.addActionListener(al);
		CloseItem.addActionListener(al);
		InfoItem.addActionListener(al);
	}	
	
	public void addCloseListener(ActionListener al){
		CloseItem.addActionListener(al);
	}

}
