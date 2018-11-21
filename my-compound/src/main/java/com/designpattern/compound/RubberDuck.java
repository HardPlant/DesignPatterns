package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class RubberDuck implements Quackable{
    Observable observable;

    public RubberDuck(){
        this.observable = new Observable(this);
    }
    public void quack() {
        System.out.println("Squeak");
    }
    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}