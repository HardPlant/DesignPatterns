package com.mycompany.observer;

import com.mycompany.observer.Observer;
import com.mycompany.observer.Subject;
import com.mycompany.observer.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("Current coditions: " 
            + temperature + " and " + " humidity ");
    }
}