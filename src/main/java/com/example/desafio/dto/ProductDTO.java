package com.example.desafio.dto;

public class ProductDTO {
    private String name;
    private String category;
    private String brand;
    private Integer price;
    private Integer stock;
    private Boolean freeShipping;
    private String prestige;

    public ProductDTO() {
    }

    public ProductDTO(String name, String category, String brand, Integer price, Integer stock, Boolean freeShipping, String prestige) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getPrestige() {
        return prestige;
    }

    public void setPrestige(String prestige) {
        this.prestige = prestige;
    }
}
