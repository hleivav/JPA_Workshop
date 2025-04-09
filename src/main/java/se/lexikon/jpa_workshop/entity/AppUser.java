package se.lexikon.jpa_workshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDate regDate;
    @OneToOne
    @JoinColumn(name = "details.id", nullable = false, unique = true)
    private Details userDetails;

}
