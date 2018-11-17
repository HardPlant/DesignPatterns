package com.designpattern.command;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MED = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("["+location+"]"+"High!");
    }
    
    public void medium() {
        speed = MED;
        System.out.println("["+location+"]"+"Mid!");
    }
    
    public void low() {
        speed = LOW;
        System.out.println("["+location+"]"+"Low!");
    }
    
    public void off() {
        speed = OFF;
        System.out.println("["+location+"]"+"Off!");
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }
}