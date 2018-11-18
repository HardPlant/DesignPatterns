package com.designpattern.adapter;

import com.designpattern.adapter.Amplifier;
import com.designpattern.adapter.PopconPopper;

public class HomeTheaterFacade{
    Amplifier amplifier;
    PopconPopper popconPopper;

    public HomeTheaterFacade(Amplifier amplifier
        , PopconPopper popconPopper){
            this.amplifier = amplifier;
            this.popconPopper = popconPopper;
    }
    public void watchMovie(){
        System.out.println("준비..");
        // popconPopper.on();
        // popconPopper.pop();
        // lights.dim(10);
        // screen.down();
        //projector.on();
        // projector.wideScreenMode();
        // amp.on();
        // // amp.setDvd(dvd);
        // amp.setSurroundSound();
        // amp.setVolume(5);
        // dvd.on();
        // dvd.play(movie);
    }
    public void endMovie(){
        System.out.println("준비..");
        // popconPopper.off();
        // // lights.dim(10);
        // // screen.up();
        // amp.off();
        // projector.off();
        // dvd.stop();
        // dvd.eject();
        // dvd.off();
        
    }
}