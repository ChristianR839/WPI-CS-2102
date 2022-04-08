import java.util.LinkedList;

/**
 * A collection of rounds.
 */
public class Tournament {

    LinkedList<IWinner> rounds;

    public Tournament(LinkedList<IWinner> rounds) {
        this.rounds = rounds;
    }

    /**
     * Determines whether the given contestant is a valid winner.
     *
     * @param winningContestant Contestant to check.
     * @return True if the given contestant is a valid winner.
     */
    public boolean finalWinnerIsValid(IContestant winningContestant) {
        for (IWinner tempRound : rounds) {
            if (tempRound.isWinner(winningContestant)) {
                return true;
            }
        }
        return false;
    }
}
