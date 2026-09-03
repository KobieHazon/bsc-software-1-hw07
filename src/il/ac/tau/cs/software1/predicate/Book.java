package il.ac.tau.cs.software1.predicate;

import java.util.Objects;

public class Book implements Product {
    private double price;
    private final String name;
    private final String author;

    public Book(String name, double price, String author) {
        this.name = Objects.requireNonNull(name, "name");
        this.author = Objects.requireNonNull(author, "author");
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

    public String getAuthor() {
        return author;
    }
}
