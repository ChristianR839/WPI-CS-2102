import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {

    public Examples() {

    }

    ElectionData Setup_NoVotes() {

        ElectionData eData = new ElectionData();

        try {
            eData.addCandidate("Gompei");
            eData.addCandidate("Husky");
            eData.addCandidate("Tiger");
            eData.addCandidate("Shark");
            eData.addCandidate("Eagle");
        } catch (CandidateExistsException e) {

        }

        return eData;
    }

    ElectionData Setup_NoVotesWithLizard() {

        ElectionData eData = new ElectionData();

        try {
            eData.addCandidate("Gompei");
            eData.addCandidate("Husky");
            eData.addCandidate("Tiger");
            eData.addCandidate("Shark");
            eData.addCandidate("Eagle");
            eData.addCandidate("Lizard");
        } catch (CandidateExistsException e) {

        }

        return eData;
    }

    ElectionData Setup_Normal() {

        ElectionData eData = new ElectionData();

        try {
            eData.addCandidate("Gompei");
            eData.addCandidate("Husky");
            eData.addCandidate("Tiger");
            eData.addCandidate("Shark");
            eData.addCandidate("Eagle");
        } catch (CandidateExistsException e) {

        }

        try {
            eData.processVote("Gompei", "Husky", "Eagle");
            eData.processVote("Gompei", "Tiger", "Eagle");
            eData.processVote("Tiger", "Gompei", "Husky");
            eData.processVote("Gompei", "Tiger", "Shark");
            eData.processVote("Tiger", "Shark", "Husky");
        } catch (UnknownCandidateException e) {

        } catch (DuplicateVotesException e) {

        }

        return eData;
    }

    ElectionData Setup_Empty() {

        ElectionData eData = new ElectionData();

        return eData;
    }

    ElectionData Setup_Tie() {

        ElectionData eData = new ElectionData();

        try {
            eData.addCandidate("Gompei");
            eData.addCandidate("Husky");
            eData.addCandidate("Tiger");
            eData.addCandidate("Shark");
            eData.addCandidate("Eagle");
        } catch (CandidateExistsException e) {

        }

        try {
            eData.processVote("Gompei", "Tiger", "Eagle");
            eData.processVote("Tiger", "Gompei", "Husky");
            eData.processVote("Gompei", "Tiger", "Shark");
            eData.processVote("Tiger", "Gompei", "Husky");
        } catch (UnknownCandidateException e) {

        } catch (DuplicateVotesException e) {

        }

        return eData;
    }

    @Test
    public void testFindWinnerMostFirstVotes_Normal() {
        assertEquals("Gompei", Setup_Normal().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostPoints_Normal() {
        assertEquals("Gompei", Setup_Normal().findWinnerMostPoints());
    }

    @Test
    public void testFindWinnerMostFirstVotes_Empty() {
        assertEquals("No candidates found", Setup_Empty().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostPoints_Empty() {
        assertEquals("No candidates found", Setup_Empty().findWinnerMostPoints());
    }

    @Test
    public void testFindWinnerMostFirstVotes_Tie() {
        assertEquals("Runoff required", Setup_Tie().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostPoints_Tie() {
        // Returns one of the valid winners (in this case: Gompei or Tiger)
        assertEquals("Gompei", Setup_Tie().findWinnerMostPoints());
    }

    @Test(expected = UnknownCandidateException.class)
    public void testVoting_UnknownCand() throws UnknownCandidateException {
        try {
            Setup_NoVotes().processVote("Gompei", "Lizard", "Husky");
        } catch (UnknownCandidateException e) {
            throw new UnknownCandidateException(e.candName);
        } catch (DuplicateVotesException e) {
        }

    }

    @Test(expected = DuplicateVotesException.class)
    public void testVoting_DupVotes() throws DuplicateVotesException {
        try {
            Setup_NoVotes().processVote("Gompei", "Gompei", "Husky");
        } catch (UnknownCandidateException e) {

        } catch (DuplicateVotesException e) {
            throw new DuplicateVotesException(e.candName);
        }

    }

    @Test(expected = CandidateExistsException.class)
    public void testAddCand_DupCand() throws CandidateExistsException {
        try {
            Setup_NoVotes().addCandidate("Gompei");
        } catch (CandidateExistsException e) {
            throw new CandidateExistsException(e.candName);
        }
    }

    @Test
    public void testAddCand_Normal() throws CandidateExistsException {
        ElectionData withLizard = new ElectionData();
        withLizard = Setup_NoVotes();
        withLizard.addCandidate("Lizard");
        // This also tests the equals methods for ElectionData and VoteSet
        assertEquals(withLizard, Setup_NoVotesWithLizard());
    }
}
