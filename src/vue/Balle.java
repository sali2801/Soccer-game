package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */


public class Balle  implements Constantes

{
   
   Integer position;
   Integer position2;

    /**
     * Constructor for objects of class Balle
     */
    public Balle(int position,Integer position2)
    {
        
      this.position=position;
      this.position2=position2;
    }

    /**
     * 
     *
     * @return     nouvelle position de la balle
     */
    public void bouger (int position)
    {
   
        this.position=position;
       
    }
    
    public void SedeplacerG ()
    {
        this.position=this.position-DEPLACEMENT_TIRE;
      
       
    }
    public void SedeplacerD ()
    {
         this.position=this.position+DEPLACEMENT_TIRE ;
       
    }
     
   
    
    
    
    //  Getters && Setters
    
    
    
    public int getPosition ()
    {
        return position;
    }

    public int getPosition2 ()
    {
        return position2;
    }
	
    
    
    
    
}
