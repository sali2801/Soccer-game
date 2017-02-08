package vue;

import java.util.HashMap;

import javax.swing.JOptionPane;


/**
 * 
 * @author Mallem saliha
 * @Date   13/06/2012
 */


public class Arbitre 
{
    
    
    private HashMap mapCarton ;
    
        
    public Arbitre()

    {
    	mapCarton=new HashMap();
        mapCarton.put( "Attaquant D",new Integer(0));
        mapCarton.put( "Gardient D",new Integer(0));
        mapCarton.put( "Defenseur D",new Integer(0));
        mapCarton.put("Attaquant G",new Integer(0));
        mapCarton.put( "Gardient G",new Integer(0));
        mapCarton.put( "Defenseur G",new Integer(0)); 
    }

    
    
    
    public void CartonJaune(String string)
    {   
    	int x=0;
    	
    	
    	x=getnbCarton(string).intValue();
    	mapCarton.remove(string);
		mapCarton.put(string,new Integer(x+1));
		 
    }
   
    
    
   public Integer getnbCarton(String string)
   {
	  return  (Integer) mapCarton.get(string);
	   
   }
      
      	
	
	public void DonnerCartonJaune ()
	    {
	    	
			 JOptionPane jop2;
			
	    	//Boîte du message préventif
			 jop2 = new JOptionPane();
			 jop2.showMessageDialog(null, "carton jaune !", " Carton jaune",
			 JOptionPane.WARNING_MESSAGE);
	    }
	 
    public void DonnerCartonRouge ()
    {
    	 JOptionPane jop2;
    	 
    	 //Boîte du message préventif
		 jop2 = new JOptionPane();
		 jop2.showMessageDialog(null, "carton rouge, le joueur est exclu !", " Carton Rouge",
		 JOptionPane.WARNING_MESSAGE);
    }
    
    
    
    
    
   
      // Getters && Setters
    
    public HashMap getMapCarton() {
		return this.mapCarton;
	}

	public void setMapCarton(HashMap mapCarton) {
		this.mapCarton = mapCarton;
	}
   
  
  
    
}

