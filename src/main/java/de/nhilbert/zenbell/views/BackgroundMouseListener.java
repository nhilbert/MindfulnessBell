package de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.presentation.MainPresenter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by norman.hilbert on 27.01.14.
 * Listens to mouse activities on the background image
 *
 * The Background Mouse Listener activates action such as showing a context menu and ringing the bell
 * on a click on the background.
 */
public class BackgroundMouseListener implements MouseListener {

    private MainPresenter myPresenter;

    /**
     * This the constructor for the BackgroundMouseListener
     * @param myPresenter the presenter for the JFRAME holding the image
     */
    public BackgroundMouseListener(MainPresenter myPresenter){
        this.myPresenter=myPresenter;
    }

    /***
     * When the mouse is clicked, if it is the left button, ring the bell
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            System.out.println("Left Button Clicked");
            myPresenter.ring();
        }
    }

    /**
     * Whenever the right button is pressed, show a context menu, allow to edit settings etc.
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //on right click show popup
        if (e.getButton()==MouseEvent.BUTTON3)
        {
            System.out.println("Right Pressed");
            ContextMenu myContextMenu= new ContextMenu(myPresenter);
            myContextMenu.show(e.getComponent(),e.getX(),e.getY());
        }
    }

    /**
     * No action
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * No action
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * No action
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
