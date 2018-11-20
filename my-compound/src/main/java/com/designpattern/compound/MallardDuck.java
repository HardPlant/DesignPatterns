package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class MallardDuck implements Quackable{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}