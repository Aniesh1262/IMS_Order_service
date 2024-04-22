package com.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Long product_id;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int stockQuantity;
    private CategoryDTO category;
    private List<ImageDTO> images;
}
