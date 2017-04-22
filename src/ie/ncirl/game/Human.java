/**
 * @author Zekpa Ossabou Sebastien (Student No. 16135091)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.Scanner;

// TODO: comment is missing
/**
 * 
 */
public class Human extends Player {
	
    
    // TODO: comment is missing
    /**
     * 
     */
    public Human(String name, boolean hasOdds)
    {
        this.setName(name);
        this.hasOdds(hasOdds);
    }
	
    // TODO: comment is missing
    /**
     * 
     */
    public int showFingers()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print(this.name + ", please choose a number of fingers to show between 1 and 10. Type 0 to quit: ");
        int fingers = sc.nextInt();
        
        // check if the player's choice is valid
        while (fingers < 0 && fingers > this.maxFingers)
        {
            System.out.print(fingers + " is not a valid number; please retry with a number between 1 and 10 or 0 to quit: ");
            fingers = sc.nextInt();
        }
        sc.close();
        this.setFingers(fingers);
        
        return fingers;
    }
}
