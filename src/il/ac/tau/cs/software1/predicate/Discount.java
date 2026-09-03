package il.ac.tau.cs.software1.predicate;

public class Discount implements Action<Book> {
    private final double remainingFraction;

    public Discount(double percentage) {
        this.remainingFraction = percentage / 100.0;
    }

    @Override
    public void performAction(Book book) {
        book.setPrice(remainingFraction * book.getPrice());
    }
}
