package com.example.stringboot_hieugui.repository;

import com.example.stringboot_hieugui.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findBySubCateName(String subCateName);

    @Query(nativeQuery = true, value = "select sub_cate_name from sub_category")
    List<String> findAllSubCateName();
}
