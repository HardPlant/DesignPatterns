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
        
    }
    public void complicated(){
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();
        GarageDoor garagedoor = new GarageDoor();
        Stereo stereo = new Stereo();

        LightOnCommand livingRoomOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomOff = new LightOffCommand(livingRoomLight);
        
        LightOnCommand kitchenOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenOff = new LightOffComand(kitchenLight);


    }
}
