package il.ac.tau.cs.software1.predicate;

public class ByPrice implements Predicate<SmartPhone> {
    private final double maxPrice;

    public ByPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean test(SmartPhone phone) {
        return phone.getPrice() <= maxPrice;
    }
}
