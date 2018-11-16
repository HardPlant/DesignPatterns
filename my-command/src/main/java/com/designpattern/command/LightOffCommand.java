package com.designpattern.command;

import com.designpattern.command.Command;

public class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }
}