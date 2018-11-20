package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class DuckCall implements Quackable{
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}