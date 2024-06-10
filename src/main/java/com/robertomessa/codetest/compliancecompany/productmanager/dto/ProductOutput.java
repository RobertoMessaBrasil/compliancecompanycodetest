package com.robertomessa.codetest.compliancecompany.productmanager.dto;

import java.util.List;

public class ProductOutput {

    private long id;
    private String name;
    private float price;
    private String available;
    private String description;
    private List<CategoryOutput> categories;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryOutput> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryOutput> categories) {
        this.categories = categories;
    }
}
