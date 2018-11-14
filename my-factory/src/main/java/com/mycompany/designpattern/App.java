package com.mycompany.designpattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PizzaStore nyStore = new NYPizzaStore();
        
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("피자는 : "+pizza.getName());
        
    }
}
