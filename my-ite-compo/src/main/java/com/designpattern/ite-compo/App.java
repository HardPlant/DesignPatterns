package com.designpattern.itecompo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT", ":)");

        MenuComponent allMenus = new Menu("ALL MENUS", "All combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem(
            "Paster",
            "Spaghetti",
            true,
            3.89
        ));
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
            "ApplePie",
            "Apple",
            true,
            3.89
        ));

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
        waitress.printVegetarianMenu();
        

    }
}
