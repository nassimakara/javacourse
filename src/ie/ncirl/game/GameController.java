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
    private final int extraPoints = 1;
    private final int winningPoints = 6;

    // declare instance variables
    private int rounds = 0;
    private int allFingers = 0;
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
            if (humanFingers == 0)
                this.end();
            this.assignPoints(humanFingers, this.computer.showFingers());
            System.out.println("Round " + ++this.rounds + " - " + this.allFingers + " fingers ("
                    + this.computer.getName() + " fingers: " + this.computer.getFingers() + ")");
            System.out.println("Computer " + this.computer.getPoints() + " - " + this.human.getName() + " "
                    + this.human.getPoints());
            this.checkWinner();
        }
        this.end();
    }

    // TODO: comment is missing
    /**
     * 
     */
    private void assignPoints(int humanFingers, int computerFinger)
    {
        this.allFingers = humanFingers + computerFinger;

        // when the sum is even
        if (allFingers % 2 == 0)
        {
            if (this.human.hasOdds)
            {
                this.computer.setPoints(this.roundPoints);
                if (computerFinger > humanFingers)
                    this.computer.setPoints(this.extraPoints);
            }
            else
            {
                this.human.setPoints(this.roundPoints);
                if (humanFingers > computerFinger)
                    this.human.setPoints(this.extraPoints);
            }
        }
        else // when the sum is odd
        {
            if (this.human.hasOdds)
            {
                this.human.setPoints(this.roundPoints);
                if (humanFingers > computerFinger)
                    this.human.setPoints(this.extraPoints);
            }
            else
            {
                this.computer.setPoints(this.roundPoints);
                if (computerFinger > humanFingers)
                    this.computer.setPoints(this.extraPoints);
            }
        }
    }

    // TODO: comment is missing
    /**
     * 
     */
    private void checkWinner()
    {
        // Both players scored at least 6 points
        if (this.human.getPoints() >= this.winningPoints && this.computer.getPoints() >= this.winningPoints)
        {
            // Check who scored more points
            if (this.human.getPoints() > this.computer.getPoints())
                System.out.println(this.human.getName() + " won the game!");
            else
                System.out.println(this.computer.getName() + " won the game!");
        }
        // One of the 2 player scored at least 6 points
        else if (this.human.getPoints() >= this.winningPoints)
            System.out.println(this.human.getName() + " won the game!");
        else if (this.computer.getPoints() >= this.winningPoints)
            System.out.println(this.computer.getName() + " won the game!");
    }
}
