import java.util.LinkedList;

/**
 * A collection of shows to be played in a given day.
 */
class ShowSummary {

    LinkedList<Show> daytime;
    LinkedList<Show> primetime;
    LinkedList<Show> latenight;

    ShowSummary() {
        this.daytime = new LinkedList<Show>();
        this.primetime = new LinkedList<Show>();
        this.latenight = new LinkedList<Show>();
    }

    ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight) {
        this.daytime = daytime;
        this.primetime = primetime;
        this.latenight = latenight;
    }

    /**
     * Determines if all the show lists are the same size as those of another show summary.
     *
     * @param summary The show summary to compare against.
     * @return True if the show lists have the same number of shows in them.
     */
    public boolean allListsSameSize(ShowSummary summary) {
        return ((this.daytime.size() == summary.daytime.size()) &&
                (this.primetime.size() == summary.primetime.size()) &&
                (this.latenight.size() == summary.latenight.size()));
    }

    /**
     * Determines if all the show lists contain the same information as another show summary.
     *
     * @param show The show sumamry to compare against.
     * @return True if the show lists contain the same shows in the same order.
     */
    public boolean allListsSameContent(ShowSummary show) {
        if (!allListsSameSize(show)) {
            return false;
        }
        for (int i = 0; i < show.daytime.size(); i++) {
            if (this.daytime.get(i).equals(show.daytime.get(i))) {

            } else {
                return false;
            }
        }
        for (int i = 0; i < show.primetime.size(); i++) {
            if (this.primetime.get(i).equals(show.primetime.get(i))) {

            } else {
                return false;
            }
        }
        for (int i = 0; i < show.latenight.size(); i++) {
            if (this.latenight.get(i).equals(show.latenight.get(i))) {

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if two show summaries are equal.
     *
     * @param obj The show summary to compare against.
     * @return True if the show summaries have the same list size, contents, and order
     */
    public boolean equals(Object obj) {
        ShowSummary summary = (ShowSummary) obj;
        return (this.allListsSameSize(summary) && this.allListsSameContent(summary));
    }
}
