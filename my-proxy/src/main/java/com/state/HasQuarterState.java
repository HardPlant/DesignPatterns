package com.designpattern.state;

import java.util.Random;

import com.designpattern.state.GumballMachine;

public class HasQuarterState implements State{
    Random randomWinner = new Random(System.currentTimeMillis());
    transient GumballMachine gumballMachine;
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
        int winner = randomWinner.nextInt(10);
        if((winner == 0) && (gumballMachine.getCount() > 1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }
    @Override
    public void dispense() {
        System.out.println("No gumball dispesed");
    }
}