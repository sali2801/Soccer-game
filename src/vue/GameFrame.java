package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;



/**
 * @author Mallem Saliha
 *
 * @Date  13/06/2012
 */



public class GameFrame  extends JFrame{

	
	
	
	private Dimension dim2 = new Dimension(120,330);
	private Dimension dim1 = new Dimension(1000,10);
	private Dimension dim3 = new Dimension(1000, 30);
	
	private String s=null;
	private String s1=null;
	private String s2=null;
	private String s3=null;
	private String s4=null;
	private String nom2=null;
	private String nom1=null;
	
	private JMenuBar menu = null;
	private JMenu fichier = null;
	private JMenuItem nouveau = null;
	private JMenuItem quitter = null;
	private JMenu apropos = null;
	private JMenuItem apropos2 = null;
    
	DialogueArbitre d = new DialogueArbitre (null, "Carton jaune", true);
	
	private Position[] tabPos=new Position[7];
	private Balle balle;
	private Filet filetD=new Filet(new Position(720,300));
	private Filet filetG=new Filet(new Position(60,300));
	private OptionArbitre PanneauArbite= new OptionArbitre(); ;
	private JPanel 	scorePane=new JPanel();
	private Scor scor = new Scor();
	private JLabel 	score1;
	private JLabel 	score2;
	private JLabel 	score3;
	private JLabel 	chrono;
	private OptionJouer equieDPanel= new  OptionJouer();
	private OptionJouer equieGPanel= new  OptionJouer(); 
	private Joueur[] listJoueur1 = new Joueur[3];	
	private Joueur[] listJoueur2 = new Joueur[3];
	private Arbitre arbitre=new Arbitre();
	private Entreneur entreneur1=new Entreneur();
	private Entreneur entreneur2=new Entreneur();
	private Supporteur supporteur=new Supporteur();
	private panelimage pan;
	
	 
	

	 /*
	 * deux constructeurs:
	 * 
	 * le premier : est utilisé lorsque on débute une nouvelle partie
	 * le deuxième: est utilisé lorsque on reprend le jeu après un marquage de but 
	 * 
	 */

	public GameFrame(int scor1,int scor2,String nom1,String nom2) 
	{
    	this.nom1=nom1;
    	this.nom2=nom2;
    	scor.setScorEquipe1(scor1);
		scor.setScorEquipe2(scor2);
		initier ( nom1, nom2);
	}
	public GameFrame(String nom1,String nom2) {
		this.nom1=nom1;
    	this.nom2=nom2;
		initier ( nom1,nom2);
	}

	 
	  
