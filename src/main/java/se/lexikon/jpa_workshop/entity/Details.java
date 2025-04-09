package se.lexikon.jpa_workshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String name;
    private LocalDate birthDate;

}
