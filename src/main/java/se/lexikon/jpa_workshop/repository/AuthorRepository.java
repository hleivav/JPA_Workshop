package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.Author;

public interface AuthorRepository  extends CrudRepository<Author, Integer> {



}
