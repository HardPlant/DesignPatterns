package com.designpattern.compound;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.simulate();
    }
    void simulate(){
        Quackable mallardDuck = new CountDecorator(new MallardDuck());
        Quackable redheadDuck = new CountDecorator(new RedHeadDuck());
        Quackable duckCall = new CountDecorator(new DuckCall());
        Quackable rubberDuck = new CountDecorator(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("Quacks: " + CountDecorator.getCount());
    }
    void simulate(Quackable duck){
        duck.quack();
    }
}
