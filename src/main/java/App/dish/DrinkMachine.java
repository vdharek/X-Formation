package App.dish;

public class DrinkMachine {
    private Boolean iceCubes = false;
    private Boolean lemon = false;
    private String name;
    private Double price;

    public DrinkMachine setIceCubes(Boolean iceCubes) {
        this.iceCubes = iceCubes;
        return this;
    }

    public DrinkMachine setLemon(Boolean lemon) {
        this.lemon = lemon;
        return this;
    }

    public DrinkMachine setName(String name) {
        this.name = name;
        return this;
    }

    public DrinkMachine setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Drink createDrink() {
        return new Drink(iceCubes, lemon, name, price);
    }
}