package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin("*")
public class BrandController {
    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrandName")
    public ResponseEntity<?> findAllBrandName() {
        return ResponseEntity.ok(brandService.findAllBrandName());
    }
}
