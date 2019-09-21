package model;

import constants.ScoreState;
import utilities.Entity;

public abstract class Score extends Entity {
	private int score;
	private ScoreState scoreState;
	private User user;
	
	public int GetScore() {
		return this.score;
	}
	
	public ScoreState GetScoreState() {
		return this.scoreState;
	}
	
	public User GetUser() {
		return this.user;
	}
}
