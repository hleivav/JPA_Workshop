package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.BookLoan;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {

}
