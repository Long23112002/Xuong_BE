package com.example.stringboot_hieugui.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private Long idBrand;

    @NotBlank(message = "Brand code is required")
    @Column(name = "brand_name")
    private String brandName;

    @ManyToMany(fetch = FetchType.LAZY ,  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "id_brand"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<Product> listProduct;

}
