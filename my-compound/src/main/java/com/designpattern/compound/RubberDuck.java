package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class RedHeadDuck implements Quackable{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}