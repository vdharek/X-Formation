package App.dao;

import App.cuisine.Cuisine;
import App.dish.Dessert;
import App.dish.DessertMachine;
import App.dish.Meal;
import App.dish.Chef;
import java.util.LinkedList;
import java.util.List;

public class LoadCuisines {
    public List<Cuisine> load() {
        List<Cuisine> cuisines = new LinkedList<>();
//        polish cuisine
        cuisines.add(loadPolish());
//        mecixan cuisine
        cuisines.add(loadMexican());
//        italian cuisine
        cuisines.add(loadItalian());
        return cuisines;
    }

    private Cuisine loadItalian() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Italian";
        meals.add(new Chef().setName("Panzenella").setPrice(12.0).createMeal());
        meals.add(new Chef().setName("Pasta Carbonara.").setPrice(19.0).createMeal());
        desserts.add(new DessertMachine().setName("Semifreddo").setPrice(5.0).createDessert());
        desserts.add(new DessertMachine().setName("Cassata").setPrice(6.0).createDessert());
        return new Cuisine(meals, desserts, name);
    }

    private Cuisine loadMexican() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Mexican";
        meals.add(new Chef().setName("Elote").setPrice(18.0).createMeal());
        meals.add(new Chef().setName("Enchiladas").setPrice(13.45).createMeal());
        desserts.add(new DessertMachine().setName("Churro Cheesecake").setPrice(5.69).createDessert());
        desserts.add(new DessertMachine().setName("Churro Ice Cream Sandwiches").setPrice(4.90).createDessert());
        return new Cuisine(meals, desserts, name);
    }

    private Cuisine loadPolish() {
        List<Meal> meals = new LinkedList<>();
        List<Dessert> desserts = new LinkedList<>();
        String name = "Polish";
        meals.add(new Chef().setName("Pierogi").setPrice(15.0).createMeal());
        meals.add(new Chef().setName("Rosół").setPrice(16.0).createMeal());
        desserts.add(new DessertMachine().setName("Chałka").setPrice(6.0).createDessert());
        desserts.add(new DessertMachine().setName("Drożdzówka").setPrice(7.0).createDessert());
        return new Cuisine(meals, desserts, name);
    }
}
