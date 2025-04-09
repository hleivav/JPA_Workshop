package se.lexikon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {



}
