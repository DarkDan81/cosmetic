package com.costetics.backend.classes;

import javax.persistence.*;

@Entity(name = "Sub_Category")
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Category category;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public SubCategory() {
    }

    public SubCategory(Long id, Category category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public SubCategory(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}