package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Filet  implements Constantes
{
    
    
     private Position position;
    
    
    /**
     * Constructor for objects of class Filet
     */
    public Filet(Position position)
    {
       
       this.position=position;
       
    }

    
    public boolean penetré(Balle balle)
    {
    	
    	
    	if  ((Math.abs(balle.getPosition() - this.getPosition().getX())<30) )
   		{
   			
            return  true;
    	}
   		
    	           
    	else return false;
  
   }


    
    
     // Getters && Setters
    
	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
}
