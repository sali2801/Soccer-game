package vue;

import javax.swing.JOptionPane;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Entreneur 
{
    
   
    
    
	/*
     * le hurlement de l'entraineur se traduit par une boite de dialogue
     *  
     * il provoque un avancement de tout les joueurs
     */
    

   
    public void  hurler(Joueur [] listJoueur  )
    {
    	 JOptionPane jop2;
		 
		   jop2 = new JOptionPane();
		   jop2.showMessageDialog(null, "Avanceeeez !", "Hurlement de l'entreneur",
		   JOptionPane.WARNING_MESSAGE);
			for (int i=0; i< listJoueur.length;i++)
			{
				
				if (listJoueur [i].CanMove()==true)
					listJoueur [i].avance();
			}
    }
  
   
   
}
