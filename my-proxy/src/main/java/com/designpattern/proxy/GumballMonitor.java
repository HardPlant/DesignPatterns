package com.designpattern.proxy;

import com.designpattern.state.GumballMachine;

public class GumballMonitor{
    GumballMachine machine;
    public GumballMonitor(GumballMachine machine){
        this.machine = machine;
    }
    public void report(){
        System.out.println("Gummball Machine: "+machine.getLocation());
        System.out.println("Current Location: "+machine.getCount()+" gumballs");
        System.out.println("Gummball State: " +machine.getState());
    }
}