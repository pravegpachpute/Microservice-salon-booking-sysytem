package com.praveg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int duration;       // kiti vel laghel 1 haircut la ex - 30 minutes

    @Column(nullable = false)
    private Long salonId;

    @Column(nullable = false)
    private Long categoryId;

    private String image;      // salon owner can add image
}
