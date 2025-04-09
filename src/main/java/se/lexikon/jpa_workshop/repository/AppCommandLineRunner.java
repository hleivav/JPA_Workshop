package se.lexikon.jpa_workshop.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexikon.jpa_workshop.entity.AppUser;
import se.lexikon.jpa_workshop.entity.Details;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    AppUserRepository appUserRepository;
    DetailsRepository detailsRepository;

    public AppCommandLineRunner(AppUserRepository appUserRepository, DetailsRepository detailsRepository) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");

        Details details1 = new Details("hleiva@hotmail.com", "Hernan Leiva", LocalDate.of(1963,8,30));
        Details details2 = new Details("sebleiva@hotmail.com", "Sebastian Leiva", LocalDate.of(1990,3,18));
        Details details3 = new Details("marley@hotmail.com", "Martin Leiva", LocalDate.of(1993,10,29));

        AppUser appUser1 = new AppUser("herlei", "abc1234", LocalDate.of(2025,1,12), details1);
        AppUser appUser2 = new AppUser("seblei", "efg456", LocalDate.of(2025,1,15), details2);
        AppUser appUser3 = new AppUser("marlei", "hij789", LocalDate.of(2025,1,16), details3);

        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

    }
}
