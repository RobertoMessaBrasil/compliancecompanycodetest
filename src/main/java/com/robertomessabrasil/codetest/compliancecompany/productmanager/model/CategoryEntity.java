package com.robertomessabrasil.codetest.compliancecompany.productmanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    Set<ProductEntity> products;

    public CategoryEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
