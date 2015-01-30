package com.me.coopapp.ui;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class UIPublisher extends Observable {
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	public UIPublisher() {}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(Object args) {
	      for (Observer observer : observers) {
	          observer.update(this, args);
	       }
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}
	
	public enum ParameterType {SCREEN, PLAYERS}

}
