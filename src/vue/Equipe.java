package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Equipe
{
    
    private String nomEquipe;
    private Entreneur entreneur;
    private Joueur[] listeJouer;
    
    
    
    
    /**
     * Constructor for objects of class Equipe
     */
    
    
    
    public Equipe(String nomEquipe,Entreneur entreneur)
    {
       this.nomEquipe=nomEquipe;
       this.entreneur=entreneur;
       this.listeJouer = listeJouer;  
       
    }
   
    	
    
    
    //  Getters && setters 
    
    
       
   
    public String toString ()
    {
           return getClass().getName();
           
   }
   
    
    public String getNomEquipe()
    {
           return nomEquipe;
           
   }
   
   
   
   
   
}
