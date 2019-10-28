package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import root.constants.ScoreState;
import root.model.Customer;
import root.model.FoodServiceScore;
import model.factories.CustomerFactory;
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
		Customer customer = CustomerFactory.anyCustomer();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setUser(customer);
		
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
		Customer customer = CustomerFactory.anyCustomer();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.createFullFoodServiceScore(SCORE_VALUE, SCORE_STATE, customer);
		
		assertTrue(aFoodServiceScore.fullDataIsValid());
	}
	
	@Test
	public void testFoodServiceScoreValueDataNotComplete() {
		final ScoreState SCORE_STATE = ScoreState.Pending;
		Customer customer = CustomerFactory.anyCustomer();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreState(SCORE_STATE);
		aFoodServiceScore.setUser(customer);
		
		assertFalse(aFoodServiceScore.fullDataIsValid());
	}
	
	@Test
	public void testFoodServiceScoreStateDataNotComplete() {
		final int SCORE_VALUE = 1;
		Customer customer = CustomerFactory.anyCustomer();
		
		FoodServiceScore aFoodServiceScore = ScoreFactory.anyFoodServiceScore();
		aFoodServiceScore.setScoreValue(SCORE_VALUE);
		aFoodServiceScore.setUser(customer);
		
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
