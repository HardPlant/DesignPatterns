package com.designpattern.proxy;

import com.designpattern.state.GumballMachine;

public class GumballMonitor{
    GumballMachine machine;
    public GumballMonitor(GumballMachine machine){
        this.machine = machine;
    }
    public void report(){
        System.out.println("Gummball Machine: "+machine.getLocation());
        System.out.println("Current: "+machine.getLocation());
        System.out.println("Gummball Machine: "+machine.getLocation());

    }
}