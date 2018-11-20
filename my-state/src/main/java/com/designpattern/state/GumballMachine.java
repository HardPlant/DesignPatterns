package com.designpattern.state;

public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
        } else if (state == SOLD_OUT) {
        } else if (state == SOLD) {
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
        }
    }
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
        } else if (state == SOLD) {
        } else if (state == SOLD_OUT) {
        }
    }
    public void turnCrank(){
        if (state == SOLD) {
        } else if (state == SOLD_OUT) {
        } else if (state == NO_QUARTER) {
        } else if (state == HAS_QUARTER) {
        }
    }
    public void dispense(){
        if (state == SOLD) {
            }
        } else if (state == NO_QUARTER) {
        } else if (state == HAS_QUARTER) {
        } else if (state == SOLD_OUT) {
        }
    }
}