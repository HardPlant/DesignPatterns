package com.mycompany.app;

public abstract class Duck{
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public Duck(){

    }
    private void performFly(){
        flyBehavior.fly();
    }
}

public interface QuackBehavior{
    public void quack();
}
public interface FlyBehavior{
    public void fly();
}