package com.designpattern.itecompo;

public class MenuItem extends MenuComponent{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name= name;
        this.description=description;
        this.vegetarian=vegetarian;
        this.price=price;
    }

    public void print(){
        System.out.println("    " + getName());
        if(isVegetarian()){
            System.out.print("(v)");
        }
        System.out.prinln(", " + getPrice());
        System.out.prinln("     --" + getDescription());

    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @return the vegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * @param vegetarian the vegetarian to set
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}