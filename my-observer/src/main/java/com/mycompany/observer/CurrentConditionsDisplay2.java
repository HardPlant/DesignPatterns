package com.mycompany.observer;

import com.mycompany.observer.Observer;
import com.mycompany.observer.Subject;
import com.mycompany.observer.WeatherData;

import java.util.Observable;

import com.mycompany.observer.DisplayElement;

public class CurrentConditionsDisplay implements Observer{
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        weatherData.registerObserver(this);
    }

    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherData){

            display();
        }
    }

    public void display(){
        System.out.println("Current coditions: " 
            + temperature + " and " + humidity +" humidity ");
    }
}