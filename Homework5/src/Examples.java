import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    Time time = new Time(7, 17);

    GregorianCalendar date1 = new GregorianCalendar();
    GregorianCalendar date2 = new GregorianCalendar();
    GregorianCalendar date3 = new GregorianCalendar();

    LinkedList<Double> empty = new LinkedList<Double>();
    LinkedList<Double> report1TempList = new LinkedList<Double>();
    LinkedList<Double> report1RainList = new LinkedList<Double>();
    LinkedList<Double> report2TempList = new LinkedList<Double>();
    LinkedList<Double> report2TempList2 = new LinkedList<Double>();
    LinkedList<Double> report2RainList = new LinkedList<Double>();
    LinkedList<Double> report3TempList = new LinkedList<Double>();
    LinkedList<Double> report3RainList = new LinkedList<Double>();
    LinkedList<Double> report3RainList2 = new LinkedList<Double>();

    Reading reading1;
    Reading reading2;
    Reading reading3;

    LinkedList<IReading> readingList1 = new LinkedList<IReading>();

    TodaysWeatherReport report1;
    TodaysWeatherReport report1Full;
    TodaysWeatherReport report2;
    TodaysWeatherReport report2Full;
    TodaysWeatherReport report3;
    TodaysWeatherReport report3Full;

    LinkedList<IReport> reportList1 = new LinkedList<IReport>();
    LinkedList<IReport> reportListFull = new LinkedList<IReport>();

    WeatherStation emptyStation;
    WeatherStation station1;
    WeatherStation stationFull;

    public Examples() {
    }

    @Before
    public void setup() {

        date1.set(2021, Calendar.NOVEMBER, 15);
        date2.set(2021, Calendar.NOVEMBER, 12);
        date3.set(2020, Calendar.OCTOBER, 15);

        report1TempList.add(45.0);
        report1RainList.add(5.0);

        report2TempList.add(80.0);
        report2TempList2.add(80.0);
        report2TempList2.add(85.0);
        report2RainList.add(10.0);
        report3TempList.add(60.0);
        report3RainList.add(15.0);
        report3RainList2.add(15.0);
        report3RainList2.add(25.0);

        reading1 = new Reading(time, 45.0, 5.0);
        reading2 = new Reading(time, 80.0, 10.0);
        reading3 = new Reading(time, 60.0, 15.0);

        readingList1.add(reading1);

        report1 = new TodaysWeatherReport(date1);
        report1Full = new TodaysWeatherReport(date1, report1TempList, report1RainList);
        report2 = new TodaysWeatherReport(date2, report2TempList, report2RainList);
        report2Full = new TodaysWeatherReport(date2, report2TempList2, report2RainList);
        report3 = new TodaysWeatherReport(date3, report3TempList, report3RainList);
        report3Full = new TodaysWeatherReport(date3, report3TempList, report3RainList2);

        reportList1.add(report1Full);
        reportListFull.add(report1Full);
        reportListFull.add(report2Full);
        reportListFull.add(report3Full);

        emptyStation = new WeatherStation();
        station1 = new WeatherStation(reportList1);
        stationFull = new WeatherStation(reportListFull);
    }

    @Test
    public void testAddToReport() {
        assertEquals(report1Full, reading1.addToReport(report1));
    }

    @Test
    public void testAddTempReading() {
        report2.addTempReading(85.0);
        assertEquals(report2Full, report2);
    }

    @Test
    public void testAddRainFallReading() {
        report3.addRainfallReading(25.0);
        assertEquals(report3Full, report3);
    }

    @Test
    public void testMonthMatches_True() {
        assertTrue(report1Full.monthMatches(10));
    }

    @Test
    public void testMonthMatches_False() {
        assertFalse(report1Full.monthMatches(5));
    }

    @Test
    public void testYearMatches_True() {
        assertTrue(report1Full.yearMatches(2021));
    }

    @Test
    public void testYearMatches_False() {
        assertFalse(report1Full.monthMatches(2020));
    }

    @Test
    public void testExportAllTemps() {
        assertEquals(report2TempList2, report2Full.exportAllTemps());
    }

    @Test
    public void testExportAllRainfall() {
        assertEquals(report3RainList2, report3Full.exportAllRainfall());
    }

    @Test
    public void testAddTodaysReport() {
        emptyStation.addTodaysReport(date1, readingList1);
        assertEquals(station1, emptyStation);
    }

    @Test
    public void testAverageMonthTemp() {
        assertEquals(70.0, stationFull.averageMonthTemp(10), 0.1);
    }

    @Test
    public void testTotalMonthRainfall() {
        assertEquals(40.0, stationFull.totalMonthRainfall(9, 2020), 0.1);
    }
}
