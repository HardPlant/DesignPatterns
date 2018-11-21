package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class CountDecorator implements Quackable{
    Quackable quackable;
    static int numberOfQuacks = 0;
    
    public CountDecorator(Quackable quackable){
        this.quackable = quackable;
    }

    public void quack() {
        numberOfQuacks++;
        this.quackable.quack();
    }
    /**
     * @return the numberOfQuacks
     */
    public static int getCount() {
        return numberOfQuacks;
    }
    public void notifyObservers() {
        
    }
    public void registerObserver(Observer observer) {
        
    }
}