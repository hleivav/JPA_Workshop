package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {



}
