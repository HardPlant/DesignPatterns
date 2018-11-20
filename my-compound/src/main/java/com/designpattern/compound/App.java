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
        AbstractDuckFactory duckFactory = new DuckFactoryWithAdapter();
        app.simulate(duckFactory);
    }
    void simulate(AbstractDuckFactory factory){
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(gooseDuck);

        System.out.println("\nDuck Simulator");

        flock.quack();

        System.out.println("Quacks: " + CountDecorator.getCount());
    }
}
