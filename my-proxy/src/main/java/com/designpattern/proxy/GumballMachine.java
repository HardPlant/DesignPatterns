package com.designpattern.state;

public class GumballMachine {
    // State soldOutState;
    // State noQuarterState;
    // State hasQuarterState;
    // State soldState;
    // State winnerState;

    // State state = soldOutState;
    int count = 0;
    String location;

    public GumballMachine(int count) {
        // soldOutState = new SoldOutState(this);
        // noQuarterState = new NoQuarterState(this);
        // hasQuarterState = new HasQuarterState(this);
        // soldState = new SoldState(this);
        // winnerState = new WinnerState(this);
        // this.count = count;
        // if (count > 0) {
        //     state = noQuarterState;
        // }
        this.location = location;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    // public void insertQuarter() {
    //     state.insertQuarter();
    // }
    // public void ejectQuarter() {
    //     state.ejectQuarter();
    // }
    // public void turnCrank(){
    //     state.turnCrank();
    //     state.dispense();
    // }
    // public void dispense(){
    //     state.dispense();
    // }
    // void setState(State state){
    //     this.state = state;
    // }
    // void releaseBall(){
    //     System.out.println("A gumball!");
    //     if(count !=0){
    //         count = count - 1;
    //     }
    // }
    // void refill(int count){
    //     if(getState() == this.getSoldOutState()){
    //         this.count += count;
    //         this.state = this.getNoQuarterState();
    //     }
    // }
    // /**
    //  * @return the hasQuarterState
    //  */
    // public State getHasQuarterState() {
    //     return hasQuarterState;
    // }
    // /**
    //  * @return the noQuarterState
    //  */
    // public State getNoQuarterState() {
    //     return noQuarterState;
    // }
    // /**
    //  * @return the soldOutState
    //  */
    // public State getSoldOutState() {
    //     return soldOutState;
    // }
    // /**
    //  * @return the soldState
    //  */
    // public State getSoldState() {
    //     return soldState;
    // }
    // /**
    //  * @return the winnerState
    //  */
    // public State getWinnerState() {
    //     return winnerState;
    // }
    // /**
    //  * @return the state
    //  */
    // public State getState() {
    //     return state;
    // }
    // /**
    //  * @return the count
    //  */
    // public int getCount() {
    //     return count;
//     }
}