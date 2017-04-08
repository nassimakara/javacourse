package com.game.morra;

import java.util.ArrayList;

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
