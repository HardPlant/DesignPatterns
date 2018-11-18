package com.designpattern.templatemethod;

public abstract class CaffeineBaverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiements();
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