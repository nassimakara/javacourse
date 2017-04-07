package com.game.players;

import java.util.ArrayList;

/**
 * Created by alanpanno on 22/11/2015.
 */
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
