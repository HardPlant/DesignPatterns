package com.designpattern.itecompo;

public class DinerMenuIterator implements Iterator{
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items){
        this.items=items;
    }
    public Object next(){
        return menuItems[position++];
    }
    public boolean hasNext(){
        if(position >= menuItems.length || items[position] == null){
            return false;
        } else {
            return true;
    }
}