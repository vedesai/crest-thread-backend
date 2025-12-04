// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestthread.api.dto;

import lombok.*;
import java.math.BigDecimal;

/**
 * Product Data Transfer Object
 * Follows Backend Code Standards - DTOs for API communication
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private String imageUrl;
    private String category;
    private Long categoryId;
    private BigDecimal rating;
    private Integer reviewCount;
    private Boolean inStock;
}
// AI Generated Code by Deloitte + Cursor (END)
