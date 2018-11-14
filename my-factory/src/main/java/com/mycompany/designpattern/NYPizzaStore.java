package com.mycompany.designpattern;

import com.mycompany.designpattern.PizzaStore;

public class NYPizzaStore extends PizzaStore{
    Pizza createPizza(String item){
        if (item.equals("cheese")){
            return new NYStyleCheesePizza();
        } //...
        else return null;
    }
}