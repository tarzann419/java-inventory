package com.inventory.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "drink")
//or @Entity(name = "drink")
public class Drink {
    @Id
    private Long id;
    private String name;
    private int capacity;
    private String color;
    private String type;
    private String company;

    public Drink() {
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToMany
    private List<Ingredient> ingredients;
    public Drink(Long id, String name, int capacity, String color, String type, String company, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.color = color;
        this.type = type;
        this.company = company;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
