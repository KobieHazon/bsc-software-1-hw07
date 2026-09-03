package il.ac.tau.cs.software1.predicate;

import java.util.Objects;

public class SmartPhone implements Product {
    private double price;
    private final String name;
    private int version;

    public SmartPhone(String name, double price, int version) {
        this.name = Objects.requireNonNull(name, "name");
        this.version = version;
        setPrice(price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            price = newPrice;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void upgrade() {
        version += 1;
    }
}
