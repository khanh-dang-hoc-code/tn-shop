package com.tech.tnshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Entity
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Brand {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column
    private String name;
    @Column
    private String description;

    @Column
    @CreationTimestamp
    private LocalDate createDate;

    @Column
    @UpdateTimestamp
    private LocalDate updateDate;


    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList;

    @OneToMany(mappedBy = "brandImage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BrandImage> brandImageList;
}
