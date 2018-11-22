package com.designpattern.mvc;

import javax.swing.JProgressBar;

public class BeatBar extends JProgressBar{
    public BeatBar(){
        super();
        this.setMinimum(0);
        this.setMaximum(100);
    }
}