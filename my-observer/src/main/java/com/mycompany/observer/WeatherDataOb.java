package com.mycompany.observer;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherDataOb extends Observable {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    /**
     * @return the humidity
     */
    public float getHumidity() {
        return humidity;
    }
    /**
     * @return the pressure
     */
    public float getPressure() {
        return pressure;
    }
    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }
}