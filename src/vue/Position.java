package vue;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Position
{
    
    private int x;
    private int y;
    

    /**
     * Constructor for objects of class Position
     */
    public Position(int x,int y)
    {
      this.x=x;
      this.y=y;
     
    }

    
    
    
       // Getters && Setters
   
    
    
    public int getX()
    {
        
        return x ;
    }
    
    
    public int getY()
    {
       
        return y ;
    }
    
   
    public void setX(int x)
    {
        
         this.x=x ;
    }
    
    
    public void setY(int y)
    {
       
        this.y=y ;
    }
}
