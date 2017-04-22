/**
 * @author Nassima Kara (Student No. 16134613)
 * @author Lorenzo Cipriani (Student No. 16138457)
 */
package ie.ncirl.game;

import java.util.ArrayList;

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

    // these 3 instance variables keep track of all the games played
    protected ArrayList<int[]> gamesHistory = new ArrayList<int[]>();
    protected ArrayList<ArrayList<int[]>> computerGames = new ArrayList<ArrayList<int[]>>();
    protected ArrayList<ArrayList<int[]>> humanGames = new ArrayList<ArrayList<int[]>>();

    /**
     * This method initialize a new game
     */
    public void start(String name, boolean hasOdds)
    {
        // Make sure that when a new game starts all the player's history of the
        // previous one is deleted
        if (this.human != null)
            this.human = null;
        if (this.computer != null)
            this.computer = null;

        this.human = new Human(name, hasOdds);
        this.computer = new Computer();
        this.rounds = 0;
        this.play();
    }

    /**
     * When the game ends or the human player wants to quit the results (all the
     * rounds of all the games) are displayed and the program is closed
     * gracefully
     */
    public void end()
    {
        if (this.computerGames.size() > 0)
            this.displayGamesResults();
        System.out.println("\nGoodbye " + this.human.getName() + ". Thank you for playing!");
        System.exit(0);
    }

    /**
     * Method that handles the play of a single game
     */
    private void play()
    {
        // Play a game until none of the players score 6 points, or the human
        // player choose to exit choosing 0 fingers
        while (this.human.getScore() < this.winningPoints && this.computer.getScore() < this.winningPoints)
        {
            int humanFingers = this.human.showFingers();
            if (humanFingers == 0)
                this.end();
            this.assignPoints(humanFingers, this.computer.showFingers());

            this.displayPlayersHeader(this.allFingers, this.computer.getScore(), this.human.getScore());
            int[] p0 = { this.computer.getFingers(), this.computer.getPoints(), this.computer.getExtras() };
            int[] p1 = { this.human.getFingers(), this.human.getPoints(), this.human.getExtras() };
            System.out.println("Round | Fin. | Pts. | Ext. | Fin. | Pts. | Ext. |");
            this.displayRoundResults(++this.rounds, p0, p1);
            this.displayDataSeparator();
            System.out.println("");
            this.checkWinner();
        }
        // Store the history of this game for each player
        this.computerGames.add(this.computer.getRoundHistory());
        this.humanGames.add(this.human.getRoundHistory());
    }

    /**
     * Evaluate and assign the points at every round played
     */
    private void assignPoints(int humanFingers, int computerFingers)
    {
        this.allFingers = humanFingers + computerFingers;

        // when the sum is even
        if (allFingers % 2 == 0)
        {
            if (this.human.hasOdds)
            {
                if (computerFingers > humanFingers)
                    this.computer.win(this.roundPoints, this.extraPoints);
                else
                    this.computer.win(this.roundPoints, 0);
                this.human.loose();
            }
            else
            {
                if (humanFingers > computerFingers)
                    this.human.win(this.roundPoints, this.extraPoints);
                else
                    this.human.win(this.roundPoints, 0);
                this.computer.loose();
            }
        }
        else // when the sum is odd
        {
            if (this.human.hasOdds)
            {
                if (humanFingers > computerFingers)
                    this.human.win(this.roundPoints, this.extraPoints);
                else
                    this.human.win(this.roundPoints, 0);
                this.computer.loose();
            }
            else
            {
                if (computerFingers > humanFingers)
                    this.computer.win(this.roundPoints, this.extraPoints);
                else
                    this.computer.win(this.roundPoints, 0);
                this.human.loose();
            }
        }
    }

    /**
     * Verify if any of the players reached the required score to win a game and
     * record the game results
     */
    private void checkWinner()
    {
        String winner = new String("");
        // Both players scored at least 6 points
        if (this.human.getScore() >= this.winningPoints && this.computer.getScore() >= this.winningPoints)
        {
            // Check who scored more points
            if (this.human.getScore() > this.computer.getScore())
                winner = this.human.getName();
            else
                winner = this.computer.getName();
        }
        // One of the 2 player scored at least 6 points
        else if (this.human.getScore() >= this.winningPoints)
            winner = this.human.getName();
        else if (this.computer.getScore() >= this.winningPoints)
            winner = this.computer.getName();

        // There is a winner, so let's display its name and record the game
        // result
        if (!winner.equals(""))
        {
            System.out.println(winner + " won the game!");

            int winnerCode = 0;
            if (!winner.equals(this.computer.name))
                winnerCode = 1;

            Player p0 = this.computer;
            Player p1 = this.human;
            int[] record = { winnerCode, p0.getScore(), p0.getPoints(), p0.getExtras(), p0.getRoundsWins(),
                    p0.getRoundsLost(), p1.getScore(), p1.getPoints(), p1.getExtras(), p1.getRoundsWins(),
                    p1.getRoundsLost() };
            this.gamesHistory.add(record);
        }

    }

    /**
     * Display a formatted output for each round result
     */
    private void displayRoundResults(int round, int[] p0, int[] p1)
    {
        System.out.format("%5d | %4d | %4d | %4d | %4d | %4d | %4d |\n", round, p0[0], p0[1], p0[2], p1[0], p1[1],
                p1[2]);
    }

    /**
     * Display the results for all the rounds of a game
     */
    private void displayRoundsResults(ArrayList<int[]> computerHist, ArrayList<int[]> humanHist)
    {
        this.displayPlayersHeader();
        System.out.println("Round | Fin. | Pts. | Ext. | Fin. | Pts. | Ext. |");
        for (int i = 0; i < computerHist.size(); i++)
        {
            this.displayRoundResults((i + 1), computerHist.get(i), humanHist.get(i));
        }
    }

    /**
     * Display the results of all the games played
     */
    private void displayGamesResults()
    {
        String winner;
        int winnerCode = 0;
        int winnerPoints = 0;
        int winnerExtras = 0;
        int roundsPlayed = 0;

        int winsP0 = 0;
        int lostP0 = 0;
        int winsP1 = 0;
        int lostP1 = 0;

        // Totals
        int totRounds = 0;

        // Totals for Computer
        int totScrP0 = 0;
        int totPtsP0 = 0;
        int totExtP0 = 0;
        int totWinsP0 = 0;
        int totLostP0 = 0;

        // Totals for Human
        int totScrP1 = 0;
        int totPtsP1 = 0;
        int totExtP1 = 0;
        int totWinsP1 = 0;
        int totLostP1 = 0;

        for (int i = 0; i < this.gamesHistory.size(); i++)
        {
            winnerCode = this.gamesHistory.get(i)[0];

            totRounds += this.computerGames.get(i).size();

            totScrP0 += this.gamesHistory.get(i)[1];
            totPtsP0 += this.gamesHistory.get(i)[2];
            totExtP0 += this.gamesHistory.get(i)[3];
            totWinsP0 += this.gamesHistory.get(i)[4];
            totLostP0 += this.gamesHistory.get(i)[5];

            totScrP1 += this.gamesHistory.get(i)[6];
            totPtsP1 += this.gamesHistory.get(i)[7];
            totExtP1 += this.gamesHistory.get(i)[8];
            totWinsP1 += this.gamesHistory.get(i)[9];
            totLostP1 += this.gamesHistory.get(i)[10];

            // Rounds wins and lost by Computer
            winsP0 = this.gamesHistory.get(i)[4];
            lostP0 = this.gamesHistory.get(i)[5];
            // Rounds wins and lost by Human
            winsP1 = this.gamesHistory.get(i)[9];
            lostP1 = this.gamesHistory.get(i)[10];

            if (winnerCode == 0) // Points made by Computer
            {
                winner = this.computer.getName();
                winnerPoints = this.gamesHistory.get(i)[1];
                winnerExtras = this.gamesHistory.get(i)[3];
                roundsPlayed = this.gamesHistory.get(i)[4] + this.gamesHistory.get(i)[5];
            }
            else // Points made by Human
            {
                winner = this.human.getName();
                winnerPoints = this.gamesHistory.get(i)[6];
                winnerExtras = this.gamesHistory.get(i)[8];
                roundsPlayed = this.gamesHistory.get(i)[9] + this.gamesHistory.get(i)[10];
            }

            // Format the data to be displayed
            System.out.format("\nGame %d results: %s won in %d rounds with %d points (%d extras).\n", (i + 1), winner,
                    roundsPlayed, winnerPoints, winnerExtras);
            this.displayRoundsResults(this.computerGames.get(i), this.humanGames.get(i));
            this.displayDataSeparator();
            System.out.format("Wins  | %18d | %18d |\n", winsP0, winsP1);
            System.out.format("Lost  | %18d | %18d |\n", lostP0, lostP1);
            this.displayDataSeparator();
        }
        System.out.println("\nGame statistics:");
        this.displayDataSeparator();
        System.out.println("Rnds. | Scr. | Pts. | Ext. | Scr. | Pts. | Ext. |");
        System.out.format("%5d | %4d | %4d | %4d | %4d | %4d | %4d |\n", totRounds, totScrP0, totPtsP0, totExtP0,
                totScrP1, totPtsP1, totExtP1);
        this.displayDataSeparator();
        System.out.format("Wins  | %18d | %18d |\n", totWinsP0, totWinsP1);
        System.out.format("Lost  | %18d | %18d |\n", totLostP0, totLostP1);
        this.displayDataSeparator();
    }

    private void displayPlayersHeader()
    {
        this.displayDataSeparator();
        System.out.format("%5s | %-18s | %-18s |\n", "", this.computer.getName(), this.human.getName());
        this.displayDataSeparator();
    }

    private void displayPlayersHeader(int fingers, int scoreP0, int scoreP1)
    {
        this.displayDataSeparator();
        System.out.format("F: %2s | %-14s %3d | %-14s %3d |\n", fingers, this.computer.getName(), scoreP0,
                this.human.getName(), scoreP1);
        this.displayDataSeparator();
    }

    private void displayDataSeparator()
    {
        String separator = String.format("%0" + 49 + "d", 0).replace("0", "-");
        System.out.println(separator);
    }
}
