package com.designpattern.command;

import com.designpattern.command.GarageDoor;

public class GarageDoorOpenCommand implements Command{
    private GarageDoor door;
    public GarageDoorOpenCommand(GarageDoor door){
        this.door = door;
    }
    @Override
    public void execute() {
        door.up();
    }
}