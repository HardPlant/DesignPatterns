package com.designpattern.mvc;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

import com.designpattern.mvc.BeatModelInterface;

public class BeatModel implements BeatModelInterface, MetaEventListener{
    Sequencer sequencer;
    ArrayList beatObservers = new ArrayList();
    ArrayList bpmObservers = new ArrayList();
    int bpm = 90;
    Sequence sequence;
    Track track;

    public void initialize(){
        setUpMidi();
        buildTrackAndStart();
    }
    public void on(){
        sequencer.start();
        setBPM(90);
    }
    public void off(){
        setBPM(0);
        sequencer.stop();
    }

    public void setBPM(int bpm){
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }
    public int getBPM(){
        return bpm;
    }
    void beatEvent(){
        notifyBeatObservers();
    }
}