package com.designpattern.proxy;

import com.designpattern.state.GumballMachine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GumballMachine machine = new GumballMachine(5, "nowhere");
        GumballMonitor monitor = new GumballMonitor(machine);
        monitor.report();
    }
}
