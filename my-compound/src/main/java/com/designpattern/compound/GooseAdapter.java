package com.designpattern.compound;

public class GooseAdapter implements Quackable{
    Goose goose;
    Observable observable;
    public GooseAdapter(Goose goose){
        this.goose = goose;
        this.observable = observable;
    }

    public void quack() {
        goose.honk();
    }
    public void notifyObservers(){

    }
    public void registerObserver(Observer observer){

    }
}