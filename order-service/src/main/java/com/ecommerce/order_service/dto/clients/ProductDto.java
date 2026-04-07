package com.ecommerce.order_service.dto.clients;

public class ProductDto {
    private  String name;
    private  Double price;
    private  Double availableQuantity;

    public ProductDto() {}

    public ProductDto(String name, Double price, Double availableQuantity) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }
}
