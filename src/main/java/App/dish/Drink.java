package App.dish;

public class Drink extends Dish {
    protected Boolean iceCubes;
    protected Boolean lemon;

    public Drink(Boolean iceCubes, Boolean lemon, String name, Double price) {
        super(price, name);
        this.iceCubes = iceCubes;
        this.lemon = lemon;
    }

    public void setIceCubes() {
        this.iceCubes = true;
    }

    public void setLemon() {
        this.lemon = true;
    }

    public Boolean getIceCubes() {
        return iceCubes;
    }


    public Boolean getLemon() {
        return lemon;
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
