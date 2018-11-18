package com.designpattern.itecompo;

public class Waitress{
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dineMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dineMenu;
    }

    public void printMenu(){
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();

    }
    public void printBreakfastMenu(){}
    public void printLunchMenu(){}
    public void printVegetraianMenu(){}
    public void isItemVegetarian(){}
}