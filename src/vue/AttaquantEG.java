package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class AttaquantEG extends Joueur{
    
     /**
     * Constructor for objects of class Attaquant
     */
    public AttaquantEG(int numéro,Position position,Balle balle)
    {
        
        super(position,balle);
    
    }

    public void avance ()
    {
        
          this.getPosition().setX(this.getPosition().getX()+DEPLACEMENT);
           if (this.balle!=null) balle.bouger(this.getPosition().getX());
                  
        
   }
   
    
    public void recule ()
    {
        
       this.getPosition().setX(this.getPosition().getX()-DEPLACEMENT);
       if (this.balle!=null) balle.bouger(this.getPosition().getX());
             
        
   }
    
    
    
    public boolean CanMove()
    {
    	if (getPosition().getX()+DEPLACEMENT < MOVE_ATTAQUANTG) return true;
    	
    	else return false;
                   
        
   }
    
    public boolean CanMoveBack()
    {
    	if (getPosition().getX()-DEPLACEMENT > MOVEBACK_ATTAQUANTG) return true;
    	else return false;
                   
        
   }
    
   


   
    
}
