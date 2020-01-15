package App.dish;

public class DessertMachine {
    private Double price;
    private String name;

    public DessertMachine setPrice(Double price) {
        this.price = price;
        return this;
    }

    public DessertMachine setName(String name) {
        this.name = name;
        return this;
    }

    public Dessert createDessert() {
        return new Dessert(price, name);
    }
}