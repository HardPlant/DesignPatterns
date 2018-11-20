package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class CountDecorator implements Quackable{
    Quackable quackable;
    int numberOfQuacks;
    
    public CountDecorator(Quackable quackable){
        this.quackable = quackable;
        numberOfQuacks = 0;
    }

    @Override
    public void quack() {
        numberOfQuacks++;
        this.quackable.quack();
    }
    /**
     * @return the numberOfQuacks
     */
    public int getCount() {
        return numberOfQuacks;
    }
}