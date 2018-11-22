package com.designpattern.mvc;

public class BeatController implements ControllerInterface{
    BeatModelInterface model;
    DJView view;

    public BeatController(BeatModelInterface model){
        this.model = model;
        view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }
    public void stop() {
        model.off();
        view.enableStartMenuItem();
        view.disableStopMenuItem();
    }
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm+1);
    }
    
    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm-1);
    }

}