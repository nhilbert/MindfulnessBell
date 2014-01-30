package de.nhilbert.zenbell.de.nhilbert.zenbell.views;

import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.CommandManager;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.MainPresenter;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.SettingsPresenter;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.WindowProperties;
import de.nhilbert.zenbell.de.nhilbert.zenbell.presentation.commands.SaveSettingsCommand;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by norman.hilbert on 27.01.14.
 */
public class SettingsForm extends JFrame {
    private JTextArea notificationTextArea;
    private JCheckBox notificationCheckBox;
    private JCheckBox playSoundCheckBox;
    private JButton chooseSoundButton;
    private JButton previewButton;
    private JButton chooseImageButton;
    private JSpinner minuteSpinner;
    private JSpinner secondsSpinner;
    private JButton cancelButton;
    private JButton okButton;
    private JLabel imageLabel;
    private SettingsPresenter mySettingsPresenter;
    private SettingsForm MasterFrameRef;

    public SettingsForm() {

        //Set up the settings form from the presenter
        notificationCheckBox.setSelected((Boolean) mySettingsPresenter.getProperty(WindowProperties.NOTIFIER));
        minuteSpinner.setValue((Integer) mySettingsPresenter.getProperty(WindowProperties.PERIODMIN));
        secondsSpinner.setValue((Integer) mySettingsPresenter.getProperty(WindowProperties.PERIODSEC));
        playSoundCheckBox.setSelected((Boolean) mySettingsPresenter.getProperty(WindowProperties.MUTED));
        try {
            imageLabel.setIcon(new ImageIcon(ImageIO.read(new File((String) mySettingsPresenter.getProperty(WindowProperties.BGIMAGE)))));
        } catch (IOException e) {
            imageLabel.setText("Fehler!");
        }

        //create commands when "ok" is clicked
        okButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                //set the settings
                mySettingsPresenter.saveSettings();
             }



                        });

        chooseSoundButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                //get a soundfile
            }



        });
        previewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //play the soundfile
            }
        });
        chooseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get an image file
                // not implemented yet
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MasterFrameRef.dispose();
            }
        });
    }
}
