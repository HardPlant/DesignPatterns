package com.designpattern.adapter;

import com.designpattern.adapter.Duck;
import com.designpattern.adapter.Turkey;

public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.qubble();
    }
    @Override
    public void fly() {
        
    }
}