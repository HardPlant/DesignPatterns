package com.mycompany.observer;

import com.mycompany.observer.Subject;
import com.mycompany.observer.WeatherDataOb;

import java.util.Observable;
import java.util.Observer;

import com.mycompany.observer.DisplayElement;

public class CurrentConditionsDisplay2 implements Observer{
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay2(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherDataOb){
            WeatherDataOb weatherData = (WeatherDataOb)obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display(){
        System.out.println("Current coditions: " 
            + temperature + " and " + humidity +" humidity ");
    }
}