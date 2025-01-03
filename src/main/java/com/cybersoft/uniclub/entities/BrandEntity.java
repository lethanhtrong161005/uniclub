package com.cybersoft.uniclub.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="brand")
@Data
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<ProductEntity> products;

}
