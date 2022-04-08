import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Examples {

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
    Match tigersSharksMatch = new Match(tigers, sharks, tigersSharksResults);
    Match sharksEaglesMatch = new Match(sharks, eagles, sharksEaglesResults);
    Match invalidMatch = new Match(knights, creators, invalidLegoRobotResults);

    LinkedList<Match> iRoundMatches = new LinkedList<Match>();
    LinkedList<IContestant> iRoundWinners = new LinkedList<IContestant>();

    LinkedList<Match> aRoundMatches = new LinkedList<Match>();
    LinkedList<IContestant> aRoundContestants = new LinkedList<IContestant>();

    LinkedList<IWinner> tourneyWinners = new LinkedList<IWinner>();

    InitialRound iRound = new InitialRound(iRoundMatches);
    AdvancedRound aRound;
    Tournament tourney = new Tournament(tourneyWinners);

    public Examples() {

    }

    @Before
    public void setup() {
        iRoundMatches.add(eaglesTigersMatch);
        iRoundMatches.add(tigersSharksMatch);

        iRoundWinners.add(tigers);
        iRoundWinners.add(tigers);

        aRoundMatches.add(tigersSharksMatch);
        aRoundMatches.add(sharksEaglesMatch);

        aRoundContestants.add(tigers);
        aRoundContestants.add(sharks);
        aRoundContestants.add(eagles);

        aRound = new AdvancedRound(aRoundMatches, aRoundContestants);

        tourneyWinners.add(iRound);
    }

    // AbsRound

    @Test
    public void testGetMatchWinners() {
        assertEquals(iRound.getMatchWinners(), iRoundWinners);
    }

    @Test
    public void testNumWinners() {
        assertEquals(iRound.getNumWinners(), 2, 0.1);
    }

    // Initial Round

    @Test
    public void testInitialIsWinner_True() {
        assertTrue(iRound.isWinner(tigers));
    }

    @Test
    public void testInitialIsWinner_False() {
        assertFalse(iRound.isWinner(eagles));
    }

    // Advanced Round

    @Test
    public void testAdvancedIsWinner_True() {
        assertTrue(aRound.isWinner(tigers));
    }

    @Test
    public void testAdvancedIsWinner_False() {
        assertFalse(aRound.isWinner(sharks));
    }

    // Tournament

    @Test
    public void testFinalWinnerIsValid_True() {
        assertTrue(tourney.finalWinnerIsValid(tigers));
    }

    @Test
    public void testFinalWinnerIsValid_False() {
        assertFalse(tourney.finalWinnerIsValid(eagles));
    }
}