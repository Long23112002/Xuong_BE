package com.example.stringboot_hieugui.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductBrandResponse {
    private ProductDetailResponse productDetailResponse;
    private List<String> listBrandName;
}
