package com.tech.tnshop.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewProductRequest {

    @NotNull
    @JsonProperty("brandId")
    private String brandId;


    @JsonProperty("categoryId")
    private String categoryId;
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("quantity")
    private int quantity;


    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("priceSold")
    private BigDecimal priceSold;
}
