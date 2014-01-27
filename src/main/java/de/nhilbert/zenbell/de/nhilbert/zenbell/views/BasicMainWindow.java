package de.nhilbert.zenbell.de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.ContextMenu;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.Presenter;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.WindowProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class BasicMainWindow extends JFrame implements View {

    private ContextMenu myContextMenu;
    private JLabel label;
    private CommandManager myCommandManager;
    private Presenter myPresenter;

    public void BasicMainWindow()
    {
        //Add the background label and set it to the background image
        label = new JLabel();
        this.getContentPane().add(label);
        try{
            updateBackgroundImage((String)myPresenter.getProperty(WindowProperties.BGIMAGE)); //get path to BGImage
        }
        catch(Exception e){
            //well, image loading didn't work, write some text instead
            label.setText("Image not found!");
        }
        label.addMouseListener(new BackgroundMouseListener(myCommandManager)); //add a Background MouseListener
        this.addWindowListener(new MainWindowListener(myCommandManager)); //add a Window-Listener to this window
        myContextMenu=new ContextMenu();
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

    @Override
    public void addCommandManager(CommandManager cm) {
        //Sets the command Manager, used to execute commands created by the views listeners
        this.myCommandManager=cm;
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
