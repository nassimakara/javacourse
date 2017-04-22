/**
 * @author Zekpa Ossabou Sebastien (Student No. 16135091)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.Scanner;


/**
 * Player is the abstract class. 
 */
public class Human extends Player {
	
    private Scanner sc = new Scanner(System.in);
    
 
    /**
     * 
     */
    public Human(String name, boolean hasOdds)
    {
        this.setName(name);
        this.hasOdds(hasOdds);
    }
	

    /**
     * Request Human to choose number of fingers.
     */
    public int showFingers()
    {
        System.out.print(this.name + ", please choose a number of fingers to show between 1 and 10. Type 0 to quit: ");
        int fingers = sc.nextInt();
        
        // check if the player's choice is valid
        while (fingers < 0 || fingers > this.maxFingers)
        {
            System.out.print(fingers + " is not a valid number; please retry with a number between 1 and 10 or 0 to quit: ");
            fingers = sc.nextInt();
        }
        this.setFingers(fingers);
        
        return fingers;
    }
}
