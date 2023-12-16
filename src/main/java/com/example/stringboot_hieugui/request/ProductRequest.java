package com.example.stringboot_hieugui.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "Product name must not be null")
    private String productName;
    @NotNull(message = "Color must not be null")
    private String color;
    @Positive(message = "Quantity must be positive or zero")
    private Long quantity;
    @Positive(message = "Sell price must be positive or zero")
    private Double sellPrice;
    @Positive(message = "Origin price must be positive or zero")
    private Double originPrice;
    @NotNull(message = "Brand name must not be null")
    private String brandName;
    @NotNull(message = "Subcategory name must not be null")
    private String subCategoryName;
    @NotNull(message = "Status name must not be null")
    private String statusName;
}
