import java.util.LinkedList;

/**
 * An interface for reports that is used to encapsulate data from a Weather Station.
 */
public interface IReport {

    void addTempReading(double tempF);

    void addRainfallReading(double rainfall);

    boolean monthMatches(int month);

    boolean yearMatches(int year);

    LinkedList<Double> exportAllTemps();

    LinkedList<Double> exportAllRainfall();
}
