import java.util.Scanner;

public class VotingMachine {

    private ElectionData eData;
    private Scanner keyboard = new Scanner(System.in);

    public VotingMachine() {
        eData = new ElectionData();
    }

    /**
     * Handles the display and user input for voting.
     */
    public void screen() {

        eData.printBallot();
        System.out.println("Who do you want your first vote to be for?");
        String c1 = keyboard.next();
        System.out.println("Who do you want your second vote to be for?");
        String c2 = keyboard.next();
        System.out.println("Who do you want your third vote to be for?");
        String c3 = keyboard.next();
        try {
            eData.processVote(c1, c2, c3);
        } catch (UnknownCandidateException e) {
            System.out.println("Candidate \"" + e.candName + "\" is unknown. Would you like to add the candidate to the ballot? (Y/N)");
            String addAns = keyboard.next();
            if (addAns.equalsIgnoreCase("Y")) {
                addWriteIn(e.candName);
            } else {
                System.out.println("Please cast your votes again.");
            }
            this.screen();
            return;
        } catch (DuplicateVotesException e) {
            System.out.println("Candidate \"" + e.candName + "\" was voted for multiple times. Please cast your votes again.");
            this.screen();
            return;
        }
        System.out.println("You voted for " + c1 + ", " + c2 + ", " + c3);
    }

    /**
     * Adds a new candidate to the ballot if it doesn't already exist.
     *
     * @param candName The candidate to consider adding.
     */
    public void addWriteIn(String candName) {
        try {
            eData.addCandidate(candName);
        } catch (CandidateExistsException e) {
            System.out.println("Candidate \"" + candName + "\" already exists on the ballot. Please cast your votes again.");
        }
        System.out.println("Candidate \"" + candName + "\" added successfully! Please cast your votes again");
    }
}
