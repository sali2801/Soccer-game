
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Mallem Saliha
 *
 * @Date 13/06/2012
 */
public class AccueilPanel  {
	
	
	
	private JPanel panel;
	

	
	 
	public AccueilPanel(Dimension dim){
		
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		MidiSoundTest sound=new MidiSoundTest();
		sound.startMidi("foot.mid");  
		this.panel.add(new JLabel(new ImageIcon("images/aceuill.jpg")), BorderLayout.CENTER);
	}
	
	
	
	   // Getters & Setters 
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	
	

}
