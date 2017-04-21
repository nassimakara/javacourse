package ie.ncirl.game;

// TODO: the code MUST be FORMATTED properly (indentation, spaces, etc...)

// TODO: this class needs a description and there are several errors, e.g.:
// -  the class that it extends is named Player and not Players
public class Computer extends Players{
	
	// TODO: The name of this method is wrong and it should be getFingers() or showFingers() for both Computer and Human class 
	public int generateRandomFingers() {
		// TODO what is fingers? There is a missing type declaration
        fingers = (int) (Math.random() * 10);
        return fingers; 
}
}