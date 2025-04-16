package se.lexikon.jpa_workshop.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String title;
    private int maxLoanDays;

    @OneToMany(mappedBy = "book")
    private Set<BookLoan> bookLoanList = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }
}
