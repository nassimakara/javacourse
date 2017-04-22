/**
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.Scanner;

/**
 * This is the main entry point of the program, it initializes the game, invokes the GameController and starts the game.
 */
public class Morra
{
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.print("Insert your name: ");
        String name = sc.next();
        
        System.out.println("Hello " + name + "!");
        System.out.print("Please choose if you want to play with evens (2) or odds (1). Type 0 to quit: ");
        int choice = sc.nextInt();
        
        // check if the player's choice is valid
        while (choice < 0 || choice > 2)
        {
            System.out.print(choice + " is not a valid option; please retry 2 for evens, 1 for odds or 0 to quit: ");
            choice = sc.nextInt();
        }
        
        boolean hasOdds = false;
        // check the player's choice and set the variables to initialize the game
        switch (choice)
        {
            case 0: // the player wants to quit
                System.out.println("See you, " + name + "...");
                System.exit(0);
                break;
            case 1: // the player chose to play with odds
                hasOdds = true;
                break;
            case 2: // the player chose to play with evens
                hasOdds = false;
                break;
        }
        // pass the control of the program to the GameController
        GameController game = new GameController();
        game.start(name, hasOdds);            
    }
}
