package com.designpattern.adapter;

import com.designpattern.adapter.Turkey;

public class WildTurkey implements Turkey{
    @Override
    public void qubble() {
        System.out.println("Gobble");
        
    }
    @Override
    public void fly() {
        System.out.println("Fly!");
        
    }
}