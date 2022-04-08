import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    VoteData vData = new VoteData();

    String c1 = "Candidate1";
    String c2 = "Candidate2";
    String c3 = "Candidate3";

    String nw = "No Winner";

    public Examples() {

    }

    // castVote

    @Test
    public void testCastVote_OneStringAdded() {
        vData.castVote(c1);
        assertTrue(vData.votes.size() == 1);
    }

    @Test
    public void testCastVote_CorrectOneStringAdded() {
        vData.castVote(c1);
        assertTrue(vData.votes.get(0).equals(c1));
    }

    @Test
    public void testCastVote_ThreeStringsAdded() {
        vData.castVote(c1);
        vData.castVote(c2);
        vData.castVote(c3);
        assertTrue(vData.votes.size() == 3);
    }

    @Test
    public void testCastVote_CorrectThreeStringsAdded() {
        vData.castVote(c1);
        vData.castVote(c2);
        vData.castVote(c3);
        assertTrue(vData.votes.get(0).equals(c1) && vData.votes.get(1).equals(c2) && vData.votes.get(2).equals(c3));
    }

    // addCandidate

    @Test
    public void testAddCandidate_OneStringAdded() {
        vData.addCandidate(c1);
        assertTrue(vData.ballot.size() == 1);
    }

    @Test
    public void testAddCandidate_CorrectOneStringAdded() {
        vData.addCandidate(c1);
        assertTrue(vData.ballot.get(0).equals(c1));
    }

    @Test
    public void testAddCandidate_ThreeStringsAdded() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        assertTrue(vData.ballot.size() == 3);
    }

    @Test
    public void testAddCandidate_CorrectThreeStringsAdded() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        assertTrue(vData.ballot.get(0).equals(c1) && vData.ballot.get(1).equals(c2) && vData.ballot.get(2).equals(c3));
    }

    // countVotes

    @Test
    public void testCountVotes_NoVotes() {
        assertEquals(vData.countVotes(c1), 0, 0.1);
    }

    @Test
    public void testCountVotes_1VoteNoOthers() {
        vData.castVote(c1);
        assertEquals(vData.countVotes(c1), 1, 0.1);
    }

    @Test
    public void testCountVotes_3VotesNoOthers() {
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c1);
        assertEquals(vData.countVotes(c1), 3, 0.1);
    }

    @Test
    public void testCountVotes_1Vote1Other() {
        vData.castVote(c1);
        vData.castVote(c2);
        assertEquals(vData.countVotes(c1), 1, 0.1);
    }

    @Test
    public void testCountVotes_3Votes3Others() {
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c2);
        vData.castVote(c2);
        vData.castVote(c2);
        assertEquals(vData.countVotes(c1), 3, 0.1);
    }

    // winner

    @Test
    public void testWinner_NoVotes() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        assertTrue(vData.winner().equals(nw));
    }

    @Test
    public void testWinner_1Vote() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        vData.castVote(c1);
        assertTrue(vData.winner().equals(c1));
    }

    @Test
    public void testWinner_3Votes() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c1);
        assertTrue(vData.winner().equals(c1));
    }

    @Test
    public void testWinner_3Votes2Other() {
        vData.addCandidate(c1);
        vData.addCandidate(c2);
        vData.addCandidate(c3);
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c1);
        vData.castVote(c2);
        vData.castVote(c2);
        assertTrue(vData.winner().equals(c1));
    }
}
