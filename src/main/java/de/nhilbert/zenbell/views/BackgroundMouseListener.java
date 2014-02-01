package de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.presentation.MainPresenter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by norman.hilbert on 27.01.14.
 * Listens to mouse activities on the background image
 */
public class BackgroundMouseListener implements MouseListener {

    private MainPresenter myPresenter;

    public BackgroundMouseListener(MainPresenter myPresenter){
        this.myPresenter=myPresenter;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            System.out.println("Left Button Clicked");
            myPresenter.ring();
        }
    }

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

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
