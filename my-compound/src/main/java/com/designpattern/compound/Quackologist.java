package com.designpattern.compound;

public class Quackologist implements Observer{
    public void update(QuackObservable duck){
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}