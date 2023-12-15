package com.example.stringboot_hieugui.service.impl;

import com.example.stringboot_hieugui.entity.Brand;
import com.example.stringboot_hieugui.entity.Product;
import com.example.stringboot_hieugui.entity.Status;
import com.example.stringboot_hieugui.entity.SubCategory;
import com.example.stringboot_hieugui.repository.BrandRepository;
import com.example.stringboot_hieugui.repository.ProductRepository;
import com.example.stringboot_hieugui.repository.StatusRepository;
import com.example.stringboot_hieugui.repository.SubCategoryRepository;
import com.example.stringboot_hieugui.request.ProductRequest;
import com.example.stringboot_hieugui.response.ProductResponse;
import com.example.stringboot_hieugui.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    private  ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private BrandRepository brandRepository;
    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    private SubCategoryRepository subCategoryRepository;
    @Autowired
    public void setSubCategoryRepository(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    private StatusRepository statusRepository;
    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<ProductResponse> findAllProductDetailResponse() {
        List<ProductResponse> listProductDetailResponse = productRepository.findAllProductDetailResponse();
        if (listProductDetailResponse != null) {
            return listProductDetailResponse;
        }
        return null;
    }

    @Override
    public Page<ProductResponse> findAllProductDetailResponsePage(Pageable pageable) {
        Page<ProductResponse> pageProductDetailResponse = productRepository.findAllProductDetailResponsePage(pageable);
        if (pageProductDetailResponse != null) {
            return pageProductDetailResponse;
        }
        return null;
    }

    @Override
    public String saveProduct(ProductRequest productRequest) {
        Optional<Brand> brandId = brandRepository.findById(productRequest.getIdBrand());
        Optional<SubCategory> subCategoryId = subCategoryRepository.findById(productRequest.getIdSubCategory());
        Optional<Status> statusId = statusRepository.findById(productRequest.getIdStatus());
        if(brandId.isEmpty()){
            return "Brand not found";
        }
        if(subCategoryId.isEmpty()) {
            return "SubCategory not found";
        }
        if(statusId.isEmpty()){
            return "Status not found";
        }
        Product product = new Product();
        product.setProduceName(productRequest.getProductName());
        product.setColor(productRequest.getColor());
        product.setQuantity(productRequest.getQuantity());
        product.setSellPrice(productRequest.getSellPrice());
        product.setOriginPrice(productRequest.getOriginPrice());
        List<Brand> brandList = new ArrayList<>();
        brandList.add(brandId.get());
        product.setListBrand(brandList);
        product.setSubCategory(subCategoryId.get());
        product.setStatus(statusId.get());
        productRepository.save(product);
        return "Thêm thành công";
    }
}
