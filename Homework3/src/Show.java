import java.util.LinkedList;

/**
 * A show to play on TV.
 */
class Show {

    String title;
    double broadcastTime;
    double avgEpLength;
    boolean isSpecial;

    public Show(String title, double broadcastTime, double avgEpLength, boolean isSpecial) {
        this.title = title;
        this.broadcastTime = broadcastTime;
        this.avgEpLength = avgEpLength;
        this.isSpecial = isSpecial;
    }

    /**
     * Determines if the titles of two shows are the same.
     *
     * @param show The show to compare against.
     * @return True if the shows have the same title.
     */
    public boolean titlesAreSame(Show show) {
        return (this.title.equals(show.title));
    }

    /**
     * Determines if the broadcast times of two shows are the same.
     *
     * @param show The show to compare against.
     * @return True if the shows have the same broadcast time.
     */
    public boolean timesAreSame(Show show) {
        return (this.broadcastTime == show.broadcastTime);
    }

    /**
     * Determines if two shows are equal.
     *
     * @param obj The show to compare against.
     * @return True if the shows have the same title and broadcast time.
     */
    public boolean equals(Object obj) {
        Show show = (Show) obj;
        return (titlesAreSame((show)) && timesAreSame(show));
    }
}
