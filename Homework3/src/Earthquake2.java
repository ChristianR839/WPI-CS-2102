import java.util.LinkedList;

/**
 * A class containing methods to handle data relating to earthquakes.
 */
class Earthquake2 {

    Earthquake2() {
    }

    /**
     * Checks whether a datum is a date.
     *
     * @param anum The number to check.
     * @return True if the number is formatted as a date.
     */
    boolean isDate(double anum) {
        return (int) anum > 10000000;
    }

    /**
     * Extracts the month from an 8-digit date.
     *
     * @param dateNum The date.
     * @return An integer 1 to 12 representing the month that date is in.
     */
    int extractMonth(double dateNum) {
        return ((int) dateNum % 10000) / 100;
    }

    /**
     * Creates a list of reports for all data found in the given month.
     *
     * @param data  List of data to be analyzed.
     * @param month Month to be isolated.
     * @return A list of reports containing all the data found in the given month.
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

        LinkedList<MaxHzReport> report = new LinkedList<MaxHzReport>();

        int dateIndex = 0;
        double highest = 0;

        for (int i = 0; i < data.size(); i++) {
            if ((i != 0) && (isDate(data.get(i))) && (extractMonth(data.get(i)) == month)) {
                if (dateIndex > 0) {
                    MaxHzReport thisReport = new MaxHzReport(data.get(dateIndex), highest);
                    report.add(thisReport);
                }
                highest = 0;
                dateIndex = i;
            } else if (isDate(data.get(i)) && (extractMonth(data.get(i)) == month)) {
                dateIndex = i;
            } else if (isDate(data.get(i)) && (extractMonth(data.get(i)) != month)) {
                dateIndex = -1;
            } else if ((!isDate(data.get(i))) && (dateIndex > 0) && (extractMonth(data.get(dateIndex)) == month)) {
                if (data.get(i) > highest) {
                    highest = data.get(i);
                }
            }
            // Catch a report creation on the last loop
            if ((data.size() - i) == 1) {
                if (dateIndex > 0) {
                    MaxHzReport thisReport = new MaxHzReport(data.get(dateIndex), highest);
                    report.add(thisReport);
                }
                highest = 0;
                dateIndex = i;
            }
        }
        return report;
    }
}