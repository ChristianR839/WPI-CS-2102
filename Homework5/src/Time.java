/**
 * A data type to represent time.
 */
public class Time {

    private int hour;
    private int minutes;

    public Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    /**
     * Overrides Object equals method for Time.
     * @param obj The object to compare against.
     * @return True if the given object is equal to the time.
     */
    public boolean equals(Object obj) {
        Time time = (Time) obj;
        return ((this.hour == time.hour) &&
                (this.minutes == time.minutes));
    }
}
