/**
 * @author Zekpa Ossabou Sebastien (Student No. 16135091)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

// TODO: comment is missing
/**
 * 
 */
public class Player {

    protected String name;
    protected boolean hasOdds;
    
    protected int fingers;
    protected final int minFingers = 1;
    protected final int maxFingers = 10;
    protected int points = 0;
    
    // TODO: comment is missing
    /**
     * 
     */
    public boolean hasOdds()
    {
        return hasOdds;
    }

    // TODO: comment is missing
    /**
     * 
     */
    public void hasOdds(boolean hasOdds)
    {
        this.hasOdds = hasOdds;
    }

    // Getters and Setters follow
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getFingers()
    {
        return fingers;
    }
    public void setFingers(int fingers)
    {
        this.fingers = fingers;
    }
    
    public int getPoints()
    {
        return points;
    }
    public void setPoints(int points)
    {
        this.points = points;
    }
}
