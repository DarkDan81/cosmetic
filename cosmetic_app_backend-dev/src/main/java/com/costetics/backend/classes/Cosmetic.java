package com.costetics.backend.classes;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Cosmetic")
@Table(name = "cosmetic")
public class Cosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "owner_id",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long ownerId;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "brand",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String brand;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            columnDefinition = "INT default '0'"
    )
    private int price;

    @Column(
            name = "expired_in",
            columnDefinition = "TIMESTAMP"
    )
    private Timestamp expiredIn;

    @Column(
            name = "open_date",
            columnDefinition = "TIMESTAMP"
    )
    private Timestamp openDate;

    //TODO: Что-то про оттенок

    @Column(
            name = "archived",
            columnDefinition = "TINYINT default '0'"
    )
    private boolean archived;

    @Column(
            name = "favourite",
            columnDefinition = "TINYINT default '0'"
    )
    private boolean favourite;

    @Column(
            name = "animal_tests",
            columnDefinition = "TINYINT default '0'"
    )
    private boolean animalTests;

    @Column(
            name = "size",
            columnDefinition = "INT"
    )
    private Integer size;

    @Column(
            name = "sizeType",
            columnDefinition = "TEXT"
    )
    private String sizeType;

    @Column(
            name = "rating",
            columnDefinition = "TINYINT default '0'"
    )
    private int rating;

    @ManyToOne
    @JoinColumn(
            name = "subsub_category"
    )
    private SubsubCategory subsubCategory;

    @Column(
            name = "photo_url",
            columnDefinition = "TEXT"
    )
    private String photoUrl;

    public Cosmetic() {
    }

    public Cosmetic(Long id, Long ownerId, String name, String brand, String description, int price, Timestamp expiredIn, Timestamp openDate, boolean archived, boolean favourite, boolean animalTests, Integer size, String sizeType, int rating, SubsubCategory subsubCategory, String photoUrl) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.expiredIn = expiredIn;
        this.openDate = openDate;
        this.archived = archived;
        this.favourite = favourite;
        this.animalTests = animalTests;
        this.size = size;
        this.sizeType = sizeType;
        this.rating = rating;
        this.subsubCategory = subsubCategory;
        this.photoUrl = photoUrl;
    }

    public Cosmetic(Long ownerId, String name, String brand, String description, int price, Timestamp expiredIn, Timestamp openDate, boolean archived, boolean favourite, boolean animalTests, Integer size, String sizeType, int rating, SubsubCategory subsubCategory, String photoUrl) {
        this.ownerId = ownerId;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.expiredIn = expiredIn;
        this.openDate = openDate;
        this.archived = archived;
        this.favourite = favourite;
        this.animalTests = animalTests;
        this.size = size;
        this.sizeType = sizeType;
        this.rating = rating;
        this.subsubCategory = subsubCategory;
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(Timestamp expiredIn) {
        this.expiredIn = expiredIn;
    }

    public Timestamp getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public boolean isAnimalTests() {
        return animalTests;
    }

    public void setAnimalTests(boolean animalTests) {
        this.animalTests = animalTests;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public SubsubCategory getSubsubCategory() {
        return subsubCategory;
    }

    public void setSubsubCategory(SubsubCategory subsubCategory) {
        this.subsubCategory = subsubCategory;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Cosmetic{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", expiredIn=" + expiredIn +
                ", openDate=" + openDate +
                ", archived=" + archived +
                ", favourite=" + favourite +
                ", animalTests=" + animalTests +
                ", size=" + size +
                ", sizeType='" + sizeType + '\'' +
                ", rating=" + rating +
                ", subsubCategory=" + subsubCategory +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}