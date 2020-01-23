package com.sapient.assignment.sapientassignment.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTINFO")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="productname")
    private String productName;

    @Column(name="type")
    private String productType;

    @Column(name="instockqty")
    private Integer inStockQuantity;

    @Column(name="retailprice")
    private Double retailPrice;

    @Column(name="sku")
    private String productSKU;


}
