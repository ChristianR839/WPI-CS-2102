/**
 * An interface for Rounds that requires a method to check winners.
 */
public interface IWinner {
    public boolean isWinner(IContestant contestant);
}
