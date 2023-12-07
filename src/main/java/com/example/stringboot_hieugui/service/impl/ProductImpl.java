package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.ProductRepository;
import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    private  ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDetailResponse> findAllProductDetailResponse() {
        List<ProductDetailResponse> listProdcutDetailResponse = productRepository.findAllProductDetailResponse();
        if (listProdcutDetailResponse != null) {
            return listProdcutDetailResponse;
        }
        return null;
    }
}
