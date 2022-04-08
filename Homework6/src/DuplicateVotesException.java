/**
 * An exception thrown when multiple of the same candidate are attempted to be voted for.
 */
public class DuplicateVotesException extends Exception {
    String candName;

    DuplicateVotesException(String candName) {
        this.candName = candName;
    }
}
