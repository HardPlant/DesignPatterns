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
        
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardDuck1 = factory.createMallardDuck();
        Quackable mallardDuck2 = factory.createMallardDuck();
        Quackable mallardDuck3 = factory.createMallardDuck();
        Quackable mallardDuck4 = factory.createMallardDuck();
        
        flockOfMallards.add(mallardDuck1);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);
        System.out.println("\nDuck Simulator");
        
        simulate(flockOfDucks);
        
        System.out.println("\nHello Mallard");
        simulate(flockOfMallards);

        System.out.println("Quacks: " + CountDecorator.getCount());
    
        
    }
    void simulate(Quackable duck){
        duck.quack();
    }
}
