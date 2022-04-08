/**
 * An exception that is thrown when a candidate being voted for does not exist on the ballot.
 */
public class UnknownCandidateException extends Exception {
    String candName;

    UnknownCandidateException(String candName) {
        this.candName = candName;
    }
}
