package com.designpattern.adapter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MallardDuck duck = new MallardDuck();
        
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        
        System.out.println("Turkey says..");
        turkey.qubble();
        turkey.fly();
        System.out.println("Duck says..");
        testDuck(duck);
        
        System.out.println("TurkeyAdapter says..");
        testDuck(turkeyAdapter);
    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

}
