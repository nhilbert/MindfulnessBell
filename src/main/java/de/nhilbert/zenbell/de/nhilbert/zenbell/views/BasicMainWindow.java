package de.nhilbert.zenbell.de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.ContextMenu;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.MainPresenter;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.WindowProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class BasicMainWindow extends JFrame implements View {


    private JLabel label;
    private MainPresenter myMainPresenter;

    public void BasicMainWindow()
    {
        //Add the background label and set it to the background image
        label = new JLabel();
        this.getContentPane().add(label);
        try{
            updateBackgroundImage(myMainPresenter.getBackgroundImagePath()); //get path to BGImage
        }
        catch(Exception e){
            //well, image loading didn't work, write some text instead
            label.setText("Image not found!");
        }
        label.addMouseListener(new BackgroundMouseListener(myMainPresenter)); //add a Background MouseListener
        this.addWindowListener(new MainWindowListener(myMainPresenter)); //add a Window-Listener to this window
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    public void hideView() {
        this.setVisible(false);
    }

    @Override
    public void updateView() {

    }


    /**
     * Loads a new background image for the window. It is created as a label. The windows BellMaster is set up as a MouseListener for events on the background.
     * @param filename The background image to be used for the main window.
     */
    private void updateBackgroundImage(String filename){
        try {
            label.setIcon(new ImageIcon(ImageIO.read(new File(filename))));
        } catch (IOException e) {
            label.setText("Fehler!");
        }

    }

}
