package com.mycompany.observer;

import com.mycompany.observer.Observer;
import com.mycompany.observer.Subject;

import java.util.Observable;

import com.mycompany.observer.DisplayElement;

public class CurrentConditionsDisplay implements Observer{
    Observable observable;
    private float temperature;
    private float humidity;

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
            + temperature + " and " + humidity +" humidity ");
    }
}