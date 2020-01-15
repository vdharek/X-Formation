package App.dao;

import App.dish.Drink;
import App.dish.DrinkMachine;

import java.util.LinkedList;
import java.util.List;

public class LoadDrinks {

    public List<Drink> load() {
        List<Drink> drinks = new LinkedList<>();
        drinks.add(new DrinkMachine().setName("Tea").setPrice(5.0).createDrink());
        drinks.add(new DrinkMachine().setName("Coffee").setPrice(5.0).createDrink());
        drinks.add(new DrinkMachine().setName("Cola").setPrice(4.0).createDrink());
        drinks.add(new DrinkMachine().setName("Nestea").setPrice(4.0).createDrink());
        return drinks;
    }
}
