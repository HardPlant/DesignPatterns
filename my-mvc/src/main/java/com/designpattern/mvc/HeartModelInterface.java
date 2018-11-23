package com.designpattern.mvc;

public interface HeartModelInterface{
    public int getHeartRate();
    public void registerBeatObserver(BeatObserver o);
    public void registerBPMObserver(BPMObserver o);
}