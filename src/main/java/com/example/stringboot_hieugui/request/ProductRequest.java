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
    @NotNull(message = "ID brand must not be null")
    @Positive(message = "ID brand must be positive or zero")
    private Long idBrand;
    @NotNull(message = "ID subcategory must not be null")
    @Positive(message = "ID subcategory must be positive or zero")
    private Long idSubCategory;
    @NotNull(message = "ID Status must not be null")
    @Positive(message = "ID Status must be positive or zero")
    private Long idStatus;
}
