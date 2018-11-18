package com.designpattern.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> iterator = array.iterator();
        IteratorEnumeration enumer = new IteratorEnumeration(iterator);
        System.out.println(enumer.nextElement());
        System.out.println(enumer.nextElement());
        System.out.println(enumer.nextElement());

    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

}
