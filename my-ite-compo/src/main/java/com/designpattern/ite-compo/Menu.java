package com.designpattern.itecompo;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent{
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;
    public Menu(){
        
    }
    public Menu(String name, String description){
        this.name=name;
        this.description=description;
    }
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChild(int i){
        return (MenuComponent)menuComponents.get(i);
    }
    public void print(){
        System.out.print("\n"+getName());
        System.out.println(", " + getDescription());
        System.out.println("----------------------");

        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}