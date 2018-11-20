package com.designpattern.state;

import com.designpattern.state.GumballMachine;

public class HasQuarterState implements State{
    GumballMachine gumballMachine;
    public HasQuarterState(GumballMachine machine){
        this.gumballMachine = machine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");

    }
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(getSoldState());
    }
    @Override
    public void dispense() {
        System.out.println("No gumball dispesed");
    }
}