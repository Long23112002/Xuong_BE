package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subCategory")
@CrossOrigin("*")
public class SubCategoryController {
    private SubCategoryService subCategoryService;

    @Autowired
    public void setSubCategoryService(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/getAllsubCategoryName")
    public ResponseEntity<?> findAllSubCategoryName() {
        return ResponseEntity.ok(subCategoryService.findAllSubCategoryName());
    }
}
