package com.me.coopapp.strategy;

import java.util.ArrayList;
import java.util.Random;

public class Strategy {
	
	private int length;
	private ArrayList<Expression> expressions;
	private static int maxLength = 10; //TODO: Add to config file
	
	public Strategy() {}
	
	public Strategy(ArrayList<Expression> expressions) {
		this.expressions = expressions;
	}
	
	public ArrayList<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(ArrayList<Expression> expressions) {
		this.expressions = expressions;
	}
	
	public Strategy createRandomStrategy() {
		
		Random rand = new Random();
		length = rand.nextInt(maxLength);
		expressions = new ArrayList<Expression>();
		
		for(int i=0; i < length; i++) {
			expressions.add(new Expression(Expression.Type.values()[rand.nextInt(Expression.Type.values().length-1)]));
		}
		
		return this;
	}
	
	public int length() {
		return this.length;
	}


}
