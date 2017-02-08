package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */




                        /*
                         *  Cette classes permet de construire une boite de Dialogue
                         *  
                         *   comportant les noms de tous les joueurs.
                         */
                           

public class DialogueArbitre extends JDialog {

	
	
	private JLabel  icon;
    private String joueurSelectionné=new String();
    private JRadioButton joueur1, joueur2, joueur3, joueur4,joueur5,joueur6;
    
    
	
public  DialogueArbitre(JFrame parent, String title, boolean modal){
	
	
	super(parent, title, modal);
	this.setSize(550, 270);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	initComponent();
	
	}

     
         /**
        * 
        * @return joueurSelectionné
         */
  public String showDialog(){
  
	
	this.setVisible(true);
    return this.joueurSelectionné;
   }
  
  
  
/*
* Initialise le contenu de la boîte
*/
private void initComponent(){
//Icone
icon = new JLabel(new ImageIcon("images/b.gif"));
JPanel panIcon = new JPanel();
panIcon.setBackground(Color.white);
panIcon.setLayout(new BorderLayout());
panIcon.add(icon);



//L'âge
JPanel panJoueur= new JPanel();
panJoueur.setBackground(Color.white);
panJoueur.setBorder(BorderFactory.createTitledBorder("Sectionner un joueur"));
panJoueur.setPreferredSize(new Dimension(440, 60));
joueur1 = new JRadioButton("Attaquant D");
joueur2 = new JRadioButton("Defenseur D");
joueur3 = new JRadioButton("Gardient D");
joueur4 = new JRadioButton("Attaquant G");
joueur5 = new JRadioButton("Defenseur G");
joueur6 = new JRadioButton("Gardient G");
ButtonGroup bg = new ButtonGroup();
bg.add(joueur1);
bg.add(joueur2);
bg.add(joueur3);
bg.add(joueur4);
bg.add(joueur5);
bg.add(joueur6);
panJoueur.add(joueur1);
panJoueur.add(joueur2);
panJoueur.add(joueur3);
panJoueur.add(joueur4);
panJoueur.add(joueur5);
panJoueur.add(joueur6);


JPanel content = new JPanel();
content.setBackground(Color.white);

content.add(panJoueur);
JPanel control = new JPanel();
JButton okBouton = new JButton("OK");
 okBouton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
    	 joueurSelectionné= new String(getJoueur());
    	 System.out.println( "ici e"+joueurSelectionné);
    	 setVisible(false);
       }
    public String getJoueur(){
    	return (joueur1.isSelected()) ? joueur1.getText() :
    	(joueur2.isSelected()) ? joueur2.getText() :
    	(joueur3.isSelected()) ? joueur3.getText() :
    	(joueur4.isSelected()) ? joueur4.getText() :
    	(joueur5.isSelected()) ? joueur5.getText() : 
    	(joueur6.isSelected()) ? joueur6.getText() :joueur1.getText();
    	}
     });
 
   control.add(okBouton);

 this.getContentPane().add(panIcon, BorderLayout.WEST);
 this.getContentPane().add(panJoueur, BorderLayout.CENTER);
 this.getContentPane().add(control, BorderLayout.SOUTH);

}


       //  Getters && Setters




public JRadioButton getJoueur1() {
	return joueur1;
}

public void setJoueur1(JRadioButton joueur1) {
	this.joueur1 = joueur1;
}

public JRadioButton getJoueur2() {
	return joueur2;
}

public void setJoueur2(JRadioButton joueur2) {
	this.joueur2 = joueur2;
}

public JRadioButton getJoueur3() {
	return joueur3;
}

public void setJoueur3(JRadioButton joueur3) {
	this.joueur3 = joueur3;
}

public JRadioButton getJoueur4() {
	return joueur4;
}

public void setJoueur4(JRadioButton joueur4) {
	this.joueur4 = joueur4;
}

public JRadioButton getJoueur5() {
	return joueur5;
}

public void setJoueur5(JRadioButton joueur5) {
	this.joueur5 = joueur5;
}

public JRadioButton getJoueur6() {
	return joueur6;
}

public void setJoueur6(JRadioButton joueur6) {
	this.joueur6 = joueur6;
}










}
