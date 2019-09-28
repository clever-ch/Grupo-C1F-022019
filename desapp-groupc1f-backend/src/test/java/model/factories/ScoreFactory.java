package model.factories;

import constants.ScoreState;
import model.FoodServiceScore;
import model.MenuScore;
import model.User;

public class ScoreFactory {

	/* FoodServiceScore section */
	public static FoodServiceScore anyFoodServiceScore() {
		return new FoodServiceScore();
	}
	
	public static FoodServiceScore createFullFoodServiceScore(int value, ScoreState state, User user) {
		FoodServiceScore aFoodServiceScore = anyFoodServiceScore();
		aFoodServiceScore.setScoreValue(value);
		aFoodServiceScore.setScoreState(state);
		aFoodServiceScore.setUser(user);
		
		return aFoodServiceScore;
	}
	
	
	/* MenuScore section */
	public static MenuScore anyMenuScore() {
		return new MenuScore();
	}
	
	public static MenuScore createFullMenuScore(int value, ScoreState state, User user) {
		MenuScore aMenuScore = anyMenuScore();
		aMenuScore.setScoreValue(value);
		aMenuScore.setScoreState(state);
		aMenuScore.setUser(user);
		
		return aMenuScore;
	}
}
