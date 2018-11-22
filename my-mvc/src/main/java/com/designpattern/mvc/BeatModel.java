package com.designpattern.mvc;

import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
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
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }
    public void notifyBeatObservers(){
        for(int i=0; i<beatObservers.size();i++){
            BeatObserver observer = (BeatObserver)beatObservers.get(i);
            observer.updateBeat();
        }
    }
    
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void notifyBPMObservers(){
        for(int i=0; i<bpmObservers.size(); i++){
            BPMObserver observer = (BPMObserver)bpmObservers.get(i);
            observer.updateBPM();
        }
    }
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if(i>=0){
            beatObservers.remove(i);
        }
    }
    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if(i>=0){
            bpmObservers.remove(i);
        }
    }
}