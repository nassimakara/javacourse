package ie.ncirl.game;

import java.util.ArrayList;

// TODO: What is this class for? PLEASE DELETE IT!!!
public class ComputerPlayer extends Player {

    public ComputerPlayer() {

        this.handHistory = new ArrayList();
    }

    public int generateRandomFingers() {
        fingers = (int) (Math.random() * 10);
        saveHandHistory(fingers);
        return fingers;
    }

}
