package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class panelimage extends JPanel{

	
	
	private Joueur[] listJoueur1;
	private Joueur[] listJoueur2;
	private Balle balle;
	
	
	
	
	public panelimage(Joueur[] listJoueur1,Joueur[] listJoueur2,Balle balle) {
		
		this.listJoueur1=listJoueur1;
		this.listJoueur2=listJoueur2;
		this.balle=balle;
		
	}



	

	     /****  partie dessin (Joueurs / Supporteurs / Pelouse /Balle )   ******/


	
	
	 public void paintComponent(Graphics contexteGraphique) {
		
		 try {
			 
				Image img = ImageIO.read(new File("images/pelouse.jpg"));
			
				contexteGraphique.drawImage(img, 0, 0, this);
			    contexteGraphique.setColor(Color.BLUE);
			    for (int i=0;i<3;i++)
			    {
			    	if (listJoueur1[i].getExclu()==true) continue;
			    	 else {
			    	 contexteGraphique.fillPolygon(tabX(listJoueur1[i].getPosition().getX()),
			    			   tabY(listJoueur1[i].getPosition().getY()), 21);
			    	   }
			    }
			    contexteGraphique.setColor(Color.RED);
			    for (int i=0;i<3;i++)
			    {
			    	 if (listJoueur2[i].getExclu()==true) continue;
			    	 else {
			       contexteGraphique.fillPolygon(tabX(listJoueur2[i].getPosition().getX()),
			    		      tabY(listJoueur2[i].getPosition().getY()), 21);
			              }
			    	 
			    }
			    contexteGraphique.setColor(Color.GRAY);
			    contexteGraphique.fillOval(balle.getPosition(),balle.getPosition2(), 10,10);
			 } catch (IOException e) {
			 
			   e.printStackTrace();
			 }
				
			 
	         
	 }
	 
	 
	 
	 
	 /*
	  * 
	  *     La partie qui suit permet de dessiner les personnages 
	  */
	 
	 
	private int [] tabX (int xx) {
	      
	    int bh = (int)(40* 0.7);  // body height
	        int hh = (40 - bh) / 2;  // half head height
	        int hw = 20 / 2;  // half width
	        // définir les cordonnée de la personne
	       
	       int x=xx;
	     
	    

	            int[] xpoints = { x-3, x-hw, x-hw, x-(int)(hw*0.2)-1, x-(int)(hw*0.2)-1, x-hw, 
	                              x-hw+(int)(hw*0.4)+1, x, x+hw-(int)(hw*0.4)-1, x+hw, x+(int)(hw*0.2)+1, 
	                              x+(int)(hw*0.2)+1, x+hw, x+hw, x+3, x+(int)(hw*0.6), 
	                              x+(int)(hw*0.6), x+3, x-3, x-(int)(hw*0.6), x-(int)(hw*0.6) };
	           
	          return xpoints ;
	 }
	 
	

	private int [] tabY(int yy) {
	      
	        int bh = (int)(40* 0.7);  // body height
	        int hh = (40 - bh) / 2;  // half head height
	        int hw = 20 / 2;  // half width
	        // définir les cordonnée de la personne
	            int y=yy;
	    

	            
	            int[] ypoints = { y, y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
	                              y+(int)(bh*0.5), y+bh, y+bh, y+(int)(bh*0.65), y+bh, y+bh, 
	                              y+(int)(bh*0.5), y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
	                              y, y-hh+3, y-hh-3, y-hh-hh, y-hh-hh, y-hh-3, y-hh+3 };
	          return ypoints ;
	 }
	 
	  
        // Getters && Setters 
	
	
	
	public Joueur[] getTabPos() {
		return listJoueur1;
	}



	public void setTabPos(Joueur[] listJoueur1) {
		this.listJoueur1 = listJoueur1;
	}

	
	
}
