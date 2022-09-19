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
@Table(name = "container_garbage")
public class ContainerGarbage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_container")
    Container containerGarbageIdPerson;

    @ManyToOne
    @JoinColumn(name = "id_garbage")
    Garbage containerGarbageIdContainer;
}
