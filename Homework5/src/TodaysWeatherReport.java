import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Objects;

/**
 * A report compiling data from readings taken over a specific day.
 */
public class TodaysWeatherReport implements IReport {

    private GregorianCalendar date;
    private LinkedList<Double> tempFReadings;
    private LinkedList<Double> rainfallReadings;

    public TodaysWeatherReport(GregorianCalendar date) {
        this.date = date;
        this.tempFReadings = new LinkedList<Double>();
        this.rainfallReadings = new LinkedList<Double>();
    }

    public TodaysWeatherReport(GregorianCalendar date, LinkedList<Double> tempFReadings, LinkedList<Double> rainfallReadings) {
        this.date = date;
        this.tempFReadings = tempFReadings;
        this.rainfallReadings = rainfallReadings;
    }

    /**
     * Adds a temperature (F) reading to the list.
     *
     * @param tempF The temperature (F) reading to add.
     */
    public void addTempReading(double tempF) {
        this.tempFReadings.add(tempF);
    }

    /**
     * Adds a rainfall reading to the list.
     *
     * @param rainfall The rainfall reading to add.
     */
    public void addRainfallReading(double rainfall) {
        this.rainfallReadings.add(rainfall);
    }

    /**
     * Checks if the month of a report is the same as the given month.
     *
     * @param month The given month to compare the report to.
     * @return True if the month of the report is the same as the given month.
     */
    public boolean monthMatches(int month) {
        return (this.date.get(GregorianCalendar.MONTH) == month);
    }

    /**
     * Checks if the year of a report is the same as the given year.
     *
     * @param year The given year to compare the report to.
     * @return True if the year of the report is the same as the given month.
     */
    public boolean yearMatches(int year) {
        return (this.date.get(GregorianCalendar.YEAR) == year);
    }

    /**
     * Exports all the temperature (F) readings in the report.
     *
     * @return All the temperature (F) readings in the report.
     */
    public LinkedList<Double> exportAllTemps() {
        return tempFReadings;
    }

    /**
     * Exports all the rainfall readings in the report.
     *
     * @return All the rainfall readings in the report.
     */
    public LinkedList<Double> exportAllRainfall() {
        return rainfallReadings;
    }

    /**
     * Overrides Object equals method for TodaysWeatherReport.
     * @param obj The object to compare against.
     * @return True if the given object is equal to the report.
     */
    public boolean equals(Object obj) {
        TodaysWeatherReport report = (TodaysWeatherReport) obj;

        if (this.date != report.date) return false;

        if (this.tempFReadings.size() == report.tempFReadings.size()) {
            for (int i = 0; i < this.tempFReadings.size(); i++) {
                // I was trying to use != to compare these, but IntelliJ presented a warning and recommended
                // that I do this instead. That is why these objects are compared this way.
                if (!Objects.equals(this.tempFReadings.get(i), report.tempFReadings.get(i))) return false;
            }
        } else return false;

        if (this.rainfallReadings.size() == report.rainfallReadings.size()) {
            for (int i = 0; i < this.rainfallReadings.size(); i++) {
                // I was trying to use != to compare these, but IntelliJ presented a warning and recommended
                // that I do this instead. That is why these objects are compared this way.
                if (!Objects.equals(this.rainfallReadings.get(i), report.rainfallReadings.get(i))) return false;
            }
        } else return false;

        return true;
    }
}
