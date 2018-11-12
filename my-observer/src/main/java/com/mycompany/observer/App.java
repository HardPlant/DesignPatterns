package com.mycompany.observer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(45, 12, 27.4f);
        weatherData.setMeasurements(28, 51, 34.4f);
        weatherData.setMeasurements(37, 56, 30.4f);
    }
}
