package com.mycompany.app;

public class MallardDuck extends Duck{
    public MallardDuck(){
        this.flyBehavior = new QuackBehavior();
    }
}