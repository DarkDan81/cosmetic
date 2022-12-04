package com.costetics.backend.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class CosmeticSummary {
    private String name;
    private String brand;
    private String description;
    private int price;
    private Timestamp expiredIn;
    private Timestamp openDate;
    private boolean archived;
    private boolean favourite;
    private boolean animalTests;
    private int size;
    private String sizeType;
    private int rating;
    private SubsubCategory subsubCategory;
    private String photoUrl;
}