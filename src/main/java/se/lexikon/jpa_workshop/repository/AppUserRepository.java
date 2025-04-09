package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {



}
