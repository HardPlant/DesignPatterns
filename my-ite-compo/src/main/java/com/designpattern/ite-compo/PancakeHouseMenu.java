package com.designpattern.itecompo;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu extends Menu{
    ArrayList menuItems;
    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("K&B Pancake",
        "Description",
        true,
        2.99);
        addItem("K&B Pancake2",
        "Description",
        true,
        2.99);
        addItem("K&B Pancake2",
        "Description",
        true,
        2.99);
        addItem("K&B Pancake2",
        "Description",
        true,
        2.99);
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
    /**
     * @return the menuItems
     */
    public ArrayList getMenuItems() {
        return menuItems;
    }
    public Iterator createIterator(){
        return menuItems.iterator();
    }
}