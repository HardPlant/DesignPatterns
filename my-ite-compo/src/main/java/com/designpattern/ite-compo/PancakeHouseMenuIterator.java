package com.designpattern.itecompo;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements com.designpattern.itecompo.Iterator{
    ArrayList items;

    public PancakeHouseMenuIterator(ArrayList items){
        this.items = items;
    }
    public boolean hasNext(){
        return iterator.hasNext();
    }
    public Object next(){
        return iterator.next();
    }
}