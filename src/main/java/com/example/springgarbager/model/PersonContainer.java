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
@Table(name = "person_container")
public class PersonContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "person_container_id_person")
    Person personContainerIdPerson;

    @ManyToOne
    @JoinColumn(name = "person_container_id_container")
    Container personContainerIdContainer;
}
