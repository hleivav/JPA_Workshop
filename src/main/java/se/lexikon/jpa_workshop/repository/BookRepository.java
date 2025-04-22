package se.lexikon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexikon.jpa_workshop.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findByIsbn(String isbn);
    List<Book> findAllByTitleContains(String title);
    List<Book> findAllByMaxLoanDaysLessThan(int maxLoanDays);
    @Modifying
    @Query("update Book b set b.available = :available where b = :book")
    void updateBookStatus(@Param("book") Book book, @Param("available") Boolean available);
}
