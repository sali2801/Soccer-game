package vue;

import java.io.Serializable;



/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */
public class Scor implements Serializable
{
   
	
     private int ScorEquipe1;
     private int ScorEquipe2;
     
     
     
    
    /**
     * Constructor for objects of class Scor
     */
    public Scor()
    {
        this.ScorEquipe1=0;
        this.ScorEquipe2=0;
            
    }
    
    /**
     * incrementer le scor suite à un marquage de but
     */
    public void Increment(int numEquipe)
    {
        switch(numEquipe)
        {case 1:
        ScorEquipe1++;
        break;
        case 2:
        ScorEquipe2++;
        break;}
         
    }
    
    // Getters && Setters
    
    public int getScorEquipe1() {
		return ScorEquipe1;
	}

	public void setScorEquipe1(int scorEquipe1) {
		ScorEquipe1 = scorEquipe1;
	}

	public int getScorEquipe2() {
		return ScorEquipe2;
	}

	public void setScorEquipe2(int scorEquipe2) {
		ScorEquipe2 = scorEquipe2;
	}

	
    
    
    /**
     * incrementer le scor suite à un marquage de but
     */
    public String AfficheScor (int i)
    {   
    	String ch=null;
    	switch (i)
    	{
    	case 1:
    		ch=ch.valueOf(ScorEquipe1);
            
         break;
    	case 2:
    		ch=ch.valueOf(ScorEquipe2);
          
    		break;
    	}
    	  return ch;      
    }

    
}
