import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A class that houses daily weather reports and methods to calculate data from them.
 */
public class WeatherStation {

    private LinkedList<IReport> dailyReports;

    public WeatherStation() {
        dailyReports = new LinkedList<IReport>();
    }

    public WeatherStation(LinkedList<IReport> reportList) {
        this.dailyReports = reportList;
    }

    /**
     * Takes in a collection of readings from a given date, creates a new daily report, and stores it in the list.
     *
     * @param date     The date the readings were taken.
     * @param readings The collection of readings.
     */
    public void addTodaysReport(GregorianCalendar date, LinkedList<IReading> readings) {
        TodaysWeatherReport newReport = new TodaysWeatherReport(date);
        for (IReading reading : readings) {
            newReport = reading.addToReport(newReport);
        }
        dailyReports.add(newReport);
    }

    /**
     * Calculates the average temperature (F) measured throughout a given month.
     *
     * @param month The month to calculate the average of.
     * @return The average temperature (F) of the given month.
     */
    public double averageMonthTemp(int month) {
        LinkedList<LinkedList<Double>> tempsF = new LinkedList<LinkedList<Double>>();
        for (IReport report : dailyReports) {
            if (report.monthMatches(month)) {
                tempsF.add(report.exportAllTemps());
            }
        }
        double sum = 0;
        double avg = 0;
        int count = 0;
        for (int i = 0; i < tempsF.size(); i++) {
            for (int j = 0; j < tempsF.get(i).size(); j++) {
                sum = sum + tempsF.get(i).get(j);
                count++;
            }
            if (i == (tempsF.size() - 1)) {
                avg = sum / count;
            }
        }
        return avg;
    }

    /**
     * Calculates the total rainfall measured throughout a given month in a given year.
     *
     * @param month The month to calculate the total of.
     * @param year  The year of the month to calculate the total of.
     * @return The total rainfall of the given month.
     */
    public double totalMonthRainfall(int month, int year) {
        LinkedList<LinkedList<Double>> rainfall = new LinkedList<LinkedList<Double>>();
        for (IReport report : dailyReports) {
            if (report.monthMatches(month) && report.yearMatches(year)) {
                rainfall.add(report.exportAllRainfall());
            }
        }
        double sum = 0;
        for (int i = 0; i < rainfall.size(); i++) {
            for (int j = 0; j < rainfall.get(i).size(); j++) {
                sum = sum + rainfall.get(i).get(j);
            }
        }
        return sum;
    }

    /**
     * Overrides Object equals method for WeatherStation.
     * @param obj The object to compare against.
     * @return True if the given object is equal to the station.
     */
    public boolean equals(Object obj) {
        WeatherStation station = (WeatherStation) obj;

        if (this.dailyReports.size() != station.dailyReports.size()) return false;

        for (int i = 0; i < this.dailyReports.size(); i++) {
            if (!(this.dailyReports.get(i).equals(station.dailyReports.get(i)))) return false;
        }

        return true;
    }
}
