package com.mycompany.app;

public class MallardDuck extends Duck{
    public MallardDuck(){
        this.quackBehavior = new Quack();
    }

    private class Quack implements QuackBehavior{
        public void quack() {
            System.out.println("Quack");
        }
    }
    private class MuteQuack implements QuackBehavior{
        public void quack() {
            System.out.println("Silence");
        }
    }

    private class FlyRocketPowered implements FlyBehavior{
        public void fly() {
            System.out.println("Rocket");
        }
    }
}