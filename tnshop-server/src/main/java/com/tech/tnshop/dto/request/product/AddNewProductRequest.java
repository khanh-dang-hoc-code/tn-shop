package com.tech.tnshop.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.tnshop.dto.request.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewProductRequest {

    @NotNull
    @JsonProperty
    private String brandId;

    @NotNull
    @JsonProperty
    private String categoryId;

    @NotNull
    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @NotNull
    @JsonProperty
    private int quantity;

    @NotNull
    @JsonProperty
    private String size;

    @NotNull
    @JsonProperty
    private String color;

    @NotNull
    @JsonProperty
    private BigDecimal price;

    @NotNull
    @JsonProperty
    private BigDecimal priceSold;
    @JsonProperty
    private List<Image> imageList;
}
