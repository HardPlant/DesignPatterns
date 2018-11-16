package com.designpattern.singleton;

public class ChocolateBoiler{
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler chocolateBoiler;

    private ChocolateBoiler(){
        chocolateBoiler.empty = true;
        chocolateBoiler.boiled = false;
    }
    public static ChocolateBoiler getInstance(){
        if(chocolateBoiler == null){
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(!isEmpty() && !isBoiled()){
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            boiled = true;
        }
    }
    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty;
    }
    /**
     * @return the boiled
     */
    public boolean isBoiled() {
        return boiled;
    }
}