    private void initier (String nom,String nom2)
    {
     
	 tabPos[0]=new Position(60,  300);
	 tabPos[1]=new Position(270, 300);
	 tabPos[2]=new Position(170, 300);
	 tabPos[3]=new Position(600, 300);
	 tabPos[4]=new Position(720, 300);
	 tabPos[5]=new Position(510, 300);
	 tabPos[6]=new Position(60, 300);
	
	 balle=new Balle(tabPos[6].getX(),tabPos[6].getY());
	
	 
	
	 listJoueur1 [0]=new AttaquantED(0,  tabPos[5], null);
	 listJoueur1 [1]=new GardientED(0,   tabPos[4], null);
	 listJoueur1 [2]=new DefenseurED(0,  tabPos[3], null);
	 
	 listJoueur2 [0]=new AttaquantEG(0,  tabPos[1], null);
	 listJoueur2 [1]=new GardientEG(0,   tabPos[0], balle);
     listJoueur2 [2]=new DefenseurEG(0,  tabPos[2], null);
     
 	equieDPanel.getAvancer().setEnabled(false);
 	equieDPanel.getReculer().setEnabled(false);
 	equieDPanel.getComboRA().setEnabled(false);
 	equieDPanel.getRecuperer().setEnabled(false);
 	equieDPanel. getTirer().setEnabled(false);
 	equieDPanel. getPasser().setEnabled(false);
 	equieDPanel. getComboP().setEnabled(false);
 	equieDPanel. getHurler().setEnabled(false);
 	
 	
 	
 	 
 	equieGPanel.getAvancer().setEnabled(false);
 	equieGPanel.getReculer().setEnabled(false);
 	equieGPanel.getComboRA().setEnabled(false);
 	equieGPanel.getRecuperer().setEnabled(false);
 	equieGPanel. getTirer().setEnabled(false);
 	equieGPanel. getPasser().setEnabled(false);
 	equieGPanel. getComboP().setEnabled(false);
 	equieGPanel. getHurler().setEnabled(false);
 	
 	PanneauArbite.getGo().setEnabled(true);
 	PanneauArbite.getFin().setEnabled(false);
 	PanneauArbite.getRouge().setEnabled(false);
 	PanneauArbite.getJaune().setEnabled(false);
 	
 	pan= new panelimage(listJoueur1,listJoueur2,balle );
	 
 	score1=new JLabel(nom);
 	score2=new JLabel(" "+scor.AfficheScor(2)+" - "+scor.AfficheScor(1));
 	score3=new JLabel(" "+nom2);
	chrono=new JLabel(new ImageIcon("images/chrono.PNG"));
 	
 
   
    pan.setPreferredSize(new Dimension (1000,550));
    
    
    score1.setForeground(Color.RED);
    score2.setForeground(Color.BLACK);
    score3.setForeground(Color.blue);
    
    scorePane.add(chrono);
    scorePane.add(score1);
    scorePane.add(score2);
   
    scorePane.add(score3);
    
    
    menu = new JMenuBar();
    fichier = new JMenu("Fichier");
    
    quitter = new JMenuItem("Quitter");
    quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                                                  KeyEvent.CTRL_MASK));
    quitter.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		setVisible(false);
    		Fenetre fen = new Fenetre();
    		fen.setVisible(true);
    	}
    });

   
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

	equieDPanel.setPreferredSize(dim2);
	equieGPanel.setPreferredSize(dim2);
	PanneauArbite.setPreferredSize(new Dimension(30, 90));
	scorePane.setPreferredSize(dim3);
	
	equieDPanel.getAvancer().addActionListener(new BoutonAvanceD());
 	equieDPanel.getReculer().addActionListener(new BoutonReculeD());
 	equieDPanel.getComboRA().addActionListener(new ComboListner1Princ());
 	equieDPanel.getRecuperer().addActionListener(new RecupererListner());
 	equieDPanel. getTirer() .addActionListener(new TirerListner1());
 	equieDPanel. getPasser() .addActionListener(new PasserListner1());
 	equieDPanel. getComboP() .addActionListener(new comboPasserListner1());
 	equieDPanel. getHurler() .addActionListener(new HurlerListner1());
   
 	equieDPanel.setBackground(Color.BLACK);
 	
 	
 	
 	equieGPanel.setBackground( Color.BLACK);
   	equieGPanel.getAvancer().addActionListener(new BoutonAvanceG());
 	equieGPanel.getReculer().addActionListener(new BoutonReculeG());
 	equieGPanel.getComboRA().addActionListener(new ComboLister2Princ());
 	
 	equieGPanel.getRecuperer().addActionListener(new RecupererListner2());
 	equieGPanel. getTirer() .addActionListener(new TirerListner2());
 	equieGPanel. getPasser() .addActionListener(new PasserListner2());
 	equieGPanel. getComboP() .addActionListener(new comboPasserListner2());
 	equieGPanel. getHurler() .addActionListener(new HurlerListner2());

 	
 	PanneauArbite.getGo().addActionListener(new goListner());
 	PanneauArbite.getFin().addActionListener(new finListner());
 	PanneauArbite.getRouge().addActionListener(new rougeListner());
 	PanneauArbite.getJaune().addActionListener(new jauneListner());
				
 	this.add(scorePane,BorderLayout.NORTH);
	this.add(equieDPanel,BorderLayout.EAST);
	
	this.add(pan,BorderLayout.CENTER);
	this.add(equieGPanel,BorderLayout.WEST);
	
    this.add(PanneauArbite,BorderLayout.SOUTH);
    
    this.setTitle("Soccer 2012");
    this.setSize(1040, 710);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
 	this.setVisible(true);
   
 	
   }
	 /*
	  * ***********************************************************************************
	  *    CETTE PARTIE COMPORTE TOUTES LES CLASSES INTERNES . ELLE EST CONSERVE POUR LES 
	  * 
	  *   INTERACTIONS AVEC LES DIFFERENTS COMPOSANTS.
	  *************************************************************************************
	  */
  
    
     /*
	  *  Pour les classes : BoutonReculeD,BoutonAvanceD,BoutonReculeG,BoutonAvanceG
	  *  
	  *  on vérifier si le joueur peut:
	  *  => avancer/reculer 
	  *  => peut recuperer ou non la balle 
	  *  
	  *  Selon le cas :
	  *  => le joueur effectue ou non l'action concernées.
	  *  => on active/ desactive les boutons consernés.  
	  * 
	  */
    
	 class BoutonReculeD implements ActionListener{
		 
		 public void actionPerformed(ActionEvent arg0) {
			 if(s.equals("attaquant"))
					
			 {
				
		     	if (equieDPanel.getAvancer().isEnabled()==false)  
		    	    equieDPanel.getAvancer().setEnabled(true);
			    if (! listJoueur1 [0].CanMoveBack()) equieDPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur1  [0].recule ();
			          equieDPanel.getReculer().setEnabled(true);
			    }
			    
			   
			    	if (CanRecup (listJoueur2,s1)==true)	
		 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
				   
			    
			   
			    
			    
			    if (listJoueur1 [0].PeutRecuperer(listJoueur1,balle)== true)
				   {
				 
			    	 equieDPanel.getRecuperer().setEnabled(true);
  			    }
	 		    else
	    		    {
				    	equieDPanel.getRecuperer().setEnabled(false);
				    }
		     }
			 if(s.equals("gardient"))
					
			 {
		     	if (equieDPanel.getAvancer().isEnabled()==false)  
		    	    equieDPanel.getAvancer().setEnabled(true);
			    if (! listJoueur1 [1].CanMoveBack()) equieDPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur1  [1].recule ();
			          equieDPanel.getReculer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur2,s1)==true)	
					 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
			    if (listJoueur1 [1].PeutRecuperer(listJoueur1,balle)== true)
			    {
			    	equieDPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieDPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			 if(s.equals("defenseur"))
					
			 {
		     	if (equieDPanel.getAvancer().isEnabled()==false)  
		    	    equieDPanel.getAvancer().setEnabled(true);
			    if (! listJoueur1 [2].CanMoveBack()) equieDPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur1  [2].recule ();
			          equieDPanel.getReculer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur2,s1)==true)	
					 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
			    if (listJoueur1 [2].PeutRecuperer(listJoueur1,balle)== true)
			    {
			    	equieDPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieDPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			
		  repaint();
		 }
		 }
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 
	 class BoutonAvanceD implements ActionListener{
		 
		 
		 public void actionPerformed(ActionEvent arg0) {
			 if(s.equals("attaquant"))
				
			 {
		     	if (equieDPanel.getReculer().isEnabled()==false)  
		    	    equieDPanel.getReculer().setEnabled(true);
			    if (! listJoueur1 [0].CanMove()) equieDPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur1 [0].avance();
			        equieDPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur2,s1)==true)	
					 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
			    if (listJoueur1 [0].PeutRecuperer(listJoueur1,balle)== true)
			    {
			    	equieDPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieDPanel.getRecuperer().setEnabled(false);
			    }
		     }
			 if(s.equals("gardient"))
					
			 {
		     	if (equieDPanel.getReculer().isEnabled()==false)  
		    	    equieDPanel.getReculer().setEnabled(true);
			    if (! listJoueur1 [1].CanMove()) equieDPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur1 [1].avance();
			        equieDPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur2,s1)==true)	
					 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
			    if (listJoueur1 [1].PeutRecuperer(listJoueur1,balle)== true)
			    {
			    	equieDPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieDPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			 if(s.equals("defenseur"))
					
			 {
		     	if (equieDPanel.getReculer().isEnabled()==false)  
		    	    equieDPanel.getReculer().setEnabled(true);
			    if (! listJoueur1 [2].CanMove()) equieDPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur1 [2].avance();
			        equieDPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur2,s1)==true)	
					 
			    	 equieGPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieGPanel.getRecuperer().setEnabled(false);
			    if (listJoueur1 [2].PeutRecuperer(listJoueur1,balle)== true)
			    {
			    	equieDPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieDPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			
			repaint();
		 }
		 }	
	 
	 
	 
       /*************************************************************************************/
	 
	 
	 
	 
	 
	 class BoutonReculeG implements ActionListener{
		
		 public void actionPerformed(ActionEvent arg0) {
			 if(s1.equals("attaquant"))
					
			 {
		     	if (equieGPanel.getAvancer().isEnabled()==false)  
		    	    equieGPanel.getAvancer().setEnabled(true);
			    if (! listJoueur2 [0].CanMoveBack()) equieGPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur2  [0].recule ();
			          equieGPanel.getReculer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
					 
			    	 equieDPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [0].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }
			 if(s1.equals("gardient"))
					
			 {
		     	if (equieGPanel.getAvancer().isEnabled()==false)  
		    	    equieGPanel.getAvancer().setEnabled(true);
			    if (! listJoueur2 [1].CanMoveBack()) equieGPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur2  [1].recule ();
			          equieGPanel.getReculer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
					 
			    	 equieDPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [1].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			 if(s1.equals("defenseur"))
					
			 {
		     	if (equieGPanel.getAvancer().isEnabled()==false)  
		    	    equieGPanel.getAvancer().setEnabled(true);
			    if (! listJoueur2 [2].CanMoveBack()) equieGPanel.getReculer().setEnabled(false);
			    else
			    {     listJoueur2  [2].recule ();
			          equieGPanel.getReculer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
					 
			    	 equieDPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [2].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			
		  repaint();
		 }
		 }
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 class BoutonAvanceG implements ActionListener{
		
		 public void actionPerformed(ActionEvent arg0) {
			 if(s1.equals("attaquant"))
				
			 {
		     	if (equieGPanel.getReculer().isEnabled()==false)  
		    	    equieGPanel.getReculer().setEnabled(true);
			    if (! listJoueur2 [0].CanMove()) equieGPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur2 [0].avance();
			        equieGPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
			    {	  System.out.println("je avanceG if ");
			    	 equieDPanel.getRecuperer().setEnabled(true);
			    }
	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [0].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }
			 if(s1.equals("gardient"))
					
			 {
		     	if (equieGPanel.getReculer().isEnabled()==false)  
		    	    equieGPanel.getReculer().setEnabled(true);
			    if (! listJoueur2 [1].CanMove()) equieGPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur2 [1].avance();
			        equieGPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
					 
			    	 equieDPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [1].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			 if(s1.equals("defenseur"))
					
			 {
		     	if (equieGPanel.getReculer().isEnabled()==false)  
		    	    equieGPanel.getReculer().setEnabled(true);
			    if (! listJoueur2 [2].CanMove()) equieGPanel.getAvancer().setEnabled(false);
			    else
			    {
			    	listJoueur2 [2].avance();
			        equieGPanel.getAvancer().setEnabled(true);
			    }
			    if (CanRecup (listJoueur1,s)==true)	
					 
			    	 equieDPanel.getRecuperer().setEnabled(true);

	 		        else
	    		   
				    	equieDPanel.getRecuperer().setEnabled(false);
			    if (listJoueur2 [2].PeutRecuperer(listJoueur2,balle)== true)
			    {
			    	equieGPanel.getRecuperer().setEnabled(true);

			    }
			    else
			    {
			    	equieGPanel.getRecuperer().setEnabled(false);
			    }
		     }  
			
			repaint();
		 }
		 }	
	 
	 /*
	  *  Pour les classes : ComboListner1Princ,ComboLister2Princ
	  *  
	  *  Ce sont des classes qui contrôlent le premier combo principale,
	  * 
	  *  en vérifiant si le joueur peut effectuer les différentes taches qui lui sont confier 
	  *  
	  *  selon le cas les bouton sont activés/désactivés.
	  * 
	  */


	 class ComboListner1Princ implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
		 
			s= equieDPanel.getComboRA().getSelectedItem().toString();
			

			 if(s.equals("attaquant"))
					
			 {
		     	
			    if ( listJoueur1 [0].CanMove()==true) equieDPanel.getAvancer().setEnabled(true);
			    else equieDPanel.getAvancer().setEnabled(false);
			    
			    if ( listJoueur1 [0].CanMoveBack()==true) equieDPanel.getReculer().setEnabled(true);
			    else equieDPanel.getReculer().setEnabled(false);
			    
			    if ( listJoueur1 [0].getBalle()==null) 
			    {
			    	
			    	equieDPanel.getComboP().setEnabled(false);
			    	equieDPanel.getTirer().setEnabled(false);
			   
			    }
			    
			    else
			    { 
			    	
			        equieDPanel.getComboP().setEnabled(true);
			        equieDPanel.getTirer().setEnabled(true);
				   
			     }
			    if (listJoueur1 [0].PeutRecuperer(listJoueur1, balle) == true)
			    	 equieDPanel.getRecuperer().setEnabled(true);
			    else  equieDPanel.getRecuperer().setEnabled(false);
			    
		      }
			 if(s.equals("gardient"))
					
			 {
				  if ( listJoueur1 [1].CanMove()==true) equieDPanel.getAvancer().setEnabled(true);
				    else equieDPanel.getAvancer().setEnabled(false);
				    
				    if ( listJoueur1 [1].CanMoveBack()==true) equieDPanel.getReculer().setEnabled(true);
				    else equieDPanel.getReculer().setEnabled(false);
				    
				    if ( listJoueur1 [1].getBalle()==null) 
				    {
				    	
				    	equieDPanel.getComboP().setEnabled(false);
				    	equieDPanel.getTirer().setEnabled(false);
				    	
				    }
				    
				    else
				    { 
				    	
				        equieDPanel.getComboP().setEnabled(true);
				        equieDPanel.getTirer().setEnabled(true);
					 
				     }
				    if (listJoueur1 [1].PeutRecuperer(listJoueur1, balle) == true)
				    	 equieDPanel.getRecuperer().setEnabled(true);
				    else  equieDPanel.getRecuperer().setEnabled(false);
				   
		     }  
			 if(s.equals("defenseur"))
					
			 {

				  if ( listJoueur1 [2].CanMove()==true) equieDPanel.getAvancer().setEnabled(true);
				    else equieDPanel.getAvancer().setEnabled(false);
				    
				    if ( listJoueur1 [2].CanMoveBack()==true) equieDPanel.getReculer().setEnabled(true);
				    else equieDPanel.getReculer().setEnabled(false);
				    
				    if ( listJoueur1 [2].getBalle()==null) 
				    {
				    	
				    	equieDPanel.getComboP().setEnabled(false);
				    	equieDPanel.getTirer().setEnabled(false);
				    
				    	
				    }
				    
				    else
				    { 
				    	
				        equieDPanel.getComboP().setEnabled(true);
				        equieDPanel.getTirer().setEnabled(true);
				
				     }
				    if (listJoueur1 [2].PeutRecuperer(listJoueur1, balle) == true)
				    	 equieDPanel.getRecuperer().setEnabled(true);
				    else  equieDPanel.getRecuperer().setEnabled(false);
		     }  
		 }
		 }
	 
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 
	 class ComboLister2Princ implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
				s1= equieGPanel.getComboRA().getSelectedItem().toString();
				

				 if(s1.equals("attaquant"))
						
				 {
			     	
				    if ( listJoueur2 [0].CanMove()==true) equieGPanel.getAvancer().setEnabled(true);
				    else equieGPanel.getAvancer().setEnabled(false);
				    
				    if ( listJoueur2 [0].CanMoveBack()==true) equieGPanel.getReculer().setEnabled(true);
				    else equieGPanel.getReculer().setEnabled(false);
				    
				    if ( listJoueur2 [0].getBalle()==null) 
				    {
				    	
				    	equieGPanel.getComboP().setEnabled(false);
				    	equieGPanel.getTirer().setEnabled(false);
				   
				    }
				    
				    else
				    { 
				    	
				        equieGPanel.getComboP().setEnabled(true);
				        equieGPanel.getTirer().setEnabled(true);
					   
				     }
				    if (listJoueur2 [0].PeutRecuperer(listJoueur2, balle) == true)
				    	 equieGPanel.getRecuperer().setEnabled(true);
				    else  equieGPanel.getRecuperer().setEnabled(false);
				    
			      }
				 if(s1.equals("gardient"))
						
				 {
					  if ( listJoueur2 [1].CanMove()==true) equieGPanel.getAvancer().setEnabled(true);
					    else equieGPanel.getAvancer().setEnabled(false);
					    
					    if ( listJoueur2 [1].CanMoveBack()==true) equieGPanel.getReculer().setEnabled(true);
					    else equieGPanel.getReculer().setEnabled(false);
					    
					    if ( listJoueur2 [1].getBalle()==null) 
					    {
					    	
					    	equieGPanel.getComboP().setEnabled(false);
					    	equieGPanel.getTirer().setEnabled(false);
					    	
					    }
					    
					    else
					    { 
					    	
					        equieGPanel.getComboP().setEnabled(true);
					        equieGPanel.getTirer().setEnabled(true);
						 
					     }
					    if (listJoueur2 [1].PeutRecuperer(listJoueur2, balle) == true)
					    	 equieGPanel.getRecuperer().setEnabled(true);
					    else  equieGPanel.getRecuperer().setEnabled(false);
					   
			     }  
				 if(s1.equals("defenseur"))
						
				 {

					  if ( listJoueur2 [2].CanMove()==true) equieGPanel.getAvancer().setEnabled(true);
					    else equieGPanel.getAvancer().setEnabled(false);
					    
					    if ( listJoueur2 [2].CanMoveBack()==true) equieGPanel.getReculer().setEnabled(true);
					    else equieGPanel.getReculer().setEnabled(false);
					    
					    if ( listJoueur2 [2].getBalle()==null) 
					    {
					    	
					    	equieGPanel.getComboP().setEnabled(false);
					    	equieGPanel.getTirer().setEnabled(false);
					    
					    	
					    }
					    
					    else
					    { 
					    	
					        equieGPanel.getComboP().setEnabled(true);
					        equieGPanel.getTirer().setEnabled(true);
					
					     }
					    if (listJoueur2 [2].PeutRecuperer(listJoueur2, balle) == true)
					    	 equieGPanel.getRecuperer().setEnabled(true);
					    else  equieGPanel.getRecuperer().setEnabled(false);
			     }  
		 }
		 }
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 /*
	  *  Pour les classes : TirerListner1,TirerListner2
	  *  
	  *  Suite à un tire de ballon , le joueur n'a pas le droit :
	  *  
	  *  => ni de la  passer ni de la  tirer. Pour cela les boutons consternés seront grisés.
	  *  
	  *  De plus, le tire peut provoqué un marquage de but ce qui déclenche le cris des supporteur
	  * 
	  */

	 class TirerListner1 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			
			 equieDPanel.getTirer().setEnabled(false);
			 equieDPanel.getPasser().setEnabled(false);
			 equieDPanel.getComboP().setEnabled(false);
			 equieDPanel.getRecuperer().setEnabled(true);
			
			 if(s.equals("attaquant"))
				 
			 {
				 listJoueur1 [0].tirerBalle();
				  balle.SedeplacerG();
				 repaint();
				 if (filetG.penetré(balle)==true) {
					 scor.Increment(1);
					 score2.setText(" "+scor.AfficheScor(2)+" - "+scor.AfficheScor(1));
					 supporteur.réjouir(nom1);
					 supporteur.Desesperer(nom2);
					 
					 setVisible(false);
					 GameFrame t=new GameFrame (scor.getScorEquipe1(),scor.getScorEquipe2(),score1.getText(),score3.getText());

				 }
				 
			     
			 }
			 if(s.equals("gardient"))
					
			 {
				 listJoueur1 [1].tirerBalle();
				 listJoueur1 [1].setBalle(null);
				 balle.SedeplacerG();
				 repaint();
		     } 
			 
			 if(s.equals("defenseur"))
					
			 {
				 listJoueur1 [2].tirerBalle();
				 listJoueur1 [2].setBalle(null);
				 balle.SedeplacerG();
				 repaint();
		     }  
			
		 }
	 } 
	 
	 
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 
	 class TirerListner2 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
				
			 equieGPanel.getTirer().setEnabled(false);
			 equieGPanel.getPasser().setEnabled(false);
			 equieGPanel.getComboP().setEnabled(false);
			 equieGPanel.getRecuperer().setEnabled(true);
			
			 if(s1.equals("attaquant"))
				 
			 {
				 listJoueur2 [0].tirerBalle();
				  balle.SedeplacerD();
				  
				 repaint();
				 if (filetG.penetré(balle)==true) {
					 scor.Increment(2);
					 score2.setText(" "+scor.AfficheScor(2)+" - "+scor.AfficheScor(1));
					 supporteur.réjouir(nom2);
					 supporteur.Desesperer(nom1);
					 
					 setVisible(false);
					 GameFrame t=new GameFrame (scor.getScorEquipe1(),scor.getScorEquipe2(),score1.getText(),score3.getText());
					
				 }
				 
			     
			 }
			 if(s1.equals("gardient"))
					
			 {
				 listJoueur2 [1].tirerBalle();
				 listJoueur2 [1].setBalle(null);
				 balle.SedeplacerD();
				 repaint();
		     } 
			 
			 if(s1.equals("defenseur"))
					
			 {
				 listJoueur2 [2].tirerBalle();
				 listJoueur2 [2].setBalle(null);
				 balle.SedeplacerD();
				 repaint();
		     }  
			
		 }
		 }
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 /*
	    *  Lorsque l'arbitre donne son coup d'envoi ,cette classe permet:
	    *  
	    *   => Activé  certain composants de la table d'outil du joueur
	    *   
	    *   => Activé  les composants de la table d'outil de l'arbitre 
	    *   
	    *   => Désactivé le bouton qui permet de donner le coup d'envoi
	    *  
	    */

	  class goListner implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 

			 equieGPanel.getComboRA().setEnabled(true);
			 equieGPanel.getHurler().setEnabled(true);
			 equieDPanel.getHurler().setEnabled(true);
			 equieDPanel.getComboRA().setEnabled(true);
			 PanneauArbite.getFin().setEnabled(true);
			 PanneauArbite.getGo().setEnabled(false);
			 PanneauArbite.getRouge().setEnabled(true);
			 PanneauArbite.getJaune().setEnabled(true);
			 
		 }
		 }
	 
	 
	  
	  /*************************************************************************************/
	  
	  /*
	    *  Lorsque l'arbitre decide de donner un carton rouge à un joueur ,cette classe permet:
	    *  
	    *   => d'ouvrir un panneau qui comporte les noms des joueurs
	    *   
	    *   => l'arbitre fait son choix.
	    *   
	    *   => le joueur sera exclu (invisible sur la pelouse )
	    *  
	    */
	  		 		 
	
	 class rougeListner implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			
			
			 String JoueurSelectionner =d.showDialog();
			 message(JoueurSelectionner);

			 } 
		   public void message (String JoueurSelectionner)
		   {
			 
				
			   if(JoueurSelectionner.equals("Attaquant D"))
					
				 {  
					 
				         listJoueur1[0].setExclu(true);
					     d.getJoueur1().setEnabled(false);
					     for (int i=0;i<3;i++)
					     {
					       if (equieDPanel.getComboRA().getItemAt(i).toString() =="attaquant")
					       {
					    	   equieDPanel.getComboRA().removeItemAt(i);
					           break;
					       }
					     }
						arbitre.DonnerCartonRouge();
					
					 repaint();
				 }
				 if(JoueurSelectionner.equals("Gardient D"))
						
				 {
					  listJoueur1[1].setExclu(true);
				     d.getJoueur3().setEnabled(false);
				     for (int i=0;i<3;i++)
				     {
				       if (equieDPanel.getComboRA().getItemAt(i).toString() =="gardient")
				       {
				    	   equieDPanel.getComboRA().removeItemAt(i);
				           break;
				       }
				     }
				     arbitre.DonnerCartonRouge();
				
				 repaint();
			     } 
				 
				 if(JoueurSelectionner.equals("Defenseur D"))
						
				 {
					  listJoueur1[2].setExclu(true);
					  d.getJoueur2().setEnabled(false);
				     
				     for (int i=0;i<3;i++)
				     {
				       if (equieDPanel.getComboRA().getItemAt(i).toString() =="defenseur")
				       {
				    	   equieDPanel.getComboRA().removeItemAt(i);
				           break;
				       }
				     }
				     arbitre.DonnerCartonRouge();
				
				     repaint();
			     }  
				 if(JoueurSelectionner.equals("Attaquant G"))
						
				 {
					
					 listJoueur2[0].setExclu(true);
					 d.getJoueur4().setEnabled(false);
				     for (int i=0;i<3;i++)
				     {
				       if (equieGPanel.getComboRA().getItemAt(i).toString() =="attaquant")
				       {
				    	   equieGPanel.getComboRA().removeItemAt(i);
				           break;
				       }
				     }
				     arbitre.DonnerCartonRouge();
				
				     repaint();
				 }
				 if(JoueurSelectionner.equals("Gardient G"))
						
				 {
					 listJoueur2[1].setExclu(true);
				     d.getJoueur6().setEnabled(false);
				     for (int i=0;i<3;i++)
				     {
				       if (equieGPanel.getComboRA().getItemAt(i).toString() =="gardient")
				       {
				    	   equieGPanel.getComboRA().removeItemAt(i);
				           break;
				       }
				     }
				     arbitre.DonnerCartonRouge();
				
				     repaint();
			     } 
				 
				 if(JoueurSelectionner.equals("Defenseur G"))
						
				 {
					 listJoueur2[2].setExclu(true);
				      d.getJoueur5().setEnabled(false);
				   
				     for (int i=0;i<3;i++)
				     {
				       if (equieGPanel.getComboRA().getItemAt(i).toString() =="defenseur")
				       {
				    	   equieGPanel.getComboRA().removeItemAt(i);
				           break;
				       }
				     }
				     arbitre.DonnerCartonRouge();
				
				     repaint();
			     }
			   
		   }
		   
	 
		 }
	 
	 
	 
	 
	    /*************************************************************************************/
	 
	 
	 
	   /*
	    *  Lorsque l'arbitre decide de finirle match ,cette classe permet:
	    *  
	    *   => d'afficher le score final
	    *   
	    *   => demander à l'utilisateur s'il veut jouer une nouvelle partie
	    *   
	    */
	 
	 
	 class finListner implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,"Scor final "+scor.getScorEquipe1()+"-"+scor.getScorEquipe2()+
					          ". Voulez vous lancer une nouvelle partie ?", "Lancer nouvelle partie ?",
			                  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			 
			 
			if(option == JOptionPane.OK_OPTION)
			{
				setVisible(false);
				Dialog zd = new Dialog(null, "Soccer 2012", true);
			}
			else System.exit(0);
		 }
		 }
	 
	 
	 
	   /*************************************************************************************/
	 

	   /*
	    *  Lorsque l'arbitre décide de donner un carton jaune à un joueur ,cette classe permet:
	    *  
	    *   => d'ouvrir un panneau qui comporte les noms des joueurs
	    *   
	    *   => l'arbitre fait son choix.
	    *   
	    *   le joueur aura dans son compte un carton jaune;
	    *   
	    *   si de plus il possède une déjà , alors on est dans le cas au-dessus (Carton Rouge )
	    */

	 
	 class jauneListner implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
		
			
		
			 String JoueurSelectionner = d.showDialog();
			 arbitre.DonnerCartonJaune ();
				
				 if(JoueurSelectionner.equals("Attaquant D"))
						
				 {  
					 
					 arbitre.CartonJaune("Attaquant D");
					
					 if  (arbitre.getMapCarton().get("Attaquant D").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
						 
					 }
					 
				 }
				 if(JoueurSelectionner.equals("Gardient D"))
						
				 { 
					  arbitre.CartonJaune("Gardient D");
					 if  (arbitre.getMapCarton().get("Gardient D").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
					 }
			     } 
				 
				 if(JoueurSelectionner.equals("Defenseur D"))
						
				 {    arbitre.CartonJaune("Defenseur D");
					 if  (arbitre.getMapCarton().get("Defenseur D").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
						
					 }
			     }  
				 if(JoueurSelectionner.equals("Attaquant G"))
						
				 {     arbitre.CartonJaune("Attaquant G");
					 if  (arbitre.getMapCarton().get("Attaquant G").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
						 
					 }
				 }
				 if(JoueurSelectionner.equals("Gardient G"))
						
				 {   
					 arbitre.CartonJaune("Gardient G");
					 if  (arbitre.getMapCarton().get("Gardient G").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
						 
					 }
			     } 
				 
				 if(JoueurSelectionner.equals("Defenseur G"))
						
				 {    
					 arbitre.CartonJaune("Defenseur G");
					 if  (arbitre.getMapCarton().get("Defenseur G").equals(2))
					 {
						 new rougeListner().message(JoueurSelectionner);
						
						 
					 }
			     }  
			 
              }
		 }
	 
	 
	 
	 
	  /*************************************************************************************/
	 
	 
	 /*
	  *  Pour les classes : PasserListner1,PasserListner2
	  *  
	  *  le joueur tire la balle, ce qui provoque 
	  *  
	  *  => le  deplacement de la balle  à une distance fixé .
	  *   
	  *  => le joueur n'a plus  le droit de faire un passage de ballon 
	  * 
	  *    par conséquent le bouton concerné sera en gris
	  * 
	  */
	 
	 class PasserListner1 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			
			 if(s.equals("attaquant"))
					
			 {
				 if(s2.equals("gardient"))
						
				 {
					 listJoueur1 [1].AttraperBalle( listJoueur1 [0].getBalle());
					 balle.bouger(listJoueur1[1].getPosition().getX());
					 listJoueur1 [0].tirerBalle();
					
					 equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
					
			     }  
				 if(s2.equals("defenseur"))
						
				 {
					 listJoueur1 [2].AttraperBalle( listJoueur1 [0].getBalle());
					 balle.bouger(listJoueur1[2].getPosition().getX());
					 listJoueur1 [0].tirerBalle();
					
					 equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
			     } 
			   
		     }
			 if(s.equals("gardient"))
					
			 {
				 if(s2.equals("attaquant"))
						
				 {
					 listJoueur1 [0].AttraperBalle( listJoueur1 [1].getBalle());
					 balle.bouger(listJoueur1[0].getPosition().getX());
					 listJoueur1 [1].tirerBalle();
				
					 equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
					 
					
			     }   
				 if(s2.equals("defenseur"))
						
				 {
					 listJoueur1 [2].AttraperBalle( listJoueur1 [1].getBalle());
					 balle.bouger(listJoueur1[2].getPosition().getX());
					 listJoueur1 [1].tirerBalle();
					 equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
					
			     }  
		     }  
			 if(s.equals("defenseur"))
					
			 {
				 if(s2.equals("attaquant"))
						
				 {
					 listJoueur1 [0].AttraperBalle( listJoueur1 [2].getBalle());
					 balle.bouger(listJoueur1[0].getPosition().getX());
					 listJoueur1 [2].tirerBalle();
				     equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
					
					
			     }   
				 if(s2.equals("gardient"))
						
				 {
					 listJoueur1 [1].AttraperBalle( listJoueur1 [2].getBalle());
					 balle.bouger(listJoueur1[1].getPosition().getX());
					 listJoueur1 [2].tirerBalle();
				     equieDPanel.getPasser().setEnabled(false);
					 equieDPanel.getTirer().setEnabled(false);
					 equieDPanel.getComboP().setEnabled(false);
					 repaint();
					
					
			     }   
		     }  
			 
				
		 }
		 }
	 
	 
	 
	 
	  /*************************************************************************************/
	 
	 
	 
	 
	 class PasserListner2 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
				
			 if(s1.equals("attaquant"))
					
			 {
				 if(s3.equals("gardient"))
						
				 {
					 listJoueur2 [1].AttraperBalle( listJoueur2 [0].getBalle());
					 balle.bouger(listJoueur2[1].getPosition().getX());
					 listJoueur2 [0].tirerBalle();
					
					 equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
					
			     }  
				 if(s3.equals("defenseur"))
						
				 {
					 listJoueur2 [2].AttraperBalle( listJoueur2 [0].getBalle());
					 balle.bouger(listJoueur2[2].getPosition().getX());
					 listJoueur2 [0].tirerBalle();
					
					 equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
			     } 
			   
		     }
			 if(s1.equals("gardient"))
					
			 {
				
				 if(s3.equals("attaquant"))
					
				 {
					 listJoueur2 [0].AttraperBalle( listJoueur2 [1].getBalle());
					 balle.bouger(listJoueur2[0].getPosition().getX());
					 listJoueur2 [1].tirerBalle();
				
					 equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
					 
					
			     }   
				 if(s3.equals("defenseur"))
						
				 {
					 listJoueur2 [2].AttraperBalle( listJoueur2 [1].getBalle());
					 balle.bouger(listJoueur2[2].getPosition().getX());
					 listJoueur2 [1].tirerBalle();
					  equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
					
			     }  
		     }  
			 if(s1.equals("defenseur"))
					
			 {
				 if(s3.equals("attaquant"))
						
				 {
					 listJoueur2 [0].AttraperBalle( listJoueur2 [2].getBalle());
					 balle.bouger(listJoueur2[0].getPosition().getX());
					 listJoueur2 [2].tirerBalle();
					 equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
					
					
			     }   
				 if(s3.equals("gardient"))
						
				 {
					 listJoueur2 [1].AttraperBalle( listJoueur2 [2].getBalle());
					 balle.bouger(listJoueur2[1].getPosition().getX());
					 listJoueur2 [2].tirerBalle();
					 equieGPanel.getPasser().setEnabled(false);
					 equieGPanel.getTirer().setEnabled(false);
					 equieGPanel.getComboP().setEnabled(false);
					 repaint();
					
					
			     }   
		     }  
			 
				
		 }
		 }
	 
	 
	  /*************************************************************************************/
	 
	 /*
	  *  Pour les classes : comboPasserListner1 ,comboPasserListner2
	  *  
	  *  Avant que le bouton "tirer" soit active, le joueur doit choisir  
	  *  
	  *  à qui il va tirer (un coéquipier)
	  *   
	  * 
	  */
	 
	 class comboPasserListner1 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			 
			 s2= equieDPanel.getComboP().getSelectedItem().toString();
			if(!(s2.equals(s)))
			 equieDPanel.getPasser().setEnabled(true);
			
			
		 }
		 }
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 class comboPasserListner2 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			 s3= equieGPanel.getComboP().getSelectedItem().toString();
			 
				if(!(s3.equals(s)))
				 equieGPanel.getPasser().setEnabled(true);
				 
		 }
		 }
	 
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 
	 /*
	  *  Pour les classes : RecupererListner ,RecupererListner2
	  *  
	  *  elles permettent de recuperer la balle soit :
	  *  
	  *  => à partir d'un adversaire ; cela dit, "ampecher l'adversaire "
	  *  
	  *  => ou bien la balle se trouve seule sur la pelouse.
	  *  
	  */
	
	 
	 class RecupererListner implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
				 if(s.equals("attaquant"))
						
				 {
					    
				     listJoueur1 [0].RecupererBalle(listJoueur2, balle); 
				     equieDPanel.getTirer().setEnabled(true);
				     equieDPanel.getComboP().setEnabled(true);
				     equieDPanel.getRecuperer().setEnabled(false);
				     repaint();
				   
			      }
				 if(s.equals("gardient"))
						
				 {
					 listJoueur1 [1].RecupererBalle(listJoueur2, balle); 
					 equieDPanel.getComboP().setEnabled(true);
				     equieDPanel.getTirer().setEnabled(true);
				     repaint();
					   					   
			     }  
				 if(s.equals("defenseur"))
						
				 {
				 	 listJoueur1 [2].RecupererBalle(listJoueur2, balle); 
				 	 equieDPanel.getComboP().setEnabled(true);
				     equieDPanel.getTirer().setEnabled(true);
				     equieDPanel.getRecuperer().setEnabled(false);
				     repaint();
			    }
		 }
		 }
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 

	 class RecupererListner2 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
				 if(s1.equals("attaquant"))
						
				 {
					    
				     listJoueur2 [0].RecupererBalle(listJoueur1, balle); 
				     equieGPanel.getTirer().setEnabled(true);
				     equieGPanel.getComboP().setEnabled(true);
				     equieGPanel.getRecuperer().setEnabled(false);
				     repaint();
				   
			      }
				 if(s1.equals("gardient"))
						
				 {
					 listJoueur2 [1].RecupererBalle(listJoueur1, balle); 
					 equieGPanel.getComboP().setEnabled(true);
				     equieGPanel.getTirer().setEnabled(true);
				     repaint();
					   					   
			     }  
				 if(s1.equals("defenseur"))
						
				 {
				 	 listJoueur2 [2].RecupererBalle(listJoueur1, balle); 
				 	 equieGPanel.getComboP().setEnabled(true);
				     equieGPanel.getTirer().setEnabled(true);
				     equieGPanel.getRecuperer().setEnabled(false);
				     repaint();
			    }
		 }
		 }
	 
	 
	 
	 
	 /*************************************************************************************/
	 
	 

     /*
	  *  Pour les classes : HurlerListner1 ,HurlerListner2
	  *  
	  *  elles permettent aux entraineurs des deux équipes d'exprimer leur avis en demandant 
	  *  
	  *  à leur joueurs d'avancer; cela se traduit par une boite de dialogue
	  *  
	  */

	 
	 class HurlerListner1 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 entreneur2.hurler(listJoueur2);
				repaint();
		 } 
		 }
	 
	 
	 
	 /*************************************************************************************/
	 
	 
	 
	 
	 
	 class HurlerListner2 implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 entreneur2.hurler(listJoueur2);
				repaint();
		 } 
		 }
	 
	 
	 /*************************************************************************************/
	 
	 
	 /*
	  *  Cette classe : est privé 
	  *  
	  *  elles permettent de contrôler à chaque fois si le jouer
	  *  
	  *   peut récupérer ou non la balle. Ceci se fait en vérifient la distance joueur-balle
	  *  
	  *  
	  */

      private boolean CanRecup (Joueur[] listJoueur,String string){
		
    	
          if( (string=="attaquant") && listJoueur[0].PeutRecuperer(listJoueur, balle)==true)
          {
        	 
        	 return true; 
        	
          }
          else {
           if( (string=="gardient") && listJoueur[1].PeutRecuperer(listJoueur, balle)==true)
           { 
        	   return true;
        	}
           else {
        	   if ( (string=="defenseur") && listJoueur[2].PeutRecuperer(listJoueur, balle)==true)
        		   return true;
        	   else return false;
        	   }
        	

          } 
         
    	    
	 }
	
	
	
}
