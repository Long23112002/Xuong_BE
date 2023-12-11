package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.ProductRepository;
import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.service.ProductDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetail_Impl implements ProductDetailService {

    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDetailResponse findProductDetailResponseById(Long id) {
        Optional<ProductDetailResponse> productDetailResponse = productRepository.findProductDetailResponseById(id);
        return productDetailResponse.orElseThrow(() ->new EntityNotFoundException("Product not found " + id));
    }
}
