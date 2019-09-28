package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import constants.ScoreState;
import model.factories.ProviderFactory;
import model.factories.ScoreFactory;

public class TestFoodServiceScore {

	@Test
	public void testFoodServiceScoreValueIsValid() {
		final int SCORE_VALUE = 1;
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreValue(SCORE_VALUE);
		
		assertTrue(aFoodServiceScore.isValidScoreValue());
	}
	
	@Test
	public void testFoodServiceScoreStateIsValid() {
		final ScoreState SCORE_STATE = ScoreState.Pending;
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreState(SCORE_STATE);
		
		assertTrue(aFoodServiceScore.hasScoreState());
	}
	
	@Test
	public void testFoodServiceScoreUserIsValid() {
		Provider provider = ProviderFactory.aProvider();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setUser(provider);
		
		assertTrue(aFoodServiceScore.hasUserValid());
	}
	
	@Test
	public void testFoodServiceScoreValueNoTIsValid() {		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		
		assertFalse(aFoodServiceScore.isValidScoreValue());
	}
	
	@Test
	public void testFoodServiceScoreStateIsNotValid() {		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		
		assertFalse(aFoodServiceScore.hasScoreState());
	}
	
	@Test
	public void testFoodServiceScoreUserIsNotValid() {		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		
		assertFalse(aFoodServiceScore.hasUserValid());
	}

	@Test
	public void testFoodServiceScoreFullDataIsValid() {
		final int SCORE_VALUE = 1;
		final ScoreState SCORE_STATE = ScoreState.Pending;
		Provider provider = ProviderFactory.aProvider();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.createFullFoodServiceScore(SCORE_VALUE, SCORE_STATE, provider);
		
		assertTrue(aFoodServiceScore.fullDataIsValid());
	}
	
	@Test
	public void testFoodServiceScoreValueDataNotComplete() {
		final ScoreState SCORE_STATE = ScoreState.Pending;
		Provider provider = ProviderFactory.aProvider();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreState(SCORE_STATE);
		aFoodServiceScore.setUser(provider);
		
		assertFalse(aFoodServiceScore.fullDataIsValid());
	}
	
	@Test
	public void testFoodServiceScoreStateDataNotComplete() {
		final int SCORE_VALUE = 1;
		Provider provider = ProviderFactory.aProvider();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreValue(SCORE_VALUE);
		aFoodServiceScore.setUser(provider);
		
		assertFalse(aFoodServiceScore.fullDataIsValid());
	}
	
	@Test
	public void testFoodServiceScoreUserDataNotComplete() {
		final int SCORE_VALUE = 1;
		final ScoreState SCORE_STATE = ScoreState.Pending;
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreValue(SCORE_VALUE);
		aFoodServiceScore.setScoreState(SCORE_STATE);
		
		assertFalse(aFoodServiceScore.fullDataIsValid());
	}
}
