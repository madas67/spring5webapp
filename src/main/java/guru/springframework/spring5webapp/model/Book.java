package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher  publisher;

    public Book() {
        System.out.println("empty Book constructor");
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
        System.out.println("constructor Book{Title[" + title + "], ISBN[" + isbn + "]}");
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
//                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Book.equals()");
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        System.out.println("Book.hashcode()" + (getId() ^ (getId() >>> 32)));
        return (int) (getId() ^ (getId() >>> 32));
    }
}
