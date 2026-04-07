package com.ecommerce.order_service.dto.clients;


public class UserDto {
    private Integer id;
    private String username;

    private String email;

    private String password;

    private int age;

    private Double walletAmount;

    public UserDto() {}

    public UserDto(String username, String email, String password, int age, Double walletAmount) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.walletAmount = walletAmount;
    }

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public Double getWalletAmount() {
        return walletAmount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWalletAmount(Double walletAmount) {
        this.walletAmount = walletAmount;
    }
}
