package com.designpattern.itecompo;

import java.awt.MenuItem;

public class DinerMenu implements Iterator{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("BLT1",
        "Desc",
        true
        ,2.99);
        addItem("BLT2",
        "Desc",
        true
        ,2.99);
        addItem("BLT3",
        "Desc",
        true
        ,2.99);
        addItem("BLT4",
        "Desc",
        true
        ,2.99);
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("menu is Full");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }
    /**
     * @return the menuItems
     */
    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}