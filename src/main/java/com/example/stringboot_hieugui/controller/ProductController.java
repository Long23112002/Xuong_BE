package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getAllProductName")
    public ResponseEntity<?> getAllProductName() {
        List<ProductDetailResponse> listProductDetailResponse = productService.findAllProductDetailResponse();
        if(listProductDetailResponse != null) {
            return ResponseEntity.ok(listProductDetailResponse);
        }
        return ResponseEntity.badRequest().body("Not found");
    }

}