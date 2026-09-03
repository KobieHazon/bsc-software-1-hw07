package il.ac.tau.cs.software1.predicate;

public class Discount implements Action<Book> {
	
	private double percentage;
	public Discount(double percentage) { // Q3
		this.percentage = percentage/100;
	}
	
	
	@Override
	public void performAction(Book book) { // Q3
		book.setPrice(this.percentage*book.getPrice());
	}
	
}
