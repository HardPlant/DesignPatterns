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
            System.out.println("You can't insert another quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't inserted a quarter, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
        }
    }
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
        } else if (state == SOLD) {
            System.out.println("Sorry, tou already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }
    public void turnCrank(){
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball!");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned but there's no gumballs");
        } else if (state == NO_QUARTER) {
        } else if (state == HAS_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }
    public void dispense(){
        if (state == SOLD) {
            System.out.println("A gumball come rolling out the slot");
            count = count -1;
            if(count == 0){
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispesed");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispesed");
        }
    }
}