package com.game.players;

import java.util.ArrayList;

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
