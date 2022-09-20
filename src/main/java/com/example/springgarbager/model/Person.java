package com.example.springgarbager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true, nullable = false)
    private int id;

    @Column(name = "state")
    private int state = 1;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "first_name",length = 45)
    String firstName;

    @Column(name = "last_name",length = 45)
    String lastName;

    @Column(name = "email",length = 45)
    String email;

    @Column(name = "password",length = 45)
    String password;

    @Column(name="verification_code",length = 8, updatable = false)
    private String verificationCode;

    @Column(name = "url_image")
    private String urlImage;
    @PrePersist
    public void PrePersist() {
        registrationDate = LocalDateTime.now();
    }
}
