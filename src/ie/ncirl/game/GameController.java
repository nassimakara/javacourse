/**
 * @author Nassima Kara (Student No. 16134613)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.Scanner;

/**
 * This class controls the gameplay and the players
 */
public class GameController
{

    // Declare instance constants
    private final int roundPoints = 2;
    private final int winningPoints = 6;

    // declare instance variables
    private int rounds = 0;
    private Human human;
    private Computer computer;

    /**
     * This method initialize a new game
     * 
     * @param name
     * @param hasOdds
     */
    public void start(String name, boolean hasOdds)
    {
        this.human = new Human(name, hasOdds);
        this.computer = new Computer();
        this.play();
    }

    // TODO: comment is missing
    /**
     * 
     */
    public void end()
    {
        System.out.println("Goodbye " + this.human.getName() + ". Thank you for playing!");
        System.exit(0);
    }

    // TODO: comment is missing
    /**
     * 
     */
    private void play()
    {
        while (this.human.getPoints() < this.winningPoints && this.computer.getPoints() < this.winningPoints)
        {
            int humanFingers = this.human.showFingers();
            if (humanFingers==0) this.end();
            this.assignPoints(humanFingers, this.computer.showFingers());
            System.out.println("Round " + ++this.rounds);
            System.out.println("Computer " + this.computer.getPoints() + " - " + this.human.name + " " + this.human.getPoints());
        }
        this.end();
    }

    // TODO: comment is missing
    /**
     * 
     */
    private void assignPoints(int humanFingers, int computerFinger)
    {
		int allFingers = humanFingers + computerFinger;

		// when the sum is even
		if (allFingers%2==0)
	    {
		    if (this.human.hasOdds) this.computer.setPoints(this.roundPoints);
	    }
		else // when the sum is odd
		{
            if (this.human.hasOdds) this.human.setPoints(this.roundPoints);		    
		}
    }
}
