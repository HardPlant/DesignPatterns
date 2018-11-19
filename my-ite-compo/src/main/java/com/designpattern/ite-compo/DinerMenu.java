package com.designpattern.itecompo;

import java.util.Iterator;

public class DinerMenu extends Menu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        // addItem("BLT1", "Desc", true, 2.99);
        // addItem("BLT2", "Desc", true, 2.99);
        // addItem("BLT3", "Desc", true, 2.99);
        // addItem("BLT4", "Desc", true, 2.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("menu is Full");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}