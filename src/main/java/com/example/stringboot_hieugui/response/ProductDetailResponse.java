package com.example.stringboot_hieugui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponse {
    private String productName;
    private String color;
    private Long quantity;
    private Double sellPrice;
    private Double originPrice;
    private String subCategoryName;
    private String statusName;
}
