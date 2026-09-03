package il.ac.tau.cs.software1.predicate;

import java.util.List;

public class Store<T extends Product> {
    private final List<T> inventory;

    public Store(List<T> inventory) {
        this.inventory = inventory;
    }

    public List<T> getInventory() {
        return inventory;
    }

    public String getInventoryDescription() {
        StringBuilder inventoryDescription = new StringBuilder();
        for (T product : inventory) {
            inventoryDescription.append(product.getDescription());
        }
        return inventoryDescription.toString();
    }

    public void transform(Predicate<T> predicate, Action<T> action) {
        for (T product : inventory) {
            if (predicate.test(product)) {
                action.performAction(product);
            }
        }
    }
}
