package com.example.stringboot_hieugui.repository;

import com.example.stringboot_hieugui.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(nativeQuery = true , value = "SELECT brand_name from brand b join  product_brand pb on b.id_brand = pb.id_brand\n" +
            "  join product on pb.id_product = product .id_product\n" +
            "  where product.id_product = :idProduct")
    List<String> findBrandNameByidProduct(Long idProduct);

}
