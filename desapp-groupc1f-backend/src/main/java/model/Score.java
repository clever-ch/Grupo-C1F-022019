package model;

import constants.ScoreState;
import utilities.Entity;

public abstract class Score extends Entity {
	private int scoreValue;
	private ScoreState scoreState;
	private User user;
	
	public int getScoreValue() {
		return this.scoreValue;
	}
	
	public void setScoreValue(int value) {
		this.scoreValue = value;
	}
	
	public ScoreState getScoreState() {
		return this.scoreState;
	}
	
	public void setScoreState(ScoreState state) {
		this.scoreState = state;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean fullDataIsValid() {
		return isValidScoreValue() & hasScoreState() & hasUserValid();   
	}
	
	public boolean isValidScoreValue() {
		return this.scoreValue > 0;
	}
	
	public boolean hasScoreState() {
		return this.scoreState != null;
	}
	
	public boolean hasUserValid() {
		return this.user != null;
	}
}
