import java.util.Hashtable;

/**
 * A class that houses methods for voting and handling election data.
 */
class ElectionData {
    private Hashtable<String, VoteSet> ballot = new Hashtable<String, VoteSet>();

    ElectionData() {

    }

    /**
     * Displays to the user the candidates on the ballot for the election.
     */
    public void printBallot() {
        System.out.println("The candidates are ");

        for (String s : ballot.keySet()) {
            System.out.println(s);
        }
    }

    /**
     * Takes a user's votes and modifies vote counts to represent the new votes.
     *
     * @param c1 The first choice candidate that received a vote.
     * @param c2 The second choice candidate that received a vote.
     * @param c3 The third choice candidate that received a vote.
     * @throws UnknownCandidateException If the candidate attempting to be voted for does not exist on the ballot.
     * @throws DuplicateVotesException   If multiple votes were cast for the same candidate.
     */
    public void processVote(String c1, String c2, String c3) throws UnknownCandidateException, DuplicateVotesException {
        if (!ballot.containsKey(c1)) throw new UnknownCandidateException(c1);
        if (!ballot.containsKey(c2)) throw new UnknownCandidateException(c2);
        if (!ballot.containsKey(c3)) throw new UnknownCandidateException(c3);
        if (c1.equals(c2)) throw new DuplicateVotesException(c1);
        if (c2.equals(c3)) throw new DuplicateVotesException(c2);
        if (c3.equals(c1)) throw new DuplicateVotesException(c3);
        ballot.get(c1).addFirstChoice();
        ballot.get(c2).addSecondChoice();
        ballot.get(c3).addThirdChoice();
    }

    /**
     * Adds a candidate to the current election ballot.
     *
     * @param cand The name of the candidate to add.
     * @throws CandidateExistsException If the candidate attempting to be added is already on the ballot.
     */
    public void addCandidate(String cand) throws CandidateExistsException {
        for (String c : ballot.keySet()) {
            if (c.equals(cand)) throw new CandidateExistsException(cand);
        }
        ballot.put(cand, new VoteSet());
    }

    /**
     * Calculates the winner of an election based on the number of first choice votes they received.
     *
     * @return The winning candidate.
     */
    public String findWinnerMostFirstVotes() {
        if (ballot.isEmpty()) return "No candidates found";
        double totalVotes = 0.0;
        for (String c : ballot.keySet()) {
            totalVotes = totalVotes + ballot.get(c).getcFirst();
        }
        double majorityBound = (totalVotes / 2);
        for (String c : ballot.keySet()) {
            if (ballot.get(c).getcFirst() > majorityBound) return c;
        }
        return "Runoff required";
    }

    /**
     * Calculates the winner of an election based on point values from weighted vote counts.
     *
     * @return The winning candidate.
     */
    public String findWinnerMostPoints() {
        if (ballot.isEmpty()) return "No candidates found";
        String topCand = "No candidates found";
        double topPoints = 0;
        for (String c : ballot.keySet()) {
            double pts = ballot.get(c).calcPoints();
            if (pts > topPoints) {
                topCand = c;
                topPoints = pts;
            }
        }
        return topCand;
    }

    /**
     * Overrides equals method to determine if two ElectionData objects are equal.
     *
     * @param obj The object to compare against.
     * @return True if the objects are equal.
     */
    public boolean equals(Object obj) {
        ElectionData eData = (ElectionData) obj;
        if (this.ballot.size() != eData.ballot.size()) return false;
        for (String c : eData.ballot.keySet()) {
            if (!this.ballot.containsKey(c)) return false;
            if (!this.ballot.get(c).equals(eData.ballot.get(c))) return false;
        }
        return true;
    }
}
