package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByIsbn(String isbn);
    List<Book> findAllByTitleContains(String title);
    List<Book> findAllByMaxLoanDaysLessThan(int maxLoanDays);

}
