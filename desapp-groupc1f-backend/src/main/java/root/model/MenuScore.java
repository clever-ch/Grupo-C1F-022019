package root.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import root.constants.ScoreState;

@javax.persistence.Entity
public class MenuScore extends Score {
	
	@Enumerated(EnumType.STRING)
	private ScoreState scoreState;
	
	@OneToOne
	private Customer user;
	
	@OneToOne
	private Menu menu;
	
	private int rate;
	
	public ScoreState getScoreState() {
		return scoreState;
	}

	public void setScoreState(ScoreState scoreState) {
		this.scoreState = scoreState;
	}
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
