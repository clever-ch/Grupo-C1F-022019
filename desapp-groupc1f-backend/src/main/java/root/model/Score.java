package root.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import root.constants.ScoreState;
import root.utilities.Entity;

public abstract class Score extends Entity {
	private int scoreValue;
	
	@Enumerated(EnumType.STRING)
	private ScoreState scoreState;
	
	@OneToOne
	private Customer user;
	
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
	
	public Customer getUser() {
		return this.user;
	}
	
	public void setUser(Customer user) {
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
