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
    }

    public void medium() {
        speed = MED;
    }

    public void low() {
        speed = LOW;
    }

    public void off() {
        speed = OFF;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }
}