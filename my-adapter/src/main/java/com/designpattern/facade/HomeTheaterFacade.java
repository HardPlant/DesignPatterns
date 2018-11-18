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
}