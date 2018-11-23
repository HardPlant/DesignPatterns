package com.designpattern.mvc;

public class HeartController implements ControllerInterface{
    HeartModelInterface model;
    DJView view;

    public HeartController(HeartModelInterface model){
        this.model = model;
        view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }
}