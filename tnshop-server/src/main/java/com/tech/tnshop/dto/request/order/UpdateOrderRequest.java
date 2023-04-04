package com.tech.tnshop.dto.request.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(allowGetters = true)
public class UpdateOrderRequest {
    @JsonProperty
    @NotNull
    private String id;

    @JsonProperty
    @NotNull
    private List<String> orderItemsIds;
}
