package se.lexikon.jpa_workshop.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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



    }

}
