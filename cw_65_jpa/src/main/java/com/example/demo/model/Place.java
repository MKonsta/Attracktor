package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128)
    private String name;
    @Column(length = 128)
    private String address;
    @Column(length = 128)
    private String image;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place")
    @OrderBy("name ASC")
    List<Food> foods;
}
