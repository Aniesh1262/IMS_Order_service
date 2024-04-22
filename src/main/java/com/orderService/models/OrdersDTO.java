package com.orderService.models;

import lombok.Data;

import java.util.List;

@Data
public class OrdersDTO {
    private List<CartDTO> cartItems;
    private Float amount;
    private Long userId;

    // getters and setters
    public List<CartDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
