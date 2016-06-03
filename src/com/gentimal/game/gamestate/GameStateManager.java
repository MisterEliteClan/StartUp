package com.gentimal.game.gamestate;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList<GameState> states;
	
	private int currentState; 
	
	public static final int MENUSTATE = 0;
	public static final int OPTIONSTATE = 1;
	
	public GameStateManager() {
		states = new ArrayList<GameState>();
		
		states.add(new MenuState(this));
		
		setState(MENUSTATE);
	}
		
	public void update(){
		states.get(currentState).update();
	}
	
	public void draw(Graphics2D g){
		states.get(currentState).draw(g);
	}

	public void keyPressed(int k){
		states.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k){
		states.get(currentState).keyReleased(k);
	}
	
	public void setState(int state) {
		currentState = state;
		states.get(state).init();
	}
	
	public int getCurrentState() {
		return currentState;
	}

}
