package com.designpattern.command;

import com.designpattern.command.Command;

public class RemoteControl{
    command[] onCommands;
    command[] offCommands;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for(int i=0;i<7;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    public void setCommand(){

    }
    public void onButtonWasPushed(){

    }
    public void offButtonWasPushed(){

    }
}