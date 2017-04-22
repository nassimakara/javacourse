/**
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.Scanner;

/**
 * This is the main entry point of the program, it initializes the game (asking
 * some basic questions to the human player), manage the user's I/O before/after
 * playing then invokes the GameController and starts the game.
 */
public class Morra
{
    private static Scanner sc = new Scanner(System.in);
    private static String name;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.print("Insert your name: ");
        name = sc.next();

        System.out.println("Hello " + name + "!");

        // pass the control of the program to the GameController
        GameController game = new GameController();
        game.start(name, choose());
        // after a game is finished ask the player for another match
        while (playAgain())
            game.start(name, choose());
        game.end();
    }

    /**
     * Ask the human player to choose to play with Evens or Odds
     */
    private static boolean choose()
    {
        boolean hasOdds = false;

        System.out.print("Please choose if you want to play with evens (2) or odds (1). Type 0 to quit: ");
        int choice = sc.nextInt();

        // check if the player's choice is valid
        while (choice < 0 || choice > 2)
        {
            System.out.print(choice + " is not a valid option; please retry 2 for evens, 1 for odds or 0 to quit: ");
            choice = sc.nextInt();
        }

        // check the player's choice and set the variables to initialize the
        // game
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
        return hasOdds;
    }

    /**
     * Ask the human player to play another game
     */
    private static boolean playAgain()
    {
        boolean again = false;

        System.out.print(name + " do you want to play again? (Y/N) ");
        String choice = sc.next().toUpperCase();

        // check if the player's choice is valid
        while ("YN".indexOf(choice) < 0)
        {
            System.out.print(choice + " is not a valid option; please type Y to play again or N to quit: ");
            choice = sc.next().toUpperCase();
        }
        if (choice.equals("Y"))
            again = true;

        return again;
    }
}
