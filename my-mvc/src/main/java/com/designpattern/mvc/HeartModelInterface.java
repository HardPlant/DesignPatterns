package com.designpattern.mvc;

public interface HeartModelInterface{
    public int getHeartRate();
    public void registerBeatObserver();
    public void registerBPMObserver();
}