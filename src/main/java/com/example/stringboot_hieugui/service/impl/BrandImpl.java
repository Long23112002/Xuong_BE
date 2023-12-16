package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.repository.BrandRepository;
import com.example.stringboot_hieugui.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandImpl implements BrandService {

    private BrandRepository brandRepository;
    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<String> findAllBrandName() {
        return  brandRepository.findAllBrandName();
    }
}
