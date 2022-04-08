import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Examples {

	public Examples() {
	}

	SoccerTeam eagles = new SoccerTeam("United States", "Blue", true, 3, 5);
	SoccerTeam tigers = new SoccerTeam("Brazil", "Green", true, 6, 2);
	SoccerTeam sharks = new SoccerTeam("Italy", "Red", false, 4, 4);
	SoccerTeam eagles2 = new SoccerTeam("United States", "Blue", true, 3, 5);

	LegoRobotTeam builders = new LegoRobotTeam("Valley Middle School", "Arm", 8);
	LegoRobotTeam creators = new LegoRobotTeam("East Middle School", "Plow", 1);
	LegoRobotTeam knights = new LegoRobotTeam("Oak Middle School", "Hook", 13);
	LegoRobotTeam builders2 = new LegoRobotTeam("Valley Middle School", "Arm", 8);

	SoccerResult eaglesTigersResults = new SoccerResult(eagles, tigers, 2, 4);
	SoccerResult tigersSharksResults = new SoccerResult(tigers, sharks, 5, 1);
	SoccerResult sharksEaglesResults = new SoccerResult(sharks, eagles, 3, 3);
	SoccerResult invalidSoccerResults = new SoccerResult(sharks, eagles, 999, 3);

	LegoRobotResult buildersCreatorsResults = new LegoRobotResult(builders, creators, 5, 7, false, 3, 4, true);
	LegoRobotResult creatorsKnightsResults = new LegoRobotResult(creators, knights, 1, 3, false, 6, 7, false);
	LegoRobotResult knightsBuildersResults = new LegoRobotResult(knights, builders, 2, 2, false, 5, 4, true);
	LegoRobotResult invalidLegoRobotResults = new LegoRobotResult(knights, creators, 999, 999, false, 999, 999, false);

	Match eaglesTigersMatch = new Match(eagles, tigers, eaglesTigersResults);
	Match invalidMatch = new Match(knights, creators, invalidLegoRobotResults);

	// SoccerTeam

	@Test
	public void testExpectToBeat_FirstHasRitual() {
		assertTrue(eagles.expectToBeat(sharks));
	}

	@Test
	public void testExpectToBeat_SecondHasRitual() {
		assertFalse(sharks.expectToBeat(eagles));
	}

	@Test
	public void testExpectToBeat_BothHaveRitual_FirstHasBetterWL() {
		assertTrue(tigers.expectToBeat(eagles));
	}

	@Test
	public void testExpectToBeat_BothHaveRitual_SecondHasBetterWL() {
		assertFalse(eagles.expectToBeat(tigers));
	}

	@Test
	public void testExpectToBeat_BothHaveRitual_SameWL() {
		assertFalse(eagles.expectToBeat(eagles2));
	}

	// LegoRobotTeam

	@Test
	public void testExpectToBeat_FirstHasHigherPrevScore() {
		assertTrue(builders.expectToBeat(creators));
	}

	@Test
	public void testExpectToBeat_SecondHasHigherPrevScore() {
		assertFalse(creators.expectToBeat(knights));
	}

	@Test
	public void testExpectToBeat_SamePrevScore() {
		assertFalse(builders.expectToBeat(builders2));
	}

	// SoccerResult

	@Test
	public void testIsValidSR_ValidMatch() {
		assertTrue(eaglesTigersResults.isValid());
	}

	@Test
	public void testIsValidSR_InvalidMatch() {
		assertFalse(invalidSoccerResults.isValid());
	}

	@Test
	public void testGetWinnerSR_FirstTeamWins() {
		assertEquals(tigers, tigersSharksResults.getWinner());
	}

	@Test
	public void testGetWinnerSR_SecondTeamWins() {
		assertEquals(tigers, eaglesTigersResults.getWinner());
	}

	@Test
	public void testGetWinnerSR_NoWinner() {
		assertEquals(null, sharksEaglesResults.getWinner());
	}

	// LegoRobotResult

	@Test
	public void testIsValidLRR_ValidMatch() {
		assertTrue(buildersCreatorsResults.isValid());
	}

	@Test
	public void testIsValidLRR_InvalidMatch() {
		assertFalse(invalidLegoRobotResults.isValid());
	}

	@Test
	public void testGetScore_NoFall() {
		assertEquals(10, buildersCreatorsResults.getScore(5, 5, false), 0.1);
	}

	@Test
	public void testGetScore_Fall() {
		assertEquals(5, buildersCreatorsResults.getScore(5, 5, true), 0.1);
	}

	@Test
	public void testGetWinnerLRR_FirstTeamWins() {
		assertEquals(builders, buildersCreatorsResults.getWinner());
	}

	@Test
	public void testGetWinnerLRR_SecondTeamWins() {
		assertEquals(knights, creatorsKnightsResults.getWinner());
	}

	@Test
	public void testGetWinnerLRR_NoWinner() {
		assertEquals(null, knightsBuildersResults.getWinner());
	}

	// Match

	@Test
	public void testWinner_Valid() {
		assertEquals(tigers, eaglesTigersMatch.winner());
	}

	@Test
	public void testWinner_Invalid() {
		assertEquals(null, invalidMatch.winner());
	}
}