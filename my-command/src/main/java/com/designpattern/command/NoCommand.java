package com.designpattern.command;

import com.designpattern.command.Command;

public class NoCommand implements Command{
    public NoCommand(){}
    @Override
    public void execute() {
        
    }
    public void undo() {
        
    }
}