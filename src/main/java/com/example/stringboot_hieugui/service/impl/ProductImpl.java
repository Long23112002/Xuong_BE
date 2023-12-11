package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.ProductRepository;
import com.example.stringboot_hieugui.response.ProductResponse;
import com.example.stringboot_hieugui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<ProductResponse> findAllProductDetailResponse() {
        List<ProductResponse> listProductDetailResponse = productRepository.findAllProductDetailResponse();
        if (listProductDetailResponse != null) {
            return listProductDetailResponse;
        }
        return null;
    }

    @Override
    public Page<ProductResponse> findAllProductDetailResponsePage(Pageable pageable) {
        Page<ProductResponse> pageProductDetailResponse = productRepository.findAllProductDetailResponsePage(pageable);
        if (pageProductDetailResponse != null) {
            return pageProductDetailResponse;
        }
        return null;
    }
}
