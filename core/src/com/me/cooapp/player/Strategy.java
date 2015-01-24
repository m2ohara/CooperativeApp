package com.me.cooapp.player;

import java.util.Dictionary;

public class Strategy {
	
	public Strategy() {}
	
	public Dictionary<Expression.Types, Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(Dictionary<Expression.Types, Expression> expressions) {
		this.expressions = expressions;
	}

	private Dictionary<Expression.Types, Expression> expressions;


}
