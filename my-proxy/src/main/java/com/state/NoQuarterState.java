package com.designpattern.state;

import com.designpattern.state.GumballMachine;

public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine machine){
        this.gumballMachine = machine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quater");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }
    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    }
    @Override
    public void dispense() {
        
        System.out.println("You need to pay first");
    }
}