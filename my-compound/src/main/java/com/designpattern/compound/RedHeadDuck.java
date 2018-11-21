package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class RedHeadDuck implements Quackable{
    Observable observable;
    public RedHeadDuck(){
        this.observable = new Observable(this);
    }
    public void quack() {
        System.out.println("Quack");
    }
    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}