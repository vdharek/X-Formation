package App.dish;

public class Meal extends Dish {

    public Meal(String name, Double price) {
        super(price, name);
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
