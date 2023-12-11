package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/productDetail")
public class ProductDetailController {

    private ProductDetailService productDetailService;
    @Autowired
    public void setProductDetailService(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/getAllProductDetail/{id}")
    public ResponseEntity<?> getAllProductDetail(@PathVariable Long id) {
        Optional<ProductDetailResponse> productDetailResponse = Optional.ofNullable(productDetailService.findProductDetailResponseById(id));
        return ResponseEntity.ok(productDetailResponse);
    }
}
