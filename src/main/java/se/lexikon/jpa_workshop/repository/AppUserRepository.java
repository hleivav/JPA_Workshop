package se.lexikon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexikon.jpa_workshop.entity.AppUser;

import java.time.LocalDate;
import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsername(String username);
    LocalDate startDate = LocalDate.of(2025,2,1);
    LocalDate endDate = LocalDate.of(2025,3,1);
    List<AppUser> findByRegDateBetween(LocalDate startDate, LocalDate endDate);
    List<AppUser> findByUserDetails_Id(int id);
}
