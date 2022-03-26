import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int pageNumber;
    private LocalDate publishDate;

    public Book(String title, String author, int pageNumber, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", publishDate=" + publishDate +
                '}';
    }
}
