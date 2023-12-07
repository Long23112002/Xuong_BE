package com.example.stringboot_hieugui.repository;

import com.example.stringboot_hieugui.entity.Product;
import com.example.stringboot_hieugui.response.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.example.stringboot_hieugui.response.ProductDetailResponse(p.produceName, b.brandName, sc.subCateName, p.sellPrice, s.statusName) " +
            "FROM Product p " +
            "JOIN p.subCategory sc " +
            "JOIN p.status s " +
            "JOIN p.listBrand b")
    List<ProductDetailResponse> findAllProductDetailResponse();


}
