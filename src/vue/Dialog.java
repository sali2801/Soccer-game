package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;




/**
 * @author Mallem Saliha
 *
 * @Date   14/06/2012
 */
public class Dialog extends JDialog {
	


            private JLabel nomLabel, nomLabel2,  icon;
            private JTextField nom, nom2;

                    
            
            /*
             *  Cette classes permet de construire une boite de Dialogue
             *  
             *   comportant deux champs à remplir par les noms d'équipes 
             *   
             *   elle est appelé des le lancement d'une nouvelle partie
             */
            

            
            
            
public Dialog(JFrame parent, String title, boolean modal){
	
	
       super(parent, title, modal);
       this.setSize(510, 250);
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
       this.initComponent(); 
       this.setVisible(true);

}




/**
* Initialise le contenu de la boîte
*/
private void initComponent(){
	
	
//Icone
icon = new JLabel(new ImageIcon("images/acc.jpg"));
JPanel panIcon = new JPanel();
panIcon.setBackground(Color.white);
panIcon.setLayout(new BorderLayout());
panIcon.add(icon);

//Le nom
JPanel panNom = new JPanel();
panNom.setBackground(Color.white);
panNom.setPreferredSize(new Dimension(220, 60));
nom = new JTextField();
nom.setPreferredSize(new Dimension(100, 25));
panNom.setBorder(BorderFactory.createTitledBorder("Nom de l'equipe gauche"));
nomLabel = new JLabel("Saisir un nom :");
panNom.add(nomLabel);
panNom.add(nom);

//Le nom2
JPanel panTaille = new JPanel();
panTaille.setBackground(Color.white);
panTaille.setPreferredSize(new Dimension(220, 60));
panTaille.setBorder(BorderFactory.createTitledBorder("Nom de l'equipe droite"));
nomLabel2 = new JLabel("Saisir un nom : ");

nom2 = new JTextField();

nom2.setPreferredSize(new Dimension(100, 25));
if (nom2.getText().length()==0)
panTaille.add(nomLabel2);
panTaille.add(nom2);


JPanel content = new JPanel();
content.setBackground(Color.white);
content.add(panNom);


content.add(panTaille);

JPanel control = new JPanel();
JButton okBouton  = new JButton("OK");
okBouton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0) {
	setVisible(false);
	GameFrame t=new GameFrame (nom.getText(),nom2.getText());
	
}
});
	 



JButton cancelBouton = new JButton("Annuler");
cancelBouton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0) {
System.exit(0);
}
});
control.add(okBouton);
control.add(cancelBouton);
this.getContentPane().add(panIcon, BorderLayout.WEST);
this.getContentPane().add(content, BorderLayout.CENTER);
this.getContentPane().add(control, BorderLayout.SOUTH);
}
}