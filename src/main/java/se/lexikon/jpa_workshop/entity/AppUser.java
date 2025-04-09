package se.lexikon.jpa_workshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

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

    public AppUser(String username, String password, LocalDate regDate, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }
}
