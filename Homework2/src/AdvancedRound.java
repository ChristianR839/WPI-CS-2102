import java.util.LinkedList;

/**
 * An advanced round of a tournament.
 */
public class AdvancedRound extends AbsRound implements IWinner {

    LinkedList<IContestant> contestants;
    LinkedList<IContestant> prevWinners;

    public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
        super(matches);
        this.contestants = contestants;
        this.prevWinners = getMatchWinners();
    }

    /**
     * Determines whether the given contestant is a winner.
     *
     * @param contestant Contestant to check.
     * @return True if the given contestant is a winner.
     */
    public boolean isWinner(IContestant contestant) {
        for (IContestant tempContestant : prevWinners) {
            if (tempContestant.equals(contestant)) {
                return true;
            }
        }
        return false;
    }
}
