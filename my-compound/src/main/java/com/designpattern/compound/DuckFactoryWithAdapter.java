package com.designpattern.compound;

import com.designpattern.compound.Quackable;

public class DuckFactoryWithAdapter extends AbstractDuckFactory {
    public Quackable createMallardDuck() {
        return new CountDecorator(new MallardDuck());
    }

    public Quackable createRedheadDuck() {
        return new CountDecorator(new RedHeadDuck());
    }

    public Quackable createDuckCall() {
        return new CountDecorator(new DuckCall());
    }

    public Quackable createRubberDuck() {
        return new CountDecorator(new RubberDuck());
    }
}