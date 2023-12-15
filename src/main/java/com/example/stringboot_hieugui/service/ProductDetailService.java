package com.example.stringboot_hieugui.service;

import com.example.stringboot_hieugui.response.ProductBrandResponse;
import com.example.stringboot_hieugui.response.ProductDetailResponse;

public interface ProductDetailService {

    ProductBrandResponse findProductDetailResponseById(Long id);

}
