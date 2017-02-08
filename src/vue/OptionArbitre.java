package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class OptionArbitre extends JPanel {
	
	 private JButton go=new JButton(" GO");
	 private JButton fin =new JButton(" fin");
	 private JButton rouge =new JButton(" rouge");
	 private JButton jaune =new JButton(" jaune ");
	
	 
	
	 public OptionArbitre() {
		 
		  
		    
		 	this.add(go);
		  	this.add(fin);
			this.add(new JLabel(new ImageIcon("images/cartonR.gif")), BorderLayout.CENTER);
			this.add(rouge);
			this.add(new JLabel(new ImageIcon("images/cartonJ.gif")), BorderLayout.CENTER);
			this.add(jaune);
			this.setBackground(new Color(0,130,65));
			this.setBackground( Color.BLACK);
			fin.setEnabled(false);
			rouge.setEnabled(false);
			jaune.setEnabled(false);
			
	}

	 
	 
	 
	 
	 
	 public void paintComponent(Graphics contexteGraphique) {
			
		 try {
			 contexteGraphique.setColor(Color.BLACK);
				Image img = ImageIO.read(new File("images/ar .PNG"));
			
				contexteGraphique.drawImage(img, 0, 0, this);
			   
			 } catch (IOException e) {
			 
			   e.printStackTrace();
			 }
				
			 
	         
	 }
	
	 
	 
	 
	 
	 
	 
	 
	 // Getters && Setters
	 
	 
	 

	public JButton getFin() {
		return fin;
	}


	public void setFin(JButton fin) {
		this.fin = fin;
	}


	public JButton getRouge() {
		return rouge;
	}


	public void setRouge(JButton rouge) {
		this.rouge = rouge;
	}


	public JButton getJaune() {
		return jaune;
	}


	public void setJaune(JButton jaune) {
		this.jaune = jaune;
	}


	public JButton getGo() {
		return go;
	}


	public void setGo(JButton go) {
		this.go = go;
	}
	

	
}
