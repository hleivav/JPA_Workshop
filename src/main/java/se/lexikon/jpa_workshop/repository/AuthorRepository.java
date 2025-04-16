package se.lexikon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexikon.jpa_workshop.entity.Author;

import java.util.List;

public interface AuthorRepository  extends CrudRepository<Author, Integer> {

    public List<Author> findAllByFirstName(String firstName);
    public List<Author> findAllByLastName(String lastName);
    @Query(value = "select a from Author a where a.firstName like :name or a.lastName like :name ")
    public List<Author> selectAllByNameContains(@Param("name")String author_name);
    public Author findByBooksId(int bookId);
    @Modifying
    @Query(value = "update Author a set a.firstName = :name where a.id = :id")
    int updateAuthorsName(@Param("id")int id, @Param("name")String author_name);
    void deleteAuthorsById(int id);
}
