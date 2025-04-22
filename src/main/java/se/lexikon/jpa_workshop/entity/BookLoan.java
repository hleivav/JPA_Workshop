package se.lexikon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;
    @ManyToOne
    private AppUser borrower;
    @ManyToOne
    private Book book;

    //Another constructor to catch the value of dueDate.
    public BookLoan( boolean returned, AppUser borrower, Book book) {
        this.loanDate = LocalDate.now();
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
        this.dueDate = loanDate.minusDays(book.getMaxLoanDays());
    }
}
