package fr.uvsq.ibrahim.abdoulaye.metroParisien;

/**
 * Write a description of class Chemin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chemin
{
    public int distance;
    
    public int ligne;
    
    public String direction;
    
   // public int id1;
    
   // public int id2;
    
    /**
     * Constructor for objects of class Chemin
     */
    public Chemin(int distance, int ligne, String direction)
    {
        //this.id1 = id1;
        //this.id2 = id2;
        this.distance = distance;
        this.ligne = ligne;
        this.direction = direction;
    }
    public Chemin()
    {
        //this.id1 = 0;
        //this.id2 = 0;
        this.distance = 0;
        this.ligne = 0;
        this.direction = "";
    }
    
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    
    public void setLigne(int ligne)
    {
        this.ligne = ligne;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getDistance()
    {
        return this.distance;
    }
    
    /**
     * 
     */
    public int getLigne()
    {
        return this.ligne;
    }
    
    /**
     * 
     */
    public String getDirection()
    {
        return this.direction;
    }
    
    public String affichage()
    {
        return this.distance+" "+this.ligne+" "+this.direction;
    }
}
