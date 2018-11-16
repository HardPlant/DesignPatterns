package com.designpattern.command;

import com.designpattern.command.Command;

class StereoOnWithCDCommand implements Command{
    private Stereo stereo;
    public StereoOnWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume();
    }
}