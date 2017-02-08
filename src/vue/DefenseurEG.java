package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class DefenseurEG extends Joueur {
  
    

    /**
     * Constructor for objects of class Defenseur
     */
    public DefenseurEG(int numéro,Position position,Balle balle)
    {
        super(position, balle);
    
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
    	if (getPosition().getX()+DEPLACEMENT < MOVE_DEFENSEURG) return true;
    	else return false;
                   
        
   }
    
    public boolean CanMoveBack()
    {
    	if (getPosition().getX()-DEPLACEMENT > MOVEBACK_GARDIENTG) return true;
    	else return false;
                   
        
   }

   
    public void AttraperBalle(Balle balle) {
    	this.balle=balle;
    	
    }


    
}
