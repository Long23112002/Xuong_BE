package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.entity.Brand;
import com.example.stringboot_hieugui.entity.SubCategory;
import com.example.stringboot_hieugui.repository.BrandRepository;
import com.example.stringboot_hieugui.repository.ProductRepository;
import com.example.stringboot_hieugui.repository.SubCategoryRepository;
import com.example.stringboot_hieugui.response.ProductBrandResponse;
import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.service.ProductDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDetail_Impl implements ProductDetailService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    private BrandRepository brandRepository;

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public ProductBrandResponse findProductDetailResponseById(Long id) {
        Optional<SubCategory> subCateName = subCategoryRepository.findById(id);
        List<String> brandName = brandRepository.findBrandNameByidProduct(id);
        Optional<ProductDetailResponse> productDetail = productRepository.findProductDetailResponseById(id);

        ProductDetailResponse productDetailResponse = null;
        if (subCateName.isPresent() && productDetail.isPresent()) {
            productDetailResponse = new ProductDetailResponse();
            productDetailResponse.setProductName(productDetail.get().getProductName());
            productDetailResponse.setColor(productDetail.get().getColor());
            productDetailResponse.setQuantity(productDetail.get().getQuantity());
            productDetailResponse.setSellPrice(productDetail.get().getSellPrice());
            productDetailResponse.setOriginPrice(productDetail.get().getOriginPrice());
            productDetailResponse.setSubCategoryName(subCateName.get().getSubCateName());
            productDetailResponse.setStatusName(productDetail.get().getStatusName());
        }
        ProductBrandResponse productBrandResponse = new ProductBrandResponse();
        productBrandResponse.setListBrandName(brandName);
        productBrandResponse.setProductDetailResponse(productDetail.get());
        return productBrandResponse;
    }

}
