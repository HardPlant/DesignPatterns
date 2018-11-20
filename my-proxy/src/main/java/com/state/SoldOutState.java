package com.designpattern.state;

import com.designpattern.state.GumballMachine;

public class SoldOutState implements State{
    GumballMachine gumballMachine;
    public SoldOutState(GumballMachine machine){
        this.gumballMachine = machine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't inserted a quarter, the machine is sold out");

    }
    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");

    }
    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no gumballs");
    }
    @Override
    public void dispense() {
        System.out.println("No gumball dispesed");
    }
}