package com.tech.tnshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Table(name = "sale_event")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleEvent {

    @Id
    private String id;

    @Column
    private String eventName;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    @CreationTimestamp
    private LocalDate createDate;

    @Column
    @UpdateTimestamp
    private LocalDate updateDate;

    @OneToMany(mappedBy = "saleEventProduct", cascade = CascadeType.DETACH)
    private List<Product> listProductSaleEvent;
}
