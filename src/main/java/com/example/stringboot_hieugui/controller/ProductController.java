package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.request.ProductRequest;
import com.example.stringboot_hieugui.response.ProductResponse;
import com.example.stringboot_hieugui.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        if (listProductDetailResponse != null) {
            return ResponseEntity.ok(listProductDetailResponse);
        }
        return ResponseEntity.badRequest().body("Not found");
    }

    @GetMapping("/getAllProductNamePage")
    public ResponseEntity<?> getAllProductName(Pageable pageable) {
        Page<ProductResponse> listProductDetailResponse = productService.findAllProductDetailResponsePage(pageable);
        if (listProductDetailResponse != null) {
            return ResponseEntity.ok(listProductDetailResponse);
        }
        return ResponseEntity.badRequest().body("Not found");
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductRequest productRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMessages);
        }
        String result = productService.saveProduct(productRequest);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body("Not found");

    }
}
