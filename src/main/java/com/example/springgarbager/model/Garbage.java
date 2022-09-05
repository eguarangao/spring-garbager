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
@Table(name = "garbage")
public class Garbage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;

    @Column(name = "description",length = 45)
    String description;

    @ManyToOne
    @JoinColumn(name = "garbage_id_container")
    Container garbageIdContainer;
}
