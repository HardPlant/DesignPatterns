package com.designpattern.mvc;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DJView implements ActionListener, BeatObserver, BPMObserver{
    BeatModelInterface model;
    ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    BeatBar beatBar;
    JLabel bpmOutputLabel;
    
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;

    public DJView(ControllerInterface controller, BeatModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((BeatObserver)this);
        model.registerObserver((BPMObserver)this);
    }

    public void createView(){

    }
    public void updateBPM(){
        int bpm = model.getBPM();
        if(bpm==0){
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + model.getBPM());
        }
    }
    public void updateBeat(){
        beatBar.setValue(100);
    }

    public void createControls(){

    }
    public void enableStopMenuItem(){
        stopMenuItem.setEnabled(true);
    }
    public void disableStopMenuItem(){
        stopMenuItem.setEnabled(false);
    }
    public void enableStartMenuItem(){
        startMenuItem.setEnabled(true);
    }
    public void disableStartMenuItem(){
        startMenuItem.setEnabled(false);
    }
}