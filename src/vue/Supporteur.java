package vue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * 
 * 
 * @author Mallem saliha
 * 14/06/2012
 */
public class Supporteur 

{
   
   

    /**
     * Constructor for objects of class supporteur
     */
    public Supporteur()
    {
        
    }

    /**
     * appeller lorsque  l'adveraire marque un but
     * 
     * 
     * 
     */
    public void Desesperer(String nomequipe)
    { 
    	JOptionPane  jop1 = new JOptionPane();
		 ImageIcon img = new ImageIcon("images/triste.gif");
		 jop1.showMessageDialog(null, "Supporteurs de ( "+nomequipe+" ): Hélas!", "Désespoir",
		 JOptionPane.INFORMATION_MESSAGE, img);
    }
    
    /**
     * appeller lorsque   l'equipe supporté marque un but
     *  
     * 
     */
    public void  réjouir (String nomequipe)
    { 
    	JOptionPane  jop1 = new JOptionPane();
		 ImageIcon img = new ImageIcon("images/bravo.gif");
		 jop1.showMessageDialog(null, "Supporteurs de ( "+nomequipe+" ): Youpiiiii !", "Joie",
		 JOptionPane.INFORMATION_MESSAGE, img);
    }
    
    
}
