package com.example.stringboot_hieugui.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @NotBlank(message = "Category code is required")
    @Size(max = 255 , message = "Category code must be less than 255 characters")
    @Column(name = "cate_code")
    private String cateCode;

    @NotBlank(message = "Category name is required")
    @Size(max = 100 , message = "Category name must be less than 255 characters")
    @Column(name = "cate_name")
    private String cateName;

    @OneToMany(mappedBy = "category" , cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private List<SubCategory> listSubCategory;
}
