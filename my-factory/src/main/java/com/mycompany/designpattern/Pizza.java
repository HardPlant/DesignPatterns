package com.mycompany.designpattern;

public abstract class Pizza{
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();
    
    public void prepare(){
        {
            System.out.println(name + "준비");
        }
    }
    public void bake(){
        System.out.println("구워라");
    }
    public void cut(){
        System.out.println("잘라라");
    }
    public void box(){
        System.out.println("포장해라");
    }
    public String getName(){
        return name;
    }
}