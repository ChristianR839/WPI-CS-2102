import java.util.LinkedList;

/**
 * An instant weather reading taken at a specific time.
 */
public class Reading implements IReading {

    private Time time;
    private double tempF;
    private double rainfall;

    public Reading(Time time, double tempF, double rainfall) {
        this.time = time;
        this.tempF = tempF;
        this.rainfall = rainfall;
    }

    /**
     * Takes data from the reading and adds it to a given daily report.
     *
     * @param report The report to add to.
     * @return The updated report.
     */
    public TodaysWeatherReport addToReport(TodaysWeatherReport report) {
        report.addTempReading(this.tempF);
        report.addRainfallReading(this.rainfall);
        return report;
    }

    /**
     * Overrides Object equals method for Reading.
     * @param obj The object to compare against.
     * @return True if the given object is equal to the reading.
     */
    public boolean equals(Object obj) {
        Reading reading = (Reading) obj;
        return ((this.time.equals(reading.time)) &&
                (this.tempF == reading.tempF) &&
                (this.rainfall == reading.rainfall));
    }
}
