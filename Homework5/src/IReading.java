/**
 * An interface for readings that is used to encapsulate data from a Weather Station.
 */
public interface IReading {

    TodaysWeatherReport addToReport(TodaysWeatherReport report);
}
