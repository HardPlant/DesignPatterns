package com.designpattern.templatemethod;

public abstract class CaffeineBeverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    public void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("Pouring into cup");
    }
    boolean customerWantsCondiments(){
        return true;
    }
}