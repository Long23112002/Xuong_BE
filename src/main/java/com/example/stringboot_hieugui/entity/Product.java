package com.example.stringboot_hieugui.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @NotBlank(message = "Produce name is required")
    @Size(max = 255, message = "Produce name must be less than 255 characters")
    @Column(name = "produce_name")
    private String produceName;

    @NotBlank(message = "Produce color is required")
    @Size(max = 50, message = "Produce color must be less than 50 characters")
    @Column(name = "color")
    private String color;

    @NotNull(message = "Produce quantity is required")
    @PositiveOrZero(message = "Produce quantity must be a positive or zero value")
    @Column(name = "quantity")
    private Long quantity;

    @PositiveOrZero(message = "Sell price must be a positive or zero value")
    @Column(name = "sell_price")
    private Double sellPrice;

    @PositiveOrZero(message = "Origin price must be a positive or zero value")
    @Column(name = "origin_price")
    private Double originPrice;

    @Size(max = 1000, message = "Description must be at most 1000 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "id_sub_cate")
    private SubCategory subCategory;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY ,  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_brand")
    )
    private List<Brand> listBrand;

}
