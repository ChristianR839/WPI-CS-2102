import java.util.LinkedList;

/**
 * A class containing methods to handle data relating to earthquakes.
 */
class Earthquake1 {

    Earthquake1() {
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
     * @param data List of data to be analyzed.
     * @param month Month to be isolated.
     * @return A list of reports containing all the data found in the given month.
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {

        LinkedList<Double> cleanedData = new LinkedList<Double>();
        LinkedList<MaxHzReport> report = new LinkedList<MaxHzReport>();

        for (Double thisData : data) {
            if (thisData > 0) {
                cleanedData.add(thisData);
            }
        }
        for (int i = 0; i < cleanedData.size(); i++) {
            if (isDate(cleanedData.get(i))) {
                if (extractMonth(cleanedData.get(i)) == month) {
                    double highest = 0;
                    boolean loop = true;
                    for (int j = (i + 1); loop; j++) {
                        if (highest < cleanedData.get(j)) {
                            highest = cleanedData.get(j);
                        }
                        if (!isDate(cleanedData.get(j))) {
                            loop = false;
                        }
                    }
                    MaxHzReport thisReport = new MaxHzReport(cleanedData.get(i), highest);
                    report.add(thisReport);
                }
            }
        }
        return report;
    }
}  

