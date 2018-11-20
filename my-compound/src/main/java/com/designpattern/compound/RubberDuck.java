package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class RubberDuck implements Quackable{
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}