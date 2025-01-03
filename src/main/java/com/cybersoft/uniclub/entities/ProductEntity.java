package com.cybersoft.uniclub.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="information")
    private String information;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="id_brand")
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private List<VariantEntity> variants;

}
