package com.ecommerce.order_service.dto;

public class OrderDto {

    private String orderName;
    private String username;
    private String productName;
    private Integer quantity;

    public OrderDto() {}

    public OrderDto(String orderName, String username, String productName, Integer quantity) {
        this.orderName = orderName;
        this.username = username;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getUsername() {
        return username;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
