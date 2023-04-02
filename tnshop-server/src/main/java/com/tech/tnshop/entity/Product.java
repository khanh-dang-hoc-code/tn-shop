package com.tech.tnshop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;
    @Column
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private int quantity;
    @Column
    private BigDecimal price;
    @Column
    private BigDecimal priceSold;
    @Column
    @CreationTimestamp
    private LocalDate createDate;

    @Column
    @UpdateTimestamp
    private LocalDate updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "reviewProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewProductList;


    @OneToOne(mappedBy = "productOrderItem", cascade = CascadeType.DETACH)
    private OrderItems orderItemProduct;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_event_id")
    private SaleEvent saleEventProduct;

    @OneToMany(mappedBy = "productImage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImageList;
}
