package com.mycompany.designpattern;

import com.mycompany.designpattern.Pizza;
import com.mycompany.designpattern.SimplePizzaFactory;

public abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
    abstract createPizza(String type);
}