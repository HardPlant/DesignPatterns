package com.designpattern.command;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        GarageDoor garagedoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garagedoor);

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
        
        ceiling();
    }
    public static void complicated(){
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();
        GarageDoor garagedoor = new GarageDoor();
        Stereo stereo = new Stereo();

        LightOnCommand livingRoomOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomOff = new LightOffCommand(livingRoomLight);
        
        LightOnCommand kitchenOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenOff = new LightOffCommand(kitchenLight);

        remote.setCommand(0, livingRoomOn, livingRoomOff);
        remote.setCommand(1, kitchenOn,kitchenOff);

        System.out.println(remote);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.undoButtonPushed();
        remote.onButtonWasPushed(1);
        remote.offButtonWasPushed(1);
        remote.undoButtonPushed();
    }
    public static void ceiling(){
        RemoteControl remote = new RemoteControl();
        CeilingFan ceilingFan = new CeilingFan("LivingRoom");

        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        remote.setCommand(0, ceilingFanHigh, ceilingFanOff);
        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        remote.undoButtonPushed();
    }
    public static void macro() {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();
        LightOnCommand livingRoomOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomOff = new LightOffCommand(livingRoomLight);
        
        LightOnCommand kitchenOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenOff = new LightOffCommand(kitchenLight);
        
        Command[] partyOn = {livingRoomOn, kitchenOn};
        Command[] partyOff = {livingRoomOff, kitchenOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remote.setCommand(0, partyOnMacro, partyOffMacro);
    }
    }
}
