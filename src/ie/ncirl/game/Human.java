package ie.ncirl.game;
// FIXME: why do you import classes if you don't use it???
// (wrong name BTW: Scanner and not scanner) 
import java.util.scanner;

// FIXME: comment is missing
// FIXME: the class that it extends is called Player and not Players
public class Human extends Players{
	
	
	// FIXME: Why is this method defined here? It's the same for both Human and Computer, so it should be only into Player
	 public void setOddsorEven(boolean isOddsorEven) {
		 	// FIXME:  this. what??? where is the attribute isOddsorEven defined in this class
	        this.isOddsorEven = isOddsorEven;
	    }
	 
	 // FIXME:  the GameController asks to both players to show their fingers 
	 // so the method should be called getFingers() or showFingers()
	 public void setFingers(int fingers) {
		 	// FIXME:  this. what??? where is the attribute fingers defined in this class
	        this.fingers = fingers;
	    }
	 
	 
	 
	
}
