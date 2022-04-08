import java.util.LinkedList;

/**
 * An initial round of a tournament.
 */
public class InitialRound extends AbsRound implements IWinner {

    public InitialRound(LinkedList<Match> matches) {
        super(matches);
    }

    /**
     * Determines whether the given contestant is a winner.
     *
     * @param contestant Contestant to check.
     * @return True if the given contestant is a winner.
     */
    public boolean isWinner(IContestant contestant) {
        for (IContestant tempContestant : getMatchWinners()) {
            if (tempContestant.equals(contestant)) {
                return true;
            }
        }
        return false;
    }
}
