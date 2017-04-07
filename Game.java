package com.game;
/**
 * Created by alanpanno on 24/11/2015.
 */
import com.game.players.ComputerPlayer;
import com.game.players.GameInfo;
import com.game.players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        final int ROUNDS=3;
        //Initialize the output and create the instantiable classes

        ArrayList listGameInfo = new ArrayList();


        Player humanPlayer = new Player();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        String confirmation;
        int handResult;

        do {

            /*While condition to see if player choose odds or even */
            Scanner scanner = new Scanner(System.in);
            int number;
            do {
                System.out.println("Choose player Odds or Evens 1 for odds 2 for Even ");
                number = scanner.nextInt();
            } while ((number < 1 || number > 2));

            do {
                if (number == 1) {
                    System.out.println("User is Odds Player");
                    System.out.println("Computer is Even Player");

                    humanPlayer.setIsOdds(true);
                    computerPlayer.setIsOdds(false);
                } else {
                    System.out.println("User is Even Player");
                    System.out.println("Computer is Odds Player");
                    computerPlayer.setIsOdds(true);
                    humanPlayer.setIsOdds(false);
                }
                do {
                    System.out.println("User choice: ");
                    number = scanner.nextInt();
                }
                while (number < 0 || number > 10);

                humanPlayer.setFingers(number);

                System.out.println("User choice:" + humanPlayer.getFingers());

                //Add to my handHistory the selected fingers by human
                humanPlayer.getHandHistory().add(humanPlayer.getFingers());

                System.out.println("User shown: " + humanPlayer.getFingers() + " fingers");
                System.out.println(" ");

                System.out.println("Computer Player shown: " + computerPlayer.generateRandomFingers() + " fingers");
                System.out.println(" ");

                //Adding results of addition to hand results variables
                handResult = humanPlayer.getFingers() + computerPlayer.getFingers();

                //Checks to see who win
                if (handResult % 2 == 0 && !humanPlayer.isOdds()) {
                    System.out.println("Player won");
                    System.out.println(" ");
                    humanPlayer.incrementPoints();

                } else if (handResult % 2 == 0 && !computerPlayer.isOdds()) {
                    System.out.println("Computer won");
                    System.out.println(" ");
                    computerPlayer.incrementPoints();
                } else if (handResult % 2 == 1 && humanPlayer.isOdds()) {
                    System.out.println("Player won");
                    System.out.println(" ");
                    humanPlayer.incrementPoints();
                } else if (handResult % 2 == 1 && computerPlayer.isOdds()) {
                    System.out.println("Computer won");
                    System.out.println(" ");
                    computerPlayer.incrementPoints();
                }
                System.out.println("User points: " + humanPlayer.getPoints());
                System.out.println(" ");
                System.out.println("Computer points: " + computerPlayer.getPoints());
                System.out.println(" ");

            }
            // Condition to check who win
            while ((computerPlayer.getPoints() < 3) && (humanPlayer.getPoints() < 3));

            if (humanPlayer.getPoints() == ROUNDS) {
                System.out.println("Congratulations, you won the game!");

            } else {
                System.out.println("Unfortunately, the computer won the game.");
            }

            listGameInfo.add(new GameInfo(humanPlayer.getPoints(), computerPlayer.getPoints()));
            humanPlayer.clearPoints();
            computerPlayer.clearPoints();

            System.out.println("User shown: " + humanPlayer.getHandHistory() + " fingers");
            System.out.println("Computer shown: " + computerPlayer.getHandHistory() + " fingers");

            System.out.println("");
            System.out.println("Would you like to play another game? (y/n)");
            humanPlayer.getHandHistory().clear();
            computerPlayer.getHandHistory().clear();

            confirmation = scanner.next();
        }
        while(confirmation.charAt(0) =='y');

        // Show the list of games won and lost by player
        for(int i =0; i < listGameInfo.size(); i++ )
        {
            System.out.println("Game: "+ (i+1));
            GameInfo info = (GameInfo)listGameInfo.get(i);
            System.out.println("rounds won: "+ info.getHumanRound());
            System.out.println("rounds lost: "+ info.getComputerRound());
        }


    }
}
