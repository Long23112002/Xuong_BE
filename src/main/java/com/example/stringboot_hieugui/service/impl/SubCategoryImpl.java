package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.SubCategoryRepository;
import com.example.stringboot_hieugui.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryImpl implements SubCategoryService {

    private SubCategoryRepository subCategoryRepository;
    @Autowired
    public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<String> findAllSubCategoryName() {
        return subCategoryRepository.findAllSubCateName();
    }
}
