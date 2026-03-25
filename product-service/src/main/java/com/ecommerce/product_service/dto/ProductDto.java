package com.ecommerce.product_service.dto;

public class ProductDto {
    private  String name;
    private  String description;
    private String  category;
    private  Double price;
    private  Double availableQuantity;

    public ProductDto() {}

    public ProductDto(String name, String description, Double price, Double availableQuantity, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public String getCategory() {
        return category;
    }
}
