package com.me.coopapp.strategy;

import java.util.ArrayList;
import java.util.Map;

import com.me.coopapp.game.Game;

public class ExpForgiving implements IExpression {

	@SuppressWarnings("unchecked")
	@Override
	public int translateToInteraction(Map<Game.statusType, Object> gameStatus) {

		ArrayList<Integer> prevInteractions = (ArrayList<Integer>)gameStatus.get(Game.statusType.PrevInteractions);
		
		if(prevInteractions.size() != 0) {
			if(prevInteractions.get(prevInteractions.size()-1) == 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		
		return Math.random() > 0.5 ? 1 : 0;
	}

}
