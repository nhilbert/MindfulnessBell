package de.nhilbert.zenbell;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.MainPresenter;

import java.awt.event.ActionEvent;
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

    MainPresenter myPresenter;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The public constructor. Creates the menu structure.
	 */
    public ContextMenu(MainPresenter myPresenter){
        this.myPresenter=myPresenter;
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
		SettingsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPresenter.showSettings();
            }
        });
		BackgroundItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPresenter.changeBackground();
            }
        });
		CloseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPresenter.showInfo();
            }
        });
		InfoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myPresenter.close();
            }
        });
	}	


}
