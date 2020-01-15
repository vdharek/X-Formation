package App;

import App.cuisine.Cuisine;
import App.dao.LoadCuisines;
import App.dao.LoadDrinks;
import App.dish.Dish;
import App.dish.Drink;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MainApp{

    private final static LoadCuisines DATA_CUISINES = new LoadCuisines();
    private final static LoadDrinks DATA_DRINK = new LoadDrinks();

    public static void main(String[] args){

        Boolean finished = false;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(!finished){

                System.out.println("What would you like to have ");
                System.out.println("1 : Lunch");
                System.out.println("2 : Drink");
                String orderType = br.readLine();
                switch (orderType){
                    case "1":
                        lunch(br);
                        break;
                    case "2":
                        drink(br);
                        break;
                     default:
                         finished = true;
                         break;
                }
            }
        }catch(IOException e){
            System.out.println("ERROR!");
        }
    }

    public static void lunch(BufferedReader br) throws IOException{
        List<Cuisine> cuisines = DATA_CUISINES.load();
        List<Dish> order = new LinkedList<Dish>();

        System.out.println("Select Cuisine : ");

        cuisines.forEach(cuisine -> System.out.printf("%d: %s%n", cuisines.indexOf(cuisine)
        , cuisine.getName()));

        String selectedCuisine = br.readLine();
        try{
            if(Integer.parseInt(selectedCuisine) >= cuisines.size())
                System.out.println("Please, Enter Correct Number");
            else{
                Boolean finished = false;
                String input;
                Cuisine cuisine = cuisines.get(Integer.parseInt(selectedCuisine));

                while(!finished){
                    System.out.println("Select Main Course");
                    cuisine.getMeals().forEach(meal -> System.
                            out.printf("%d: %s %s$%n", cuisine.getMeals().indexOf(meal), meal.getName(),
                            meal.getPrice()));
                    System.out.println("Press 'E' ro exit");
                    input = br.readLine();
                    if(input.equals("e"))
                        finished = true;
                    else{
                        try{
                            if(Integer.parseInt(input) >= cuisine.getMeals().size())
                                System.out.println("Input correct number");
                            else
                                order.add(cuisine.getMeals().get(Integer.parseInt(input)));
                        }catch(NumberFormatException e){
                            System.out.println("Please, Enter Correct Number");
                        }
                    }
                }
                finished = false;

                while(!finished){
                    System.out.println("Select Dessert");
                    cuisine.getDesserts().forEach(dessert -> System.
                            out.printf("%d: %s %s$%n", cuisine.getDesserts().indexOf(dessert), dessert.getName(),
                            dessert.getPrice()));
                    System.out.println("Press 'E' ro exit");
                    input = br.readLine();
                    if(input.equals("e"))
                        finished = true;
                    else{
                        try{
                            if(Integer.parseInt(input) >= cuisine.getDesserts().size())
                                System.out.println("Input correct number");
                            else
                                order.add(cuisine.getDesserts().get(Integer.parseInt(input)));
                        }catch(NumberFormatException e){
                            System.out.println("Please, Enter Correct Number");
                        }
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Please, Enter Correct Number");
        }
        System.out.println("Dishes Ordered : ");
        System.out.println("************************************************************************************");
        order.forEach(dish -> System.out.println(dish.getName()));
        final Double[] price = {0.0};
        order.forEach(dish -> price[0] += dish.getPrice());
        System.out.println("Total price : "+price[0]);
    }

    private static void drink(BufferedReader br) throws IOException{
        List<Drink> drinks = DATA_DRINK.load();
        List<Drink> order = new LinkedList<>();

        Boolean finished = false;
        while(!finished){
            System.out.println("Please, Select Drink : ");
            System.out.println("Drinks");
            drinks.forEach(drink -> System.out.printf("%d: %s %s$%n", drinks.indexOf(drink)
            , drink.getName(),drink.getPrice()));
            System.out.println("Press 'E' to exit");
            String input = br.readLine();
            if(input.equals("e"))
                finished = true;
            else{
                try{
                    if(Integer.parseInt(input) >= drinks.size())
                        System.out.println("Input Right Number");
                    else{
                        Drink drink = drinks.get(Integer.parseInt(input));
                        System.out.println("Press 1 if you want ice cubs, if not please type anything");
                        String iceCubs = br.readLine();
                        if(iceCubs.equals("1"))
                            drink.getIceCubes();
                        System.out.println("Press 1 if you want lemon, , if not please type anything");
                        String lemon = br.readLine();
                        if(lemon.equals("1"))
                            drink.setLemon();
                        order.add(drink);
                    }
                }catch (NumberFormatException e){
                    System.out.println("Please, Enter Correct Number");
                }
            }
        }
        System.out.println("Drinks orders : ");
        order.forEach(drink -> {
            String addons = "";
            if(drink.getIceCubes())
                addons += "+ice_cubs";
            if(drink.getLemon())
                addons += "+lemon";
            System.out.printf("%s%s%n", drink.getName(), addons);
        });
        final Double[] price = {0.0};
        order.forEach(drink -> price[0] += drink.getPrice());
        System.out.println("Total Price : "+price[0]);
    }

}
