/**
 * An exception that is thrown when a candidate is attempting to be added to the ballot but is already on it.
 */
public class CandidateExistsException extends Exception {
    String candName;

    CandidateExistsException(String candName) {
        this.candName = candName;
    }
}
