package se.lexikon.jpa_workshop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book) {
        this.books.add(book);
    }
    public void removeBook(Book book) {
        this.books.remove(book);
    }

}
