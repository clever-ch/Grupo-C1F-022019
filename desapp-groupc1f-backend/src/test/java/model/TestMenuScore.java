package model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import constants.ScoreState;
import model.factories.ProviderFactory;
import model.factories.ScoreFactory;

public class TestMenuScore {

	@Test
	public void testMenuScoreValueIsValid() {
		final int SCORE_VALUE = 1;
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setScoreValue(SCORE_VALUE);
		
		assertTrue(aMenuScore.isValidScoreValue());
	}
	
	@Test
	public void testMenuScoreStateIsValid() {
		final ScoreState SCORE_STATE = ScoreState.Pending;
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setScoreState(SCORE_STATE);
		
		assertTrue(aMenuScore.hasScoreState());
	}
	
	@Test
	public void testaMenuScoreUserIsValid() {
		Provider provider = ProviderFactory.aProvider();
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setUser(provider);
		
		assertTrue(aMenuScore.hasUserValid());
	}
	
	@Test
	public void testMenuScoreValueNoTIsValid() {		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		
		assertFalse(aMenuScore.isValidScoreValue());
	}
	
	@Test
	public void testMenuScoreStateIsNotValid() {		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		
		assertFalse(aMenuScore.hasScoreState());
	}
	
	@Test
	public void testMenuScoreUserIsNotValid() {		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		
		assertFalse(aMenuScore.hasUserValid());
	}
	
	@Test
	public void testMenuScoreFullDataIsValid() {
		final int SCORE_VALUE = 1;
		final ScoreState SCORE_STATE = ScoreState.Pending;
		Provider provider = ProviderFactory.aProvider();
		
		MenuScore aMenuScore = ScoreFactory.createFullMenuScore(SCORE_VALUE, SCORE_STATE, provider);
		
		assertTrue(aMenuScore.fullDataIsValid());
	}
	
	@Test
	public void testMenuScoreValueDataNotComplete() {
		final ScoreState SCORE_STATE = ScoreState.Pending;
		Provider provider = ProviderFactory.aProvider();
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setScoreState(SCORE_STATE);
		aMenuScore.setUser(provider);
		
		assertFalse(aMenuScore.fullDataIsValid());
	}
	
	@Test
	public void testMenuScoreStateDataNotComplete() {
		final int SCORE_VALUE = 1;
		Provider provider = ProviderFactory.aProvider();
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setScoreValue(SCORE_VALUE);
		aMenuScore.setUser(provider);
		
		assertFalse(aMenuScore.fullDataIsValid());
	}
	
	@Test
	public void testMenuScoreUserDataNotComplete() {
		final int SCORE_VALUE = 1;
		final ScoreState SCORE_STATE = ScoreState.Pending;
		
		MenuScore aMenuScore = ScoreFactory.anyMenuScore();
		aMenuScore.setScoreValue(SCORE_VALUE);
		aMenuScore.setScoreState(SCORE_STATE);
		
		assertFalse(aMenuScore.fullDataIsValid());
	}
}
