package App.dish;

public class Chef {
    private String name;
    private Double price;

    public Chef setName(String name) {
        this.name = name;
        return this;
    }

    public Chef setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Meal createMeal() {
        return new Meal(name, price);
    }

}