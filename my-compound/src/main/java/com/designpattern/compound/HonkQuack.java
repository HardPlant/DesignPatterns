package com.designpattern.compound;

public class HonkQuack implements Quackable{
    Goose goose;
    public HonkQuack(Goose goose){
        this.goose = goose;
    }
    @Override
    public void quack() {
        goose.honk();
    }
}