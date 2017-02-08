
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Fenetre extends JFrame {

	  private JMenuBar menu = null;
	  private JMenu fichier = null;
	  private JMenuItem nouveau = null;
	
	  private JMenuItem quitter = null;
	  private JMenu apropos = null;
	  private JMenuItem apropos2 = null;
	 
	  private JPanel conteneur = new JPanel();
	  private Dimension size;
	  
	
	  
	public Fenetre(){
		
		this.setTitle("Soccer 2012");
	    this.setSize(1040, 710);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.size = new Dimension(this.getWidth(), this.getHeight());
	    
	    
	    
	    menu = new JMenuBar();
	    
	    fichier = new JMenu("Fichier");
	    
	    nouveau = new JMenuItem("Nouvelle partie");
	    nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                                                  InputEvent.CTRL_MASK));
	    nouveau.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){

				setVisible(false);
				Dialog zd = new Dialog(null, "Soccer 2012", true);
			}	    	
	    });
	    

	   
	    quitter = new JMenuItem("Quitter");
	    quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
	                                                  KeyEvent.CTRL_MASK));
	    quitter.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });

	    fichier.add(nouveau);
	    
	    fichier.addSeparator();
	    fichier.add(quitter);

	    apropos = new JMenu("À propos");
	 

	  

	    apropos2 = new JMenuItem("   ?   ");
	    apropos2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		JOptionPane.showMessageDialog(null,
							    		          "Créateur : Mallem Saliha  \nContact : as_mallem@esi.dz",
							    		          "Informations", JOptionPane.NO_OPTION);

	    	}
	    });

	   
	    apropos.add(apropos2);

	    menu.add(fichier);
	    menu.add(apropos);
	    
	    this.setJMenuBar(menu);
	 

	    this.conteneur.add(new AccueilPanel(this.size).getPanel());
	    this.setContentPane(this.conteneur);
	    
	   
	}
	
	
	
	
	
}
