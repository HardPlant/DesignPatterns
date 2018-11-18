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
        popconPopper.on();
        popconPopper.pop();
        // lights.dim(10);
        // screen.down();
        // projector.wideScreenMode();
        amp.on();
        // amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        // dvd.on();
        // dvd.play(movie);
    }
}