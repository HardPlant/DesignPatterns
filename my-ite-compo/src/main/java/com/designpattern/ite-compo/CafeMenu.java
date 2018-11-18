package com.designpattern.itecompo;

import java.util.Hashtable;

public class CafeMenu{
    Hashtable menuItems = new Hashtable();

    public CafeMenu(){
        addItem("Cafe1","Desc",true,3.99);
        addItem("Cafe1","Desc",true,3.99);
        addItem("Cafe1","Desc",true,3.99);
        addItem("Cafe1","Desc",true,3.99);
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }
    public Hashtable getItems(){
        return menuItems;
    }
}