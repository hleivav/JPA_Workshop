package se.lexikon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexikon.jpa_workshop.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {

    BookLoan findByBorrowerId(int borrowerId);
    BookLoan findByBookId(int bookId);
    List<BookLoan> findAllByReturned(boolean returned);
    @Query(value = "select bl from BookLoan bl where bl.dueDate < CURRENT DATE ")
    List<BookLoan> selectOverdueBookLoans();
    List<BookLoan> findAllByLoanDateBetween(LocalDate startDate, LocalDate endDate);
    @Modifying
    @Query(value = "update BookLoan bl set bl.returned = true where bl.id = :id")
    int markABookAsReturnedByLoanId(@Param("id")int loanId);

}
