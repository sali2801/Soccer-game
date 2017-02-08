package vue;


/**
 *  
 * @author Mallem saliha
 * 15/06/2012
 */


            //classe qui englobe toutes les opérations faites par les joueurs




abstract  class Joueur  implements Constantes
{
    

    /** 
     *la position sur le terrain
     */
	 protected  Position position;
    /** 
     *la balle avec laquelle il va jouer
     */
    protected Balle balle;
    
     /** 
     * un boolean pour marque une exclusion du joueur suite à un carton rouge
     */
    protected boolean exclu;
    
    
    /**
     * Constructor for objects of class Joueur
     */
    public Joueur(Position position,Balle balle)
    {

        
        this.position=position;
        this.balle=balle;
        exclu=false;
        
 
    }
    
   
    abstract  void avance();
    abstract boolean CanMove();
    abstract boolean CanMoveBack();
    abstract void recule ();
    

    public void tirerBalle() {
    	this.balle=null;
    	 
    	
    }
    

    
    /**
      * recuperer la balle 
      * 
      * @param:liste des joueurs de l'adversaire
      * @param:la balle
      *     
      */

    
    
     public void RecupererBalle(Joueur[] listJoueur,Balle balle)
     {
          /*  si un adverseraire possede la balle en lui l'arrache*/
     	
     	for (int i=0;i<listJoueur.length;i++)
 		{
 			if (listJoueur [i].getBalle()!=null)
 			{
 			  	listJoueur [i].setBalle(null);
 			}
 		}
     	
        /* la balle est maintenent en possession de ce joueur */
     	
     	this.setBalle(balle);
     	balle.bouger(this.getPosition().getX());
    }
    
     
    
     public String toString ()
     {
            return getClass().getName();
            
    }
    
    
     public boolean PeutRecuperer(Joueur[] listJoueur,Balle balle)
     {
     	/* on vérifier condition n°1:
     	 *  si la balle est chez un coéquipier => le joueur ne
     	 * peut pas la recuperer
     	 */
     	boolean bool=true;
     	
     	for (int i=0; i<listJoueur.length;i++)
     	{
     		if (listJoueur[i].balle!=null) 
     		{
     			bool=false;
     			break;
     		}
     	}
     	/* on vérifier condition n°2:
     	 * la distance entre le joueur et la balle est suffisament petite	
     	 */
    		if  ((Math.abs(balle.getPosition() - this.getPosition().getX())<20) && bool==true )
    		{
    			
     			return  true;
     	}
    		
     	           
    		else return false;
    }
    
     

 	public void AttraperBalle (Balle balle) {
 		this.balle=balle;
 		
 	}
 	
     
 	
 	
 	
 	
 	
 	
 	//  Getters && Setters
    
    /**
     *
     * @return position du joueur
     */
    public Position getPosition()
    {
        return position;
    }
    
    
    /**
     * @return  le joueur -il exclus
     */
    
    
    public void setExclu(boolean exclu) {
		this.exclu = exclu;
	}


	/**
     * 
     * 
     * @param    un nouvelle position pour le joueur
     */
    public void setPosition(Position position)
    {
        
        this.position=position;
    }
    
    /**
     * 
     * 
     * @param    une balle pour le joueur, elle peut etre null qaund le joueur ne la posséde pas
     */
    public void setBalle(Balle balle)
    {
       this.balle=balle;
    }
    
    /**
     * 
     * @return     la balle du joueur
     */
    public Balle getBalle()
    {
         return balle;
    }
    
     
    
     /**
     * *
     *  
     * @return     joueur posse_il ou pas la balle?
     */
    public Boolean getExclu()
    {
        
       return exclu;
        
    }
    

}
