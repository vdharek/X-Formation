package App.dish;

public class Dessert extends Dish {
    public Dessert(Double price, String name) {
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
