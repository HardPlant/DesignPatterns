package com.designpattern.itecompo;

public class Waitress{
    PancakeHouseMenu panckaeHouseMenu;
    DinerMenu dinerMenu;
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dineMenu){
        this.panckaeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dineMenu;
    }

    public void printMenu(){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        ArrayList breakfaseItems = pancakeHouseMenu.getMenuItems();
    
        DinerMenu dineMenu = new DinerMenu();
        MenuItem[] lunchItems = dinerMenu.getMenuItems();
    
        for(int i=0;i<breakfastItems.size();i++){
            Menuitem menuItem = (MenuItem)breakfastItems.get(i);
            //...print getName(), getPrice(), getDesc()
        }
        for(int i=0;i<lunchItems.length;i++){
            Menuitem menuItem = (MenuItem)lunchItems.get(i);
            //...print getName(), getPrice(), getDesc()
        }
    }
    public void printBreakfastMenu(){}
    public void printLunchMenu(){}
    public void printVegetraianMenu(){}
    public void isItemVegetarian(){}
}