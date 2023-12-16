package com.example.stringboot_hieugui.repository;

import com.example.stringboot_hieugui.entity.Product;
import com.example.stringboot_hieugui.response.ProductDetailResponse;
import com.example.stringboot_hieugui.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.example.stringboot_hieugui.response.ProductResponse(p.idProduct ,p.produceName, b.brandName, sc.subCateName, p.sellPrice, s.statusName) " +
            "FROM Product p " +
            "JOIN p.subCategory sc " +
            "JOIN p.status s " +
            "JOIN p.listBrand b")
    List<ProductResponse> findAllProductDetailResponse();

    @Query("SELECT NEW com.example.stringboot_hieugui.response.ProductResponse(p.idProduct , p.produceName, b.brandName, sc.subCateName, p.sellPrice, s.statusName) " +
            "FROM Product p " +
            "JOIN p.subCategory sc " +
            "JOIN p.status s " +
            "JOIN p.listBrand b")
    Page<ProductResponse> findAllProductDetailResponsePage(Pageable pageable);

    // productDetail

    @Query("SELECT NEW com.example.stringboot_hieugui.response.ProductDetailResponse(p.produceName, p.color, p.quantity, p.sellPrice, p.originPrice, sc.subCateName, s.statusName) " +
            "FROM Product p " +
            "JOIN p.subCategory sc " +
            "JOIN p.status s " +
            "WHERE p.idProduct = :id")
    Optional<ProductDetailResponse> findProductDetailResponseById(Long id);


}
