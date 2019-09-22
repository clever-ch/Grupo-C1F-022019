package model;

import constants.ScoreState;
import utilities.Entity;

public abstract class Score extends Entity {
	private int score;
	private ScoreState scoreState;
	private User user;
	
	public int getScore() {
		return this.score;
	}
	
	public ScoreState getScoreState() {
		return this.scoreState;
	}
	
	public User getUser() {
		return this.user;
	}
}
