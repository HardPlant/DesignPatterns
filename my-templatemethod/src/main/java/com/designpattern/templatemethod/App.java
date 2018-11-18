package com.designpattern.templatemethod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Coffee coffee = new Coffee();
        System.out.println("Making Coffee...");
        coffee.prepareRecipe();
    }
}
