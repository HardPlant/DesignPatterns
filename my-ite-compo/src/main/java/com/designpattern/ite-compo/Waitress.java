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
        printMenu(pancakeIterator);
        printMenu(dinerIterator);
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