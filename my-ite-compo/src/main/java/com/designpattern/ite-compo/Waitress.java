package com.designpattern.itecompo;

import java.util.Iterator;

public class Waitress{
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
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
    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\nVEGETRAIAN MENU\n----");
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try{
                if(menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            } catch(UnsupportedOperationException e){}
        }
    }
    public void isItemVegetarian(){}
}