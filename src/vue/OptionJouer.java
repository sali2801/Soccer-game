package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class OptionJouer extends JPanel {

	
	 private JButton avancer = new JButton(" Avancer");
	 private JButton reculer = new JButton(" Reculer");
	 private JButton recuperer = new JButton(" recuperer ");
	 private JButton tirer  = new JButton(" Tirer");
	 private JButton passer = new JButton(" passer ");
	 private JButton hurler = new JButton(" hurler ");
	 private JComboBox comboRA = new JComboBox();
	 private JComboBox comboP = new JComboBox();
	 private JComboBox combo3 = new JComboBox();
	 private Position p=new Position(500,500);
	 private Position p1=new Position(600,500);
	 
	 public OptionJouer ( ) {
		 
		
		
		comboRA.addItem("gardient");
		comboRA.addItem("defenseur");
		comboRA.addItem("attaquant");
		
		comboP.addItem("gardient");
		comboP.addItem("defenseur");
		comboP.addItem("attaquant");
		

		
		combo3.addItem("gardient");
		combo3.addItem("defenseur");
		combo3.addItem("attaquant");
		
		
		
		this.add(comboRA);
		this.add(avancer);
		this.add(reculer);
		this.add(tirer);
		this.add(comboP);
        this.add(passer);
     	this.add(recuperer);
	    this.add(new JLabel(new ImageIcon("images/hurler.gif")), BorderLayout.CENTER);
		this.add(hurler);
		
		
		
		
	}

	 	 	 
	 
	 //  Getters && Setters
	 
	 
	 
	 public JButton getHurler() {
		return hurler;
	}





	public void setHurler(JButton hurler) {
		this.hurler = hurler;
	}





	public JComboBox getComboP() {
		return comboP;
	}





	public void setComboP(JComboBox comboP) {
		this.comboP = comboP;
	}





	public JComboBox getCombo3() {
		return combo3;
	}





	public void setCombo3(JComboBox combo3) {
		this.combo3 = combo3;
	}





	public JButton getPasser() {
		return passer;
	}





	public void setPasser(JButton passer) {
		this.passer = passer;
	}





	public JButton getRecuperer() {
		return recuperer;
	}




	public void setRecuperer(JButton ampecher) {
		this.recuperer = ampecher;
	}

	public JButton getTirer() {
		return tirer;
	}



    public void setTirer(JButton tirer) {
		this.tirer = tirer;
	}


	public JButton getAvancer() {
		return avancer;
	}


	public JButton getReculer() {
		return reculer;
	}

	public void setReculer(JButton reculer) {
		this.reculer = reculer;
	}

	public void setAvancer(JButton avancer) {
		this.avancer = avancer;
	}
	 private Joueur [] listJoueur;
	 
		
	 public JComboBox getComboRA() {
		return comboRA;
	}

	public void setCombo(JComboBox comboRA) {
		this.comboRA = comboRA;
	}
	
}
