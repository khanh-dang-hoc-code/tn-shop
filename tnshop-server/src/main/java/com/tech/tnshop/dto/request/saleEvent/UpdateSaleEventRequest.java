package com.tech.tnshop.dto.request.saleEvent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @created 02/04/2023 - 17:30
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSaleEventRequest {
    @JsonProperty
    private String id;
}
