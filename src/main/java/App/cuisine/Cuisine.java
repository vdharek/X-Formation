package App.cuisine;

import App.dish.Dessert;
import App.dish.Meal;

import java.util.List;

public class Cuisine {
    private final List<Meal> meals;
    private final List<Dessert> desserts;
    private final String name;


    public Cuisine(List<Meal> meals, List<Dessert> desserts, String name) {
        this.meals = meals;
        this.desserts = desserts;
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public String getName() {
        return name;
    }
}
