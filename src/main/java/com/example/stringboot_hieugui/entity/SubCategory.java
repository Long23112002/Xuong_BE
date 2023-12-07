package com.example.stringboot_hieugui.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "sub_category")
@Data
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_cate")
    private Long idSubCate;

    @NotNull(message = "Sub category code is required")
    @Column(name = "sub_cate_code")
    private String subCateCode;

    @NotNull(message = "Sub category name is required")
    @Column(name = "sub_cate_name")
    private String subCateName;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "subCategory" , cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private List<Product> listSubCategory;
}
