package il.ac.tau.cs.software1.predicate;

public class ByAuthor implements Predicate<Book> {
    private final char letter;

    public ByAuthor(char letter) {
        this.letter = Character.toLowerCase(letter);
    }

    @Override
    public boolean test(Book book) {
        return !book.getAuthor().isEmpty()
                && letter == Character.toLowerCase(book.getAuthor().charAt(0));
    }
}
