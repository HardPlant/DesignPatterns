package com.designpattern.itecompo;

import java.util.Iterator;

public class Waitress{
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;
    public Waitress(Menu pancakeHouseMenu, Menu dineMenu, Menu cafeMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dineMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu(){
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        Iterator cafeIterator = cafeMenu.createIterator();
        printMenu(pancakeIterator);
        printMenu(dinerIterator);
        printMenu(cafeIterator);
    }
    private void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.print(menuItem.getName()+", ");
            System.out.print(menuItem.getPrice()+", ");
            System.out.println(menuItem.getDescription());
        }
    }
    public void printBreakfastMenu(){}
    public void printLunchMenu(){}
    public void printVegetraianMenu(){}
    public void isItemVegetarian(){}
}