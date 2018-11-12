package com.mycompany.app;

public abstract class Duck{
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public Duck(){

    }
    public void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

    
/* TODO : extract below things
 */
    private interface QuackBehavior{
        public void quack();
    }
    private interface FlyBehavior{
        public void fly();
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
}
