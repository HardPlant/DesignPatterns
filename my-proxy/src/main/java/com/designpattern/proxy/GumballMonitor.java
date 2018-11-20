package com.designpattern.proxy;

import java.rmi.RemoteException;

import com.designpattern.proxy.GumballMachineRemote;
import com.designpattern.state.GumballMachine;

public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report(){
        try{
        System.out.println("Gummball Machine: "+machine.getLocation());
        System.out.println("Current Location: "+machine.getCount()+" gumballs");
        System.out.println("Gummball State: " +machine.getState());
        } catch(RemoteException e){e.printStackTrace();}
    }
}