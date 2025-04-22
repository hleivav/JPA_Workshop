package se.lexikon.jpa_workshop.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexikon.jpa_workshop.entity.AppUser;
import se.lexikon.jpa_workshop.entity.Book;
import se.lexikon.jpa_workshop.entity.BookLoan;
import se.lexikon.jpa_workshop.repository.BookLoanRepository;
import se.lexikon.jpa_workshop.repository.BookRepository;

@Service
public class BookLoanService {

    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookLoanService(BookLoanRepository bookLoanRepository, BookRepository bookRepository) {
        this.bookLoanRepository = bookLoanRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public BookLoan createBookLoan(Book book, AppUser appUser) {
        if (!book.isAvailable()){
            throw new IllegalStateException("Book is not available");
        }
        BookLoan bookLoan = new BookLoan(false, appUser, book);

        bookRepository.updateBookStatus(book, false);
        bookRepository.save(book);

        return bookLoanRepository.save(bookLoan);
    }

}
