package com.designpattern.itecompo;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.menuItems = items;
    }

    public Object next() {
        return menuItems[position++];
    }

    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position] == null) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void remove() {
        if(position <= 0){
            throw new IllegalStateException("you can't remove an item until you've done at leat one next()");
        }
        if(list[position-1]!=null){
            for(int i=position-1; i< (list.length-1);i++){
                list[i]=list[i+1];
            }
            list[list.length-1] = null;
        }
    }
    
}