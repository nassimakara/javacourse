package com.game.players;

import java.util.ArrayList;

/**
 * Created by alanpanno on 22/11/2015.
 */
public class Player {

    protected ArrayList handHistory;
    protected int fingers;
    protected boolean isOdds;

    protected int points = 0;

    public boolean isOdds() {
        return isOdds;
    }

    public Player() {
        this.handHistory = new ArrayList();
    }

    public void setIsOdds(boolean isOdds) {
        this.isOdds = isOdds;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public void saveHandHistory(int finger){

        if(handHistory != null) {
            handHistory.add(finger);
        }
    }
    public ArrayList getHandHistory() {
        return handHistory;
    }

    public void clearHistory(){
        if(!handHistory.isEmpty())
        {
            handHistory.clear();
        }
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints(){
        points++;
    }


    public void clearPoints()
    {
       points = 0;
    }

}
