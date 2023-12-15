package com.example.stringboot_hieugui.response;

import com.example.stringboot_hieugui.entity.Brand;
import lombok.*;

import java.util.List;

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
