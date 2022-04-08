import java.util.LinkedList;

/**
 * \
 * The abstract class for all Rounds.
 */
public abstract class AbsRound {

    LinkedList<Match> matches;

    public AbsRound(LinkedList<Match> matches) {
        this.matches = matches;
    }

    /**
     * Produces a list of winning contestants from a round.
     *
     * @return A List of winning contestants.
     */
    public LinkedList<IContestant> getMatchWinners() {
        LinkedList<IContestant> winnersList = new LinkedList<IContestant>();
        for (Match match : matches) {
            if (match.winner() != null) {
                winnersList.add(match.winner());
            }
        }
        return winnersList;
    }

    /**
     * Counts the number of winning contestants in a round.
     *
     * @return The number of winning contestants.
     */
    public int getNumWinners() {
        return getMatchWinners().size();
    }
}
