package com.inventory.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "ingredient")
public class Ingredient {
    @Id
    private Long id;
    private String nutrition;
    private String name;

    public Ingredient() {
    }
    public Ingredient(Long id, String nutrition, String name) {
        this.id = id;
        this.nutrition = nutrition;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
