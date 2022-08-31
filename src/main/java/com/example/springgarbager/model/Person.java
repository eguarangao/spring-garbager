package com.example.springgarbager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "firstName",length = 45)
    String firstName;

    @Column(name = "lastName",length = 45)
    String lastName;

    @Column(name = "userName",length = 45)
    String userName;

    @Column(name = "password",length = 45)
    String password;
}
