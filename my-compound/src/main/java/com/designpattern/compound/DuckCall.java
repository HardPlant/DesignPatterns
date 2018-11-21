package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class DuckCall implements Quackable{
    
    public void quack() {
        System.out.println("Kwak");
    }
    public void registerObserver(Observer observer) {
        
    }
    public void notifyObservers() {
        
    }
}