package com.designpattern.compound;

import java.util.ArrayList;
import java.util.Iterator;

import com.designpattern.compound.Quackable;

public class Flock implements Quackable{
    ArrayList quackers = new ArrayList();
    public void add(Quackable quacker){
        quackers.add(quacker);
    }
    public void quack(){
        Iterator iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable quacker = (Quackable)iterator.next();
            quacker.quack();
        }
    }
}