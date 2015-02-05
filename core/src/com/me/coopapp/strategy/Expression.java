package com.me.coopapp.strategy;

import java.util.Map;

import com.me.coopapp.game.Game;

public class Expression implements IExpression {

	private Type type;
	private String texture;

	public Expression() {
	}

	public Expression(Type type) {
		
		this.type = type;
		
		switch(type) {
			case Nice : texture = Texture.Nice;
			break;
		case Bully: texture = Texture.Bully;
			break;
		case Exploiter: texture = Texture.Exploiter;
			break;
		case Forgiving: texture = Texture.Forgiving;
			break;
		case Friendly: texture = Texture.Friendly;
			break;
		case Optomist: texture = Texture.Optomist;
			break;
		case Selfish: texture = Texture.Selfish;
			break;
		case Unforgiving: texture = Texture.Unforgiving;
			break;
		case Unpredictable: texture = Texture.Unpredictable;
			break;
		default:
			break;
		}
	}

	public String getTexture() {
		return texture;
	}

	public int translateToInteraction(Map<Game.statusType, Object> gameStatus) {
		return 0;
	}
	
	public static enum Type {
		Nice, Forgiving, Friendly, Exploiter, Unforgiving, Optomist, Selfish, Bully, Unpredictable
	}
	
	public static class Texture { 
		public final static String Nice = "Nice"; 
		public final static String Forgiving = "Forgiving"; 
		public final static String Friendly = "Friendly"; 
		public final static String Exploiter = "Exploiter"; 
		public final static String Unforgiving = "Unforgiving"; 
		public final static String Optomist = "Optomist"; 
		public final static String Selfish = "Selfish"; 
		public final static String Bully = "Bully"; 
		public final static String Unpredictable = "Unpredictable"; 
	}
}
