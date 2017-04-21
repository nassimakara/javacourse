package ie.ncirl.game;
import java.util.Scanner;

/**
 * This class controls the gameplay and the players
 * @author Nassima Kara Student id  x16134613
 */
public class GameController {

	//declare instance variables
	private int rounds;
    private final int  winningPoints = 6;
    private int computerPoints;
    private int humanPoints;


    // declare constructors
    public void start(String name, bool hasOdds) {

		Human hp = new Human(name);
		Computer cp = new Computer();

		Scanner sc = new Scanner(System.in);// declare and create an object of type Scanner to allow reading from the keyboard
		System.out.print("Choose a number between 1 and 10: ");
		int humanFingers = sc.nextInt();// read the number provided by the player

		if (isValid(humanFingers))
		{
			int computerFingers = cp.getFingers();

			this.calc(humanFingers, computerFinger);

		}
		else
		{
          System.out.println("Number of fingers non valid. Start again");
		}
	}

	private bool isValid(int fingers)
	{

	}

// declare a method to implement the actual processing: determine the total number of fingers displayed by the human player and the computer

	private void calc(int humanFingers, int computerFinger){

		int fingers=int humanFingers + int computerFinger;

		//Check if the number is Odd or Even
			if (int fingers % 2 ==0 && humanFingers %2==0){
			System.out.println("Player won";}

			else if (int fingers % 2 ==1 && computerFinger %2==0){
			System.out.println("Computer won";}

			else if (int fingers % 2 ==1 && humanFingers %2==0){
			System.out.println("Player won";}

			else if (int fingers % 2 ==1 && computerFinger %2==0){
			System.out.println("Computer won";}


		//Assign the points





    }

	public void end() {

		if (computerPoints || humanPoints==6){
		System.out.println(" The game is over, do you want to play another game?"}

		else if (computerPoints || humanPoints!=6){

		System.out.println(" Do you want to play another round?"}
 	}

}





























