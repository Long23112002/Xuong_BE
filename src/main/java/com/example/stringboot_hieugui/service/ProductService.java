package com.example.stringboot_hieugui.service;


import com.example.stringboot_hieugui.response.ProductDetailResponse;

import java.util.List;

public interface ProductService {

    List<ProductDetailResponse> findAllProductDetailResponse();
}
