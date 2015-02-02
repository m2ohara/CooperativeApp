package com.me.coopapp.strategy;

import java.util.ArrayList;

public class Strategy {
	
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

	private ArrayList<Expression> expressions;


}
