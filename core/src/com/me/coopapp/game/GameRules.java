package com.me.coopapp.game;

import java.util.ArrayList;

public class GameRules implements IGameRules {
	
	private static final int BETRAYPOINTS = 5;
	private static final int COOPERATEPOINTS = 3;
	private static final int DEFECTPOINTS = 1;
	private static final int SUCKERPOINTS = 0;
	
	private static final int COOPERATE = 1;
	private static final int DEFECT = 0;
	
	public GameRules() {
		
	}
	
	public ArrayList<Integer> getInteractionPoints(ArrayList<Integer> interactions) {
		
		int p1Interaction = interactions.get(0);
		int p2Interaction = interactions.get(1);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(p1Interaction == COOPERATE && p2Interaction == COOPERATE) {
			result.add(COOPERATEPOINTS);
			result.add(COOPERATEPOINTS);
		}
		else if(p1Interaction == COOPERATE && p2Interaction == DEFECT) {
			result.add(SUCKERPOINTS);
			result.add(BETRAYPOINTS);
		}
		else if(p1Interaction == DEFECT && p2Interaction == COOPERATE) {
			result.add(BETRAYPOINTS);
			result.add(SUCKERPOINTS);
		}
		else if(p1Interaction == DEFECT && p2Interaction == DEFECT) {
			result.add(DEFECTPOINTS);
			result.add(DEFECTPOINTS);
		}
		
		return result;
	}

}
