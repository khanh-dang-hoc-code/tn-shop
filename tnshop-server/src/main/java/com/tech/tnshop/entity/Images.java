package com.tech.tnshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Images {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column
    @NotNull(message = "Url can not be null")
    private String url;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile imageProfile;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product imageProduct;
}
