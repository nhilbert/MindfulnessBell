package de.nhilbert.zenbell;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Bell {
	
	private File soundfile;
	
	public Bell(String sf){
		soundfile=new File(sf);
	}
	
	public void ring(){
		
		 try{ AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundfile.getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	        System.out.println("Listen, Listen to this wonderful sound.");
		 }catch(Exception ex){
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		 }
	}
	
	/**
	 * not implemented yet
	 */
	public void silence(){
		
	}
	
	

}
