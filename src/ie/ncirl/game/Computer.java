/**
 * @author Zekpa Ossabou Sebastien (Student No. 16135091)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;


/**
 * This class is to set the computer
 */
public class Computer extends Player
{
    /**
     * This class constructor is used just to set the player's name to "Computer"
     */
    public Computer()
    {
        this.setName("Computer");
    }
    
    // 
    /**
     * Function used to randomly generate total fingers per play. 
     */
    public int showFingers()
    {
        this.fingers = this.minFingers + (int)(Math.random() * ((this.maxFingers - this.minFingers) + 1));
        return this.fingers;
    }
}