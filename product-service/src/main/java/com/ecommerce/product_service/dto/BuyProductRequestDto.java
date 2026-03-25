package com.ecommerce.product_service.dto;

public class BuyProductRequestDto {
    private String productName;
    private Double quantity;
    private Double userWalletAmount;

    public BuyProductRequestDto(String productName, Double quantity, Double userWalletAmount) {
        this.productName = productName;
        this.quantity = quantity;
        this.userWalletAmount = userWalletAmount;
    }

    public String getProductName() {
        return productName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getUserWalletAmount() {
        return userWalletAmount;
    }
}
