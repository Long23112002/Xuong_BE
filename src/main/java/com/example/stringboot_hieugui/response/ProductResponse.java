package com.example.stringboot_hieugui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long idProduct;
    private String productName;
    private String brandName;
    private String subCategoryName;
    private Double price;
    private String statusName;
}
