/**
 * @author Zekpa Ossabou Sebastien (Student No. 16135091)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.ArrayList;

/**
 * This class is the abstract class so it cannot be directly instantiated.
 * Human and Computer can be instantiated. 
 * In this class there are abstract methods and standard ones which are in common for all the classes that extend this 
 * one.
 */
abstract class Player {

    protected String name;
    protected boolean hasOdds;
    
    protected int fingers;
    protected final int minFingers = 1;
    protected final int maxFingers = 10;
    protected int points = 0;
    protected int extras = 0;    
    protected int roundsWins = 0;
    protected int roundsLost = 0;
    
    protected ArrayList<int[]> roundHistory = new ArrayList<int[]>();
    
    /**
     * The showFingers abstract method must be implemented by each class that extend the Player
     */
    abstract int showFingers();

    /**
     * Function used to set the player choice.
     */
    public boolean hasOdds()
    {
        return hasOdds;
    }

    /**
     * Retrieve the player's game history
     */
    public ArrayList<int[]> getRoundHistory()
    {
        return this.roundHistory;
    }
    /**
     * Function used to set the player choice, Even or Odds.
     */
    public void hasOdds(boolean hasOdds)
    {
        this.hasOdds = hasOdds;
    }
    
    /**
     * Method invoked whenever a player looses a round
     */
    public void loose()
    {
        this.roundsLost++;
        int[] record = {this.getFingers(), 0, 0};
        this.roundHistory.add(record);
    }
    
    /**
     * Method invoked whenever a player wins a round
     */
    public void win(int points, int extra)
    {
        this.roundsWins++;
        this.points += points;
        this.extras += extra;
        int[] record = {this.getFingers(), points, extra};
        this.roundHistory.add(record);
    }

    /**
     * Return the sum of points and extra points scored by the player
     */
    public int getScore()
    {
        return points + extras;
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

    public int getExtras()
    {
        return extras;
    }

    public int getRoundsWins()
    {
        return roundsWins;
    }

    public int getRoundsLost()
    {
        return roundsLost;
    }
    
}
