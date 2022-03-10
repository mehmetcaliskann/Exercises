import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Book book1 = new Book("Lord of The Rings", 586, "Lord Tolkien", LocalDate.parse("2018-10-23"));
        Book book2 = new Book("Queen of The Rings", 254, "Queen Tolkien", LocalDate.parse("2015-02-17"));
        Book book3 = new Book("Soldier of The Rings", 637, "Soldier Tolkien", LocalDate.parse("2006-10-28"));
        Book book4 = new Book("King of The Rings", 127, "King Tolkien", LocalDate.parse("2019-12-01"));
        Book book5 = new Book("Empress of The Rings", 893, "Empress Tolkien", LocalDate.parse("2020-05-12"));

        TreeSet<Book> books = new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book book : books) {
            System.out.printf("Book Title: %-30s Page Number: %d\n", book.getTitle(), book.getPageNumber());
        }

        TreeSet<Book> books2 = new TreeSet<>(Comparator.comparingInt(Book::getPageNumber));

        System.out.println("\n-------------------------------------------\n");

        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        for (Book book : books2) {
            System.out.printf("Book Title: %-30s Page Number: %d\n", book.getTitle(), book.getPageNumber());
        }
    }
}
