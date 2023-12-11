package com.example.stringboot_hieugui.service;


import com.example.stringboot_hieugui.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAllProductDetailResponse();

    Page<ProductResponse> findAllProductDetailResponsePage(Pageable pageable);
}
