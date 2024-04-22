package com.orderService.models;

import lombok.Data;

@Data
public class CartDTO {
    private ProductDetailDTO product;
    private Integer quantity;


}
