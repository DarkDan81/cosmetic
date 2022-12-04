package com.costetics.backend.classes;

import javax.persistence.*;

//TODO: Переименовать в Тип продукта

@Entity(name = "Subsub_Category")
@Table(name = "subsub_category")
public class SubsubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "sub_category_id",
            nullable = false
    )
    private SubCategory subCategory;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public SubsubCategory() {
    }

    public SubsubCategory(Long id, SubCategory subCategory, String name) {
        this.id = id;
        this.subCategory = subCategory;
        this.name = name;
    }

    public SubsubCategory(SubCategory subCategory, String name) {
        this.subCategory = subCategory;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubsubCategory{" +
                "id=" + id +
                ", subCategory=" + subCategory +
                ", name='" + name + '\'' +
                '}';
    }
}