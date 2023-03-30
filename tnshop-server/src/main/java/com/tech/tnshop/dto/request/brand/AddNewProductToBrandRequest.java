package com.tech.tnshop.dto.request.brand;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.tnshop.dto.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewProductToBrandRequest {
    @JsonProperty("id")
    private String brandId;

    @JsonProperty("product")
    private ProductRequest productRequest;
}
