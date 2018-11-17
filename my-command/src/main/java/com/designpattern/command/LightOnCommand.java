package com.designpattern.command;

import com.designpattern.command.Command;

public class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo() {
        light.off();
    }
}