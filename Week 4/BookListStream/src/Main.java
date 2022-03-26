import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 986, LocalDate.of(1954, 1, 1)));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, LocalDate.of(1937, 1, 1)));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 101, LocalDate.of(1951, 1, 1)));
        books.add(new Book("The Grapes of Wrath", "John Steinbeck", 72, LocalDate.of(1939, 1, 1)));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 58, LocalDate.of(1925, 1, 1)));
        books.add(new Book("The Scarlet Letter", "Nathaniel Hawthorne", 754, LocalDate.of(1850, 1, 1)));
        books.add(new Book("The Hobbit 2", "J.R.R. Tolkien", 561, LocalDate.of(1916, 1, 1)));
        books.add(new Book("The Hobbit 3", "J.R.R. Tolkien", 875, LocalDate.of(1938, 1, 1)));
        books.add(new Book("The Hobbit 4", "J.R.R. Tolkien", 875, LocalDate.of(1939, 1, 1)));
        books.add(new Book("The Hobbit 5", "J.R.R. Tolkien", 875, LocalDate.of(1940, 1, 1)));

        Map<String, String> map = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getAuthor));

        List<Book> list = books.stream()
                .filter(book -> book.getPageNumber() > 100)
                .collect(Collectors.toList());
    }
}
