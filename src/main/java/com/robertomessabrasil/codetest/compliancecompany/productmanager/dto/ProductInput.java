package com.robertomessabrasil.codetest.compliancecompany.productmanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductInput {

    private long id;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String name;

    @Positive
    private float price;

    @NotEmpty
    private String available;

    private String description;

    @Positive
    private long categoryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotEmpty @Size(min = 5, max = 20) String getName() {
        return name;
    }

    public void setName(@NotEmpty @Size(min = 5, max = 20) String name) {
        this.name = name;
    }

    @Positive
    public float getPrice() {
        return price;
    }

    public void setPrice(@Positive float price) {
        this.price = price;
    }

    public @NotEmpty String getAvailable() {
        return available;
    }

    public void setAvailable(@NotEmpty String available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Positive
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@Positive long categoryId) {
        this.categoryId = categoryId;
    }
}
