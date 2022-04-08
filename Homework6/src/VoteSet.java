/**
 * A data type that houses all the votes for one candidate.
 */
public class VoteSet {

    private int cFirst;
    private int cSecond;
    private int cThird;

    public VoteSet() {
        this.cFirst = 0;
        this.cSecond = 0;
        this.cThird = 0;
    }

    public VoteSet(int firstChoice, int secondChoice, int thirdChoice) {
        this.cFirst = firstChoice;
        this.cSecond = secondChoice;
        this.cThird = thirdChoice;
    }

    /**
     * Adds one first choice vote to the candidate's total.
     */
    public void addFirstChoice() {
        cFirst++;
    }

    /**
     * Adds one second choice vote to the candidate's total.
     */
    public void addSecondChoice() {
        cSecond++;
    }

    /**
     * Adds one third choice vote to the candidate's total.
     */
    public void addThirdChoice() {
        cThird++;
    }

    /**
     * Gets the amount of first choice votes the candidate has.
     *
     * @return The number of first choice votes.
     */
    public int getcFirst() {
        return cFirst;
    }

    /**
     * Calculates the number of points the candidate has based off their votes.
     *
     * @return The number of points the candidate has.
     */
    public double calcPoints() {
        return (this.cFirst * 3) + (this.cSecond * 2) + (this.cThird);
    }

    /**
     * Overrides equals method to determine if two VoteSet objects are equal.
     *
     * @param obj The object to compare against.
     * @return True if the objects are equal.
     */
    public boolean equals(Object obj) {
        VoteSet votes = (VoteSet) obj;
        if (this.cFirst != votes.cFirst) return false;
        if (this.cSecond != votes.cSecond) return false;
        if (this.cThird != votes.cThird) return false;
        return true;
    }
}
