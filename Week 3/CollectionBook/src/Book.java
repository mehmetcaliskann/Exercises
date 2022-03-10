import java.time.LocalDate;

public class Book implements Comparable<Book> {
    private String title;
    private int pageNumber;
    private String author;
    private LocalDate publishDate;

    public Book(String title, int pageNumber, String author, LocalDate publishDate) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book otherBook) {
        return title.compareTo(otherBook.getTitle());
    }
}
