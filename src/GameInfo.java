package com.game.players;

import java.util.ArrayList;

/**
 * Created by alanpanno on 24/11/2015.
 */
public class GameInfo {

    private int humanRound;
    private int computerRound;

    public GameInfo(int humanRound, int computerRound) {
        this.humanRound = humanRound;
        this.computerRound = computerRound;
    }

    public int getHumanRound() {
        return humanRound;
    }

    public int getComputerRound() {
        return computerRound;
    }

}
