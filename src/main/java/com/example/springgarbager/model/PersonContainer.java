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
@Table(name = "persona_container")
public class PersonContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "personContainerIdPerson")
    Person personContainerIdPerson;

    @ManyToOne
    @JoinColumn(name = "personContainerIdContainer")
    Container personContainerIdContainer;
}
