package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.response.ProductResponse;
import com.example.stringboot_hieugui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        List<ProductResponse> listProductDetailResponse = productService.findAllProductDetailResponse();
        if(listProductDetailResponse != null) {
            return ResponseEntity.ok(listProductDetailResponse);
        }
        return ResponseEntity.badRequest().body("Not found");
    }

    @GetMapping("/getAllProductNamePage")
    public ResponseEntity<?> getAllProductName(Pageable pageable) {
        Page<ProductResponse> listProductDetailResponse = productService.findAllProductDetailResponsePage(pageable);
        if(listProductDetailResponse != null) {
            return ResponseEntity.ok(listProductDetailResponse);
        }
        return ResponseEntity.badRequest().body("Not found");
    }




}
