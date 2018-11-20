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
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }
    public void dispense(){
        state.dispense();
    }
    void setState(State state){
        this.state = state;
    }
    void releaseBall(){
        System.out.println("A gumball!");
        if(count !=0){
            count = count - 1;
        }
    }
    /**
     * @return the hasQuarterState
     */
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    /**
     * @return the noQuarterState
     */
    public State getNoQuarterState() {
        return noQuarterState;
    }
    /**
     * @return the soldOutState
     */
    public State getSoldOutState() {
        return soldOutState;
    }
    /**
     * @return the soldState
     */
    public State getSoldState() {
        return soldState;
    }
    /**
     * @return the state
     */
    public State getState() {
        return state;
    }
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
}