package com.game.morra;

public class Computer extends Players{
	

	public int generateRandomFingers() {
        fingers = (int) (Math.random() * 10);
        return fingers; 
}
}